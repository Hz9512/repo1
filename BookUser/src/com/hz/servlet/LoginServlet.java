package com.hz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.User;
import com.hz.service.LoginService;
import com.hz.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String param = request.getParameter("action");

		if ("login".equals(param)) {
			this.login(request, response);
		}
		if ("exit".equals(param)) {
			this.exit(request, response);
		}

	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		LoginService ls = new LoginServiceImpl();
		User user2 = ls.checkLogin(user);

		if (user2 != null) {
			try {
				request.getSession().setAttribute("username", username);
				response.sendRedirect("BookServlet?pageNow=1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			 request.getSession().setAttribute("msg", "用户名或密码错误！");
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void exit(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
