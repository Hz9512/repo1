package com.hz.service.impl;

import com.hz.dao.ShopCarDao;
import com.hz.dao.impl.ShopCarDaoImpl;
import com.hz.pojo.ShopCar;
import com.hz.service.ShopCarService;

public class ShopCarServiceImpl implements ShopCarService {
	ShopCarDao scd = new ShopCarDaoImpl();

	@Override
	public void addToCar(ShopCar sc) {
		scd.addToCar(sc);
	}

}
