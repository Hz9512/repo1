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

<title>My JSP 'buybook.jsp' starting page</title>

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
	background-color: white;
}

div.book {
	margin: 150px 200px;
	width: 800px;
	height: 500px;
	position: relative;
}

p.book {
	position: absolute;
	left: 550px;
	top: 0px;
}

img.book {
	width: 550px;
}

button.book {
	display: inline-block;
	width: 150px;
	height: 35px;
	background: red;
	text-decoration: none;
	text-align: center;
	line-height: 35px;
	border-bottom-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	border-top-left-radius: 10px;
	font-family: "宋体";
	color: white;
	font-size: 20px;
}

a.bookbuy {
	display: inline-block;
	width: 150px;
	height: 35px;
	background: orange;
	text-decoration: none;
	text-align: center;
	line-height: 35px;
	border-bottom-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	border-top-left-radius: 10px;
	font-family: "宋体";
	color: white;
	font-size: 20px;
}

a.myshopcar {
	display: inline-block;
	width: 150px;
	height: 35px;
	text-decoration: none;
	text-align: center;
	line-height: 35px;
	color: black;
	font-size: 15px;
	border: 1px solid #CCCCCC;
	position: relative;
	left: 200px;
	top: -400px;
}
a.safe{
	display: inline-block;
	float: right;
	position: relative;
	top:-40px;
	left:-30px;
}

span.count {
	width: 22px;
	height: 22px;
	background: red;
	border-bottom-left-radius: 50%;
	border-top-right-radius: 50%;
	border-bottom-right-radius: 50%;
	border-top-left-radius: 50%;
	float: right;
	line-height: 22px;
	margin-right: 10px;
	margin-top: 6px;
	color: white;
}

div.car {
	
}
</style>
<script type="text/javascript" src="./js/buybook.js"></script>
</head>

<body>
	<p>欢迎<strong>${username }</strong>登录</p>
	<a class="safe" href="LoginServlet?action=exit">安全退出</a>
	<!-- 背景div -->
	<div id="mydiv" style="height:750px;">

		<div class="book">
			<img class="book" src="${book.imagurl }">
			<p class="book">
				书名：${book.bname }<br> 作者：${book.author }<br>
				价格：${book.price }<br> 库存量：${book.count }<br>
				图书类别：${book.bclass }<br> 出版日期：${book.bdate }<br>
				图书描述：${book.dsce }<br> <br> <br> <br> <br>
				<%-- <a class="book" href="ShopCarServlet?bid=${book.bid }&price=${book.price }">加入购物车</a> --%>
				<button id="btn" class="book" onclick="fbtn()" >加入购物车</button>
				<a class="bookbuy" href="LiJiServlet">立即购买</a> <a class="myshopcar" href="SelectCarServlet?username=${username }"><span class="car">我的购物车</span><span id="count" class="count">${first }</span></a>
			</p>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			//配置
			var config = {
				vx : 4, //小球x轴速度,正为右，负为左
				vy : 4, //小球y轴速度
				height : 2, //小球高宽，其实为正方形，所以不宜太大
				width : 2,
				count : 200, //点个数
				color : "121, 162, 185", //点颜色
				stroke : "130,255,255", //线条颜色
				dist : 6000, //点吸附距离
				e_dist : 20000, //鼠标吸附加速距离
				max_conn : 10
			//点到点最大连接数
			}

			//调用
			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="./js/canvas-particle.js"></script>
</body>
</html>
