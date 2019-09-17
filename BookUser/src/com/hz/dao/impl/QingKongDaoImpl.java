package com.hz.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.QingKongDao;
import com.hz.util.DbUtil;

public class QingKongDaoImpl implements QingKongDao {

	@Override
	public void qingCar(String username) {
		// 1.��ȡ����
		Connection conn = DbUtil.getConn();
		// 2.����sql
		String sql = "delete from shopcar where username=?";
		List list = new ArrayList();
		list.add(username);
		// 3.ִ��sql
		DbUtil.update(conn, sql, list);
		// 4.�ر���Դ
		DbUtil.close(conn, null);
	}
}
