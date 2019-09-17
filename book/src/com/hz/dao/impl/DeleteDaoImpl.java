package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hz.dao.DeleteDao;
import com.hz.pojo.Book;
import com.hz.util.DbUtil;

public class DeleteDaoImpl implements DeleteDao {
	/**
	 * 删除信息
	 */
	@Override
	public void delBook(Book book) {
		// 1.创建连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql语句
		String sql = "delete from book where bid=?";
		// 3.给占位符赋值
		List list = new ArrayList();
		list.add(book.getBid());
		// 4.执行sql
		DbUtil.update(conn, sql, list);
		// 5.关闭资源
		DbUtil.close(conn, null);

	}

	
}
