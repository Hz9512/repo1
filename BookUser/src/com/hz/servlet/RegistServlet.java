package com.hz.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hz.pojo.User;
import com.hz.service.LoginService;
import com.hz.service.RegistService;
import com.hz.service.impl.LoginServiceImpl;
import com.hz.service.impl.RegistServiceImpl;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if ("isExitUsername".equals(action)) {
			System.out.println(action + "++++++++++++++++++++++++");
			this.isExitUsername(request, response);
		}
		if ("regist".equals(action)) {
			this.userRegist(request, response);
		}

	}

	public void userRegist(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		int vip = Integer.parseInt(request.getParameter("vip"));

		User user = new User(username, password, 1, vip, address, phone);
		RegistService rs = new RegistServiceImpl();
		try {
			rs.addUser(user);
			System.out.println("注册成功");
			request.getSession().setAttribute("uname", username);
			request.getSession().setAttribute("pwd", password);
			response.sendRedirect("index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isExitUsername(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		System.out.println(username + "+++++++++++++++++++++");
		User u = new User();
		u.setUsername(username);

		LoginService ls = new LoginServiceImpl();
		User userisExit = ls.checkLogin(u);
		if (userisExit != null) {
			response.getWriter().print("该用户名已经存在");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
