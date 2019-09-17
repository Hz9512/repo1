package com.hz.service.impl;

import com.hz.dao.RegistDao;
import com.hz.dao.impl.RegistDaoImpl;
import com.hz.pojo.User;
import com.hz.service.RegistService;

public class RegistServiceImpl implements RegistService {
	RegistDao rd = new RegistDaoImpl();

	@Override
	public void addUser(User user) {
		rd.addUser(user);
	}

}
