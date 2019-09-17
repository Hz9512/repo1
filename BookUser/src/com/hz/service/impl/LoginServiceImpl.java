package com.hz.service.impl;

import com.hz.dao.LoginDao;
import com.hz.dao.impl.LoginDaoImpl;
import com.hz.pojo.User;
import com.hz.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao ld = new LoginDaoImpl();

	@Override
	public User checkLogin(User user) {

		return ld.checkLogin(user);
	}

}
