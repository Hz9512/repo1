<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  	<form action="UpdateServlet"　method="post">
  		<h1>修改图书</h1>
		<div>
			图书ID　&nbsp;&nbsp;&nbsp;<input type="text" name="bid" readonly="readonly" value="${book.bid }"><br><br>
			图书名称&nbsp;&nbsp;&nbsp;<input type="text" name="bname" value="${book.bname }"><br><br>
			图书作者&nbsp;&nbsp;&nbsp;<input type="text" name="author" value="${book.author }"><br><br>
			图书价格&nbsp;&nbsp;&nbsp;<input type="text" name="price" value="${book.price  }"><br><br>
			库存量　&nbsp;&nbsp;&nbsp;<input type="text" name="count" value="${book.count }"><br><br>
			图片地址&nbsp;&nbsp;&nbsp;<input type="text" name="imagurl" value="${book.imagurl }"><br><br>
			图书类别&nbsp;&nbsp;&nbsp;<input type="text" name="bclass" value="${book.bclass }"><br><br>
			出版日期&nbsp;&nbsp;&nbsp;<input type="text" name="bdate" value="${book.bdate }"><br><br>
			图书描述&nbsp;&nbsp;&nbsp;<input type="text" name="dsce" value="${book.dsce }"><br><br>
			上架状态&nbsp;&nbsp;&nbsp;<input id="flag" type="text" name="bflag" value="${book.bflag }"><br><br>
			<input id="btn" type="submit" value="确认修改">
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
		    /*
		    var flag = document.getElementById("flag");
		    var btn=document.getElementById("btn");
		    var value=document.getElementByID("flag").value;
		    btn.onclick=fn();
		    function fn(){
		    	alert("2121");
		    }
		     btn.addEventListener("click", showMsg, false); //鼠标单击的时候调用showMes这个函数  
		    function showMsg() {
		        /* if(value==""){
		        	alert("上架状态不可为空");
		        }
		        if(value!=1&&value!=2){
		        	alert("上架状态参数为1或2");
		        } 
		        
		    } */
		}
	</script>
	<script type="text/javascript" src="./js/canvas-particle.js"></script>
  </body>
</html>
