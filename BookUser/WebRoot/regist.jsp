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
	<script type="text/javascript" src="./js/regist.js"></script>
	<style type="text/css">
		body{
			background: skyblue;
		}
		div.d1{
			height:450px;
			width:600px;
			text-align:center;
			line-height:50px;
			margin:150px auto;
			border: 1px solid green;
			border-top-right-radius:20px;
			border-bottom-left-radius:20px;
			border-top-left-radius:20px;
			border-bottom-right-radius:20px;
		}
		div.regist{
			padding-top: 65px;
		}
	</style>
  </head>
  
  <body>
  	<div class="d1">
  		<div>
  			<h1>用户注册</h1>
  		</div>
  		<div class="regist">
    	<form action="RegistServlet?action=regist" method="post">
    		用户名：<input type="text" name="username"><span id="span1"></span><br>
    		密　码：<input type="password" name="pwd"><br>
    		住　址：<input type="text" name="address"><br>
    		电　话：<input type="text" name="phone"><br>
    		选择VIP级别：<input type="radio" name="vip" value="0">不成为VIP<input type="radio" name="vip" value="1">1级 <input type="radio" name="vip" value="2">2级<br>
    		<input type="submit" value="注册">
    	</form>
    	</div>
    </div>	
  </body>
</html>
