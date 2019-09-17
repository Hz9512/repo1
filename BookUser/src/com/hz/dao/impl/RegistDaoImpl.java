package com.hz.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.RegistDao;
import com.hz.pojo.User;
import com.hz.util.DbUtil;

public class RegistDaoImpl implements RegistDao {

	@Override
	public void addUser(User user) {
		System.out.println(user+"+++++++++++++++++");
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql
		String sql = "insert into user values(?,?,?,?,?,?)";
		List list = new ArrayList();
		list.add(user.getUsername());
		list.add(user.getPassword());
		list.add(user.getAct());
		list.add(user.getVip());
		list.add(user.getAddress());
		list.add(user.getPhone());
		// 3.ִ��sql
		DbUtil.update(conn, sql, list);
		// 4.�ر���Դ
		DbUtil.close(conn, null);

	}

}
