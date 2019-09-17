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

<title>My JSP 'main.jsp' starting page</title>

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
		text-align: center;
		background-color: #2D2D2D
		
	}
	table{
		border-collapse: collapse;
		width: 1500px;
		height:300px;
		margin: 0 auto;
		border: solid 2px white;
		color:white;
	}
	th,td{
		text-align: center;
	}
	a{
		text-decoration: none;
		color:skyblue;
	}
	a.fy{
		margin-top:20px;	
		display: inline-block;
		background: skyblue;
		color:black;
		width: 50px;
		height:30px;
		line-height: 30px;
		border-bottom-left-radius:8px;
		border-bottom-right-radius:8px;
		border-top-left-radius:8px;
		border-top-right-radius:8px;
	}
	
</style>
</head>

<body>
	<div id="mydiv" style="height:500px;color: white">
		<form action="BookServlet?${fy.url }" method="get">
		图书名称<input type="text" name="bname">
		作者名称<input type="text" name="author">
		<input type="submit" value="搜索"><br><br>
	</form>
	<a href="add.jsp">添加图书</a>
	<table border="1">
				<th>图书ID</th>
				<th>图书名称</th>
				<th>图书作者</th>
				<th>图书价格</th>
				<th>库存量</th>
				<th>图片地址</th>
				<th>图书类别</th>
				<th>出版日期</th>
				<th>图书描述</th>
				<th>上架状态</th>
				<th>操作</th>
		<c:forEach items="${fy.list }" var="book">
			<tr>
				<td>${book.bid }</td>
				<td>${book.bname }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td>${book.count }</td>
				<td>${book.imagurl}</td>
				<td>${book.bclass }</td>
				<td>${book.bdate }</td>
				<td>${book.dsce }</td>
				<td>${book.bflag }</td>
				<td><a href="UpdateServlet?bid=${book.bid }&&param=one&&pageNow=${fy.pageNow}&&url=${fy.url}">修改</a>&nbsp;&nbsp;&nbsp;<a href="DeleteServlet?bid=${book.bid }&pageNow=${fy.pageNow}&url=${fy.url}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<%--分页显示的4种情况 --%>
	<%-- 1. 总数据条数不大于10条--%>
	<c:if test="${fy.page<=10 }">
		<c:set var="begin" value="1"></c:set>
		<c:set var="end" value="${fy.page }"></c:set>
	</c:if>

	<%--2. 总数据条数大于10条 --%>
	<c:if test="${fy.page>10 }">
		<%--2.1 当前页号不大于6 --%>
		<c:if test="${fy.pageNow<=6 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="10"></c:set>
		</c:if>
		<%--2.2当前页号大于6 --%>
		<c:if test="${fy.pageNow>6 }">
			<c:choose>
				<%--2.2.1 到达最后一页了当前页号在最后一页中间的后面 --%>
				<c:when test="${fy.pageNow>=(fy.page-4) }">
					<c:set var="begin" value="${fy.page-9 }"></c:set>
					<c:set var="end" value="${fy.page }"></c:set>
				</c:when>
				<%-- 2.2.2 当前页号在最后一页中间的前面就是总体中间部分的页号 --%>
				<c:otherwise>
					<c:set var="begin" value="${fy.pageNow-5 }"></c:set>
					<c:set var="end" value="${fy.pageNow+4 }"></c:set>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:if>
	<a href="BookServlet?pageNow=${1 }&${fy.url}" class="fy">首页</a>
	<!-- 如果当前页号不为第1页，则存在上一页 -->
	<c:if test="${!(fy.pageNow eq 1) }">
		<a href="BookServlet?pageNow=${fy.pageNow-1 }&${fy.url}" class="fy">上一页</a>
	</c:if>
	
	<!-- 分页页号 -->
	<c:forEach begin="${begin }" end="${end }" var="i">
		<!-- 如果i值为当前页号时，则作为文本显示在页面上 -->
		<c:if test="${fy.pageNow eq i }">
			${i }
		</c:if>
		<c:if test="${!(fy.pageNow eq i) }">
			<a href="BookServlet?pageNow=${i }&${fy.url}" class="fy">${i }</a>
		</c:if>
	</c:forEach>
	
	<!-- 如果当前页号不为最后一页，则存在下一页 -->
	<c:if test="${!(fy.pageNow eq fy.page) }">
		<a href="BookServlet?pageNow=${fy.pageNow+1 }&${fy.url}" class="fy">下一页</a>
	</c:if>
	<a href="BookServlet?pageNow=${fy.page }&${fy.url}" class="fy">末页</a>
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
