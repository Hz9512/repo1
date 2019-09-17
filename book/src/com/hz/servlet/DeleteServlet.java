package com.hz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.Book;
import com.hz.service.DeleteService;
import com.hz.service.impl.DeleteServiceImpl;

public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 2.获取参数
		int bid = Integer.parseInt(request.getParameter("bid"));
		int pageNow=Integer.parseInt(request.getParameter("pageNow"));
		String url=request.getParameter("url");
		Book book = new Book();
		book.setBid(bid);
		//3.调用Service层
		DeleteService ds=new DeleteServiceImpl();
		try {
			ds.delBook(book);
			url = new String(url.getBytes("utf-8"), "iso-8859-1");
			System.out.println("BookServlet?pageNow="+pageNow+"&"+url);
			response.sendRedirect("BookServlet?pageNow="+pageNow+"&"+url);
		} catch (Exception e) {
			request.getSession().setAttribute("result", "操作失败！");
			response.sendRedirect("result.jsp");
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
