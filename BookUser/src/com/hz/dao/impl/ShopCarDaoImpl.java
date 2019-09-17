package com.hz.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.ShopCarDao;
import com.hz.pojo.ShopCar;
import com.hz.util.DbUtil;

public class ShopCarDaoImpl implements ShopCarDao {

	@Override
	public void addToCar(ShopCar sc) {
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql
		String sql = "insert into shopcar values(?,?,?,?) ";
		List list = new ArrayList();
		list.add(sc.getCarid());
		list.add(sc.getUsername());
		list.add(sc.getBid());
		list.add(sc.getPrice());
		// 3.ִ��sql
		DbUtil.update(conn, sql, list);
		//4.�ر���Դ
		DbUtil.close(conn, null);
	}

}
