package com.hz.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hz.dao.AddDao;
import com.hz.pojo.Book;
import com.hz.util.DbUtil;

public class AddDaoImpl implements AddDao {

	@Override
	public void addBook(Book book) {
		// 1.创建连接
		Connection conn = DbUtil.getConn();
		// 2. 创建sql语句
		String sql = "insert into book values(default,?,?,?,?,?,?,?,?,?)";
		// 3.给占位符赋值
		List list = new ArrayList();
		list.add(book.getBname());
		list.add(book.getAuthor());
		list.add(book.getPrice());
		list.add(book.getCount());
		list.add(book.getImagurl());
		list.add(book.getBclass());
		list.add(book.getBdate());
		list.add(book.getDsce());
		list.add(book.getBflag());
		// 4.执行sql
		DbUtil.update(conn, sql, list);
		// 5.关闭资源
		DbUtil.close(conn, null);
	}

}
