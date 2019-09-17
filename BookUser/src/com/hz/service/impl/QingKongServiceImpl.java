package com.hz.service.impl;

import com.hz.dao.QingKongDao;
import com.hz.dao.impl.QingKongDaoImpl;
import com.hz.service.QingKongService;

public class QingKongServiceImpl implements QingKongService {
	QingKongDao qkd = new QingKongDaoImpl();

	@Override
	public void qingCar(String username) {
		// TODO Auto-generated method stub
		qkd.qingCar(username);
	}

}
