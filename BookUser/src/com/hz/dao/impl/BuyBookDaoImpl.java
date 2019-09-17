package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hz.dao.BuyBookDao;
import com.hz.pojo.Book;
import com.hz.util.DbUtil;

public class BuyBookDaoImpl implements BuyBookDao {

	@Override
	public Book getBook(int bid) {
		// 1.建立连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql
		String sql = "select * from book where bid=?";
		List list = new ArrayList();
		list.add(bid);
		// 3.执行sql
		ResultSet rs = DbUtil.query(conn, sql, list);
		Book book = new Book();
		try {
			while (rs.next()) {
				book.setBid(bid);
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setCount(rs.getInt("count"));
				book.setImagurl(rs.getString("imagurl"));
				book.setBclass(rs.getString("bclass"));
				book.setBdate((Date) rs.getObject("bdate"));
				book.setDsce(rs.getString("dsce"));
				book.setBflag(rs.getInt("bflag"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭资源
		return book;
	}

}
