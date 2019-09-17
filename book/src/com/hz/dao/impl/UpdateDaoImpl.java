package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hz.dao.UpdateDao;
import com.hz.pojo.Book;
import com.hz.util.DbUtil;

public class UpdateDaoImpl implements UpdateDao {
	/**
	 * 获取某个book对象
	 */
	@Override
	public Book getBook(int bid) {
		Connection conn = DbUtil.getConn();
		String sql = "select * from book where bid=?";
		List list=new ArrayList();
		list.add(bid);
		ResultSet rs = DbUtil.query(conn, sql, list);
		Book book1=new Book();
		try {
			while(rs.next()){
				book1.setBid(bid);
				book1.setBname(rs.getString("bname"));
				book1.setAuthor(rs.getString("author"));
				book1.setPrice(rs.getDouble("price"));
				book1.setCount(rs.getInt("count"));
				book1.setImagurl(rs.getString("imagurl"));
				book1.setBclass(rs.getString("bclass"));
				book1.setBdate((Date) rs.getObject("bdate"));
				book1.setDsce(rs.getString("dsce"));
				book1.setBflag(rs.getInt("bflag"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close(conn, rs);
		return book1;
	}
	/**
	 * 修改信息
	 */
	@Override
	public void updBook(Book book) {
		
		// 1.创建连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql
		String sql ="update book set bid=?,bname=?,author=?,price=?,count=?,imagurl=?,bclass=?,bdate=?,dsce=?,bflag=? where bid=?";
		List list = new ArrayList();
		list.add(book.getBid());
		list.add(book.getBname());
		list.add(book.getAuthor());
		list.add(book.getPrice());
		list.add(book.getCount());
		list.add(book.getImagurl());
		list.add(book.getBclass());
		list.add(book.getBdate());
		list.add(book.getDsce());
		list.add(book.getBflag());
		list.add(book.getBid());
		System.out.println(sql);
		DbUtil.update(conn, sql, list);
		DbUtil.close(conn, null);
		/*// 3.给占位符赋值
		String sql = sb.toString();
		System.out.println(sql);
		// 4.执行sql
		DbUtil.update(conn, sql, list);
		// 5.关闭资源
		DbUtil.close(conn, null);*/
	}
}
