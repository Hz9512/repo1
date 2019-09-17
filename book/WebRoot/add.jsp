<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	text-align: center;
	background-color: #2D2D2D
}

div {
	color:white;
	margin: 130px auto;
}
</style>
</head>

<body>
<div id="mydiv" style="height:500px;">
<form action="AddServlet"　method="post">
		<h1>添加图书</h1>
		<div>
			图书名称&nbsp;&nbsp;&nbsp;<input type="text" name="bname"><br>
			<br> 图书作者&nbsp;&nbsp;&nbsp;<input type="text" name="author"><br>
			<br> 图书价格&nbsp;&nbsp;&nbsp;<input type="text" name="price"><br>
			<br> 库存量　&nbsp;&nbsp;&nbsp;<input type="text" name="count"><br>
			<br> 图片地址&nbsp;&nbsp;&nbsp;<input type="text" name="imagurl"><br>
			<br> 图书类别&nbsp;&nbsp;&nbsp;<input type="text" name="bclass"><br>
			<br> 出版日期&nbsp;&nbsp;&nbsp;<input type="text" name="bdate"><br>
			<br> 图书描述&nbsp;&nbsp;&nbsp;<input type="text" name="dsce"><br>
			<br> 上架状态&nbsp;&nbsp;&nbsp;<input type="text" name="bflag"><br>
			<br> <input type="submit" value="添加图书">
		</div>
	</form>
</div>
	<script type="text/javascript">
		window.onload = function() {
		    //配置
		    var config = {
		        vx: 4,	//小球x轴速度,正为右，负为左
		        vy: 4,	//小球y轴速度
		        height: 2,	//小球高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 200,		//点个数
		        color: "121, 162, 185", 	//点颜色
		        stroke: "130,255,255", 		//线条颜色
		        dist: 6000, 	//点吸附距离
		        e_dist: 20000, 	//鼠标吸附加速距离
		        max_conn: 10 	//点到点最大连接数
		    }

		    //调用
		    CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="./js/canvas-particle.js"></script>
</body>
</html>
