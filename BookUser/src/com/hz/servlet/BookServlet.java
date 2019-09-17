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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String pageNowStr = request.getParameter("pageNow");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		int pageNow = 1;
		if (pageNowStr != null) {
			pageNow = Integer.parseInt(pageNowStr);//��ȡpageNow
		}
		Book book = new Book();					//��ȡBook
		book.setBname(bname);
		book.setAuthor(author);
		//����Service��
		BookService bs = new BookServiceImpl();
		FenYe fenYe = bs.queryFenYe(book, pageNow);
		//�Ѳ������FenYe��Ϣ����ǰ̨ҳ������ʾ
		request.getSession().setAttribute("fy", fenYe);
		response.sendRedirect("main.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
