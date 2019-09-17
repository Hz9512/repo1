package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.UserDao;
import com.hz.util.DbUtil;

public class UserDaoImpl implements UserDao {
	/**
	 * 查询用户名和密码是否存在
	 */
	@Override
	public boolean queryUser(String username, String password) {
		// 创建连接
		Connection conn = DbUtil.getConn();
		// 创建sql语句
		String sql = "select username from user where username=? and password=? and act=?";
		// 给占位符赋值
		List list1 = new ArrayList();
		list1.add(username);
		list1.add(password);
		list1.add(0);
		ResultSet rs = DbUtil.query(conn, sql, list1);
		if (rs != null) {
			try {
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DbUtil.close(conn, rs);
		return false;
	}

}
