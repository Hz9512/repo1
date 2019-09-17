package com.hz.service.impl;

import com.hz.dao.UserDao;
import com.hz.dao.impl.UserDaoImpl;
import com.hz.service.UserService;

public class UserServiceimpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public boolean queryUser(String username, String password) {

		/*
		 * 调用dao层方法
		 */
		return ud.queryUser(username, password);
	}

}
