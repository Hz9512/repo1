<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			background: skyblue;
		}
		div.d1{
			height:350px;
			width:300px;
			text-align:center;
			line-height:50px;
			margin:150px auto;
			border: 1px solid green;
			border-top-right-radius:20px;
			border-bottom-left-radius:20px;
			border-top-left-radius:20px;
			border-bottom-right-radius:20px;
		}
		div.login{
			padding-top: 65px;
		}
	</style>
  </head>
  
  <body>
  	<div class="d1">
  		<div>
  			<h1>用户登录</h1>
  		</div>
  		<div class="login">
    	<form action="LoginServlet?action=login" method="post" >
    		用户名：<input type="text" name="username" value="${uname }"><br>
    		密　码：<input type="password" name="pwd" value="${pwd }"><br>
    		${msg }<br>
    		<input type="submit" value="登录">没有帐号？请<a href="regist.jsp">注册</a>
    	</form>
    	</div>
    </div>	
  </body>
</html>
