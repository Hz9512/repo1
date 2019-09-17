<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'shopcar.jsp' starting page</title>

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
	background-color: white;
}

table {
	border-collapse: collapse;
	width: 1500px;
	height: 300px;
	margin: 0 auto;
	border: solid 2px white;
	color: black;
}

th,td {
	text-align: center;
}

a {
	text-decoration: none;
	color: skyblue;
}

a.fy {
	margin-top: 20px;
	display: inline-block;
	background: skyblue;
	color: black;
	width: 50px;
	height: 30px;
	line-height: 30px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
}

a.safe {
	display: inline-block;
	float: right;
	position: relative;
	top: -40px;
	left: -30px;
}
a.qingkong{
	margin-top: 20px;
	display: inline-block;
	background: skyblue;
	color: black;
	width: 100px;
	height: 30px;
	line-height: 30px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	position: relative;
	left: 50px;
	top: -300px;
}
a.safe{
	display: inline-block;
	float: right;
	position: relative;
	top:-40px;
	left:-30px;
}

div.books {
	width: 1100px;
	height: 350px;
	display: inline-block;
	color: black;
}

div.book {
	width: 150px;
	height: 200px;
	display: inline-block;
	margin-left: 50px
}

div.fenye {
	margin-top: 50px;
}

div.ms {
	float: left;
}

img.book {
	width: 183px;
	height: 252px;
	border: 1px solid;
}
#welcome{
	position: relative;
	left: -850px;
}
hr{
	width:100%;
}
</style>
</head>

<body>
	<p id="welcome">欢迎<strong>${username }</strong>登录</p>
	<a class="safe" href="LoginServlet?action=exit">安全退出</a>
	<hr>
	<c:forEach items="${fenYe.list }" var="book">
		<div class="book">
			<a href="BuyBookServlet?bid=${book.bid }" title="${book.dsce }">
				<img class="book" src="${book.imagurl}">
				<p>
					书名：${book.bname }<br> 作者：${book.author }<br>
					价格：${book.price }<br>
				</p>
			</a>
		</div>

	</c:forEach>
	
	<a class="qingkong" href="QingKongServlet?username=${username }">清空购物车</a>
	
	<%--分页显示的4种情况 --%>
	<%-- 1. 总数据条数不大于10条--%>
	<c:if test="${fenYe.page<=10 }">
		<c:set var="begin" value="1"></c:set>
		<c:set var="end" value="${fenYe.page }"></c:set>
	</c:if>

	<%--2. 总数据条数大于10条 --%>
	<c:if test="${fenYe.page>10 }">
		<%--2.1 当前页号不大于6 --%>
		<c:if test="${fenYe.pageNow<=6 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="10"></c:set>
		</c:if>
		<%--2.2当前页号大于6 --%>
		<c:if test="${fenYe.pageNow>6 }">
			<c:choose>
				<%--2.2.1 到达最后一页了当前页号在最后一页中间的后面 --%>
				<c:when test="${fenYe.pageNow>=(fenYe.page-4) }">
					<c:set var="begin" value="${fenYe.page-9 }"></c:set>
					<c:set var="end" value="${fenYe.page }"></c:set>
				</c:when>
				<%-- 2.2.2 当前页号在最后一页中间的前面就是总体中间部分的页号 --%>
				<c:otherwise>
					<c:set var="begin" value="${fenYe.pageNow-5 }"></c:set>
					<c:set var="end" value="${fenYe.pageNow+4 }"></c:set>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:if>
	<div class="fenye">
		<a href="SelectCarServlet?pageNow=${1 }" class="fy">首页</a>
		<!-- 如果当前页号不为第1页，则存在上一页 -->
		<c:if test="${!(fenYe.pageNow eq 1) }">
			<a href="SelectCarServlet?pageNow=${fenYe.pageNow-1 }" class="fy">上一页</a>
		</c:if>

		<!-- 分页页号 -->
		<c:forEach begin="${begin }" end="${end }" var="i">
			<!-- 如果i值为当前页号时，则作为文本显示在页面上 -->
			<c:if test="${fenYe.pageNow eq i }">
			${i }
		</c:if>
			<c:if test="${!(fenYe.pageNow eq i) }">
				<a href="SelectCarServlet?pageNow=${i }" class="fy">${i }</a>
			</c:if>
		</c:forEach>

		<!-- 如果当前页号不为最后一页，则存在下一页 -->
		<c:if test="${!(fenYe.pageNow eq fenYe.page) }">
			<a href="SelectCarServlet?pageNow=${fenYe.pageNow+1 }" class="fy">下一页</a>
		</c:if>
		<a href="SelectCarServlet?pageNow=${fenYe.page }" class="fy">末页</a>
	</div>
	</div>
</body>
</html>
