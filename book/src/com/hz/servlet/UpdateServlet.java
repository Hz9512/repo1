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
import com.hz.pojo.FenYe;
import com.hz.service.UpdateService;
import com.hz.service.impl.UpdateServiceImpl;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String param = req.getParameter("param");
		
		UpdateService us = new UpdateServiceImpl();
		if (param != null && !"".equals(param)) {
			// 获取参数
			int bid = Integer.parseInt(req.getParameter("bid"));
			int pageNow=Integer.parseInt(req.getParameter("pageNow"));
			String url=req.getParameter("url");
			req.getSession().setAttribute("pageNow", pageNow);
			req.getSession().setAttribute("url", url);
			//根据id去或查找这个book
			Book book = us.getBook(bid);
			req.getSession().setAttribute("book", book);
			
			resp.sendRedirect("update.jsp");
		} else {
			//获取修改后的所有book属性
			Integer bid = Integer.parseInt(req.getParameter("bid"));
			String bname = req.getParameter("bname");
			String author = req.getParameter("author");
			Double price = Double.parseDouble(req.getParameter("price"));
			Integer count = Integer.parseInt(req.getParameter("count"));
			String imagurl = req.getParameter("imagurl");
			String bclass = req.getParameter("bclass");
			String bdate = req.getParameter("bdate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			if (bdate != null && !"".equals(bdate)) {
				try {
					date = (Date) sdf.parse(bdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			String dsce = req.getParameter("dsce");
			Integer bflag = Integer.parseInt(req.getParameter("bflag"));

			Book book = new Book(bid, bname, author, price, count, imagurl,
					bclass, date, dsce, bflag);
			us.updBook(book);
			
			//实现按名查询修改后仍然留在本页面
			int pageNow=(Integer) req.getSession().getAttribute("pageNow");
			String url=(String) req.getSession().getAttribute("url");
			url = new String(url.getBytes("utf-8"), "iso-8859-1");
			resp.sendRedirect("BookServlet?pageNow="+pageNow+"&"+url);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
