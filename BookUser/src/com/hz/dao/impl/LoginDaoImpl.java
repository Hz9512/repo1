package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.LoginDao;
import com.hz.pojo.User;
import com.hz.util.DbUtil;

public class LoginDaoImpl implements LoginDao {

	/**
	 * µÇÂ¼
	 */
	@Override
	public User checkLogin(User user) {
		Connection conn = DbUtil.getConn();
		// String sql =
		// "select * from user where username=? and password=? and act=?";
		StringBuffer sb = new StringBuffer("select * from user where 1=1 ");

		String username = user.getUsername();
		String pwd = user.getPassword();
		List list = new ArrayList();
		if (username != null) {
			sb.append("and username=? ");
			list.add(username);
		}
		if (pwd != null) {
			sb.append("and password=? ");
			list.add(pwd);
		}
		sb.append("and act=? ");
		list.add(1);
		String sql = sb.toString();

		ResultSet rs = DbUtil.query(conn, sql, list);
		User user1 = null;
		try {
			while (rs.next()) {
				user1 = new User();
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setAct(rs.getInt("act"));
				user1.setVip(rs.getInt("vip"));
				user1.setAddress(rs.getString("address"));
				user1.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close(conn, rs);
		return user1;
	}
}
