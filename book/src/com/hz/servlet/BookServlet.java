package com.hz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.service.BookService;
import com.hz.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取参数
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String getPageNow = request.getParameter("pageNow");
		System.out.println(bname+"ooooooooooooooooooo");
		// 设置值
		int pageNow = 1;
		if (getPageNow != null) {
			pageNow = Integer.parseInt(getPageNow);
		}
		Book book = new Book();
		book.setBname(bname);
		book.setAuthor(author);
		System.out.println();
		// 调用service层
		BookService bc = new BookServiceImpl();
		String bname1 = book.getBname();
		
		FenYe fenYe = bc.queryFenYe(pageNow, book);
		// 把查询出来的分页信息对象存放到session域里面
		request.getSession().setAttribute("fy", fenYe);
		// 跳转到主页面
		response.sendRedirect("main.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
