package com.hz.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.Book;
import com.hz.service.AddService;
import com.hz.service.impl.AddServiceImpl;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.设置编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 2.获取参数
		String bname = req.getParameter("bname");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));
		int count = Integer.parseInt(req.getParameter("count"));
		String imagurl = req.getParameter("imagurl");
		String bclass = req.getParameter("bclass");
		String bdate = req.getParameter("bdate");
		String desc = req.getParameter("dsce");
		int bflag = Integer.parseInt(req.getParameter("bflag"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		if (bdate != null && !"".equals(bdate)) {
			try {
				date = (Date) sdf.parse(bdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Book book = new Book(0, bname, author, price, count, imagurl, bclass, date, desc, bflag);

		// 3.调用Service层
		AddService as = new AddServiceImpl();
		try {
			as.addBook(book);
			req.getSession().setAttribute("result", "添加成功");
			resp.sendRedirect("result.jsp");
		} catch (Exception e) {
			req.getSession().setAttribute("result", "操作失败，请重试！");
			resp.sendRedirect("result.jsp");
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
