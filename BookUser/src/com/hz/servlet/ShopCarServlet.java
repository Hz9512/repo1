package com.hz.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.Book;
import com.hz.pojo.ShopCar;
import com.hz.service.SelectCarService;
import com.hz.service.ShopCarService;
import com.hz.service.impl.SelectCarServiceImpl;
import com.hz.service.impl.ShopCarServiceImpl;

public class ShopCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		ShopCarService scs = new ShopCarServiceImpl();
		SelectCarService select = new SelectCarServiceImpl();

		String username = (String) request.getSession()
				.getAttribute("username");
		String action = request.getParameter("action");
		if ("gouwuche".equals(action)) {
			Book book = (Book) request.getSession().getAttribute("book");
			int bid = book.getBid();
			double price = book.getPrice();
			String carid = UUID.randomUUID().toString().replace("-", "");
			ShopCar sc = new ShopCar(carid, username, bid, price);
			try {
				// 添加
				scs.addToCar(sc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 查询总数
			int selectCount = select.selectCount(username);

			response.getWriter().print(selectCount);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
