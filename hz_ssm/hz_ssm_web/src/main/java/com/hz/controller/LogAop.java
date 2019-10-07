package com.hz.controller;

import com.hz.domain.SysLog;
import com.hz.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class clzz;//访问的类
    private Method method;//访问的方法

    //前置通知 获取开始时间，执行的类是哪一个，哪一个方法
    @Before("execution(* com.hz.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间
        clzz = joinPoint.getTarget().getClass();//当前具体访问的类
        String methodName = joinPoint.getSignature().getName();//获取访问的方法名称
        Object[] args = joinPoint.getArgs();//获取方法参数

        //获取具体执行的方法的method对象
        if (args == null || args.length == 0) {
            method = clzz.getMethod(methodName);//只能获取无参数方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clzz.getMethod(methodName, classArgs);
        }

    }

    //后置通知
    @After("execution(* com.hz.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        long time = new Date().getTime() - visitTime.getTime();//获取访问时长

        //获取url
        String url = "";
        if (clzz != null && method != null && clzz != LogAop.class && clzz != SysLogController.class) {
            //1.获取类上的注解值
            RequestMapping clzzAnnotation = (RequestMapping) clzz.getAnnotation(RequestMapping.class);
            if (clzzAnnotation != null) {
                String[] classValue = clzzAnnotation.value();
                //2.获取方法上的注解值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    //获取访问的ID地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装在SysLog对象中
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + clzz.getName() + "[方法名 ]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用Service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }


    }
}
