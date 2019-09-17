package com.hz.service.impl;

import com.hz.dao.SelectCarDao;
import com.hz.dao.impl.SelectCarDaoImpl;
import com.hz.pojo.FenYe;
import com.hz.service.SelectCarService;

public class SelectCarServiceImpl implements SelectCarService {
	SelectCarDao scd = new SelectCarDaoImpl();

	@Override
	public FenYe selectCar(int pageNow, String username) {

		return scd.selectCar(pageNow, username);
	}

	/**
	 * ��ѯ���ﳵ����
	 */
	@Override
	public int selectCount(String username) {
		
		return scd.selectCount(username);
	}
}
