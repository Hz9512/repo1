package com.hz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.Book;
import com.hz.service.BuyBookService;
import com.hz.service.SelectCarService;
import com.hz.service.impl.BuyBookServiceImpl;
import com.hz.service.impl.SelectCarServiceImpl;

public class BuyBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int bid = Integer.parseInt(request.getParameter("bid"));
		BuyBookService bbs = new BuyBookServiceImpl();
		Book book = bbs.getBook(bid);
		request.getSession().setAttribute("book", book);

		SelectCarService scs = new SelectCarServiceImpl();
		String username=(String) request.getSession().getAttribute("username");
		int count = scs.selectCount(username);
		request.getSession().setAttribute("first", count);

		response.sendRedirect("buybook.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
