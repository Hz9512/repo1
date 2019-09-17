package com.hz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.FenYe;
import com.hz.service.SelectCarService;
import com.hz.service.impl.SelectCarServiceImpl;

public class SelectCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String parameter = request.getParameter("action");
		
		if (!"qingkong".equals(parameter)) {
			String pageNowStr = request.getParameter("pageNow");
			int pageNow = 1;
			if (pageNowStr != null && !"".equals(pageNowStr)) {
				pageNow = Integer.parseInt(pageNowStr);
			}
			String username = (String) request.getSession().getAttribute("username");

			SelectCarService scs = new SelectCarServiceImpl();
			FenYe fenYe = scs.selectCar(pageNow, username);
			request.getSession().setAttribute("fenYe", fenYe);
			response.sendRedirect("shopcar.jsp");
		} else {
			String username = (String) request.getSession().getAttribute("username");
			SelectCarService scs = new SelectCarServiceImpl();
			FenYe fenYe = scs.selectCar(1, username);
			request.getSession().setAttribute("fenYe", fenYe);
			request.getSession().setAttribute("suc", "购物车被清空了");
			response.sendRedirect("shopcar.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
