package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.hz.dao.BookDao;
import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.util.DbUtil;

public class BookDaoImpl implements BookDao {
	public int getTotalCount(String bname, String author) {
		// 1.建立连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql
		StringBuffer sb = new StringBuffer("select count(bid) from book where 1=1 ");
		List list = new ArrayList();
		if (bname != null && !"".equals(bname)) {
			sb.append("and bname=?");
			list.add(bname);
		}
		if (author != null && !"".equals(author)) {
			sb.append("and author=?");
			list.add(author);
		}
		String sql = sb.toString();
		// 3.执行sql
		ResultSet rs = DbUtil.query(conn, sql, list);
		int total = 0;
		try {
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.关闭资源
		DbUtil.close(conn, rs);
		return total;
	}

	@Override
	public FenYe queryFenYe(Book book, int pageNow) {
		// 1.建立连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql
		FenYe fy = new FenYe();
		fy.setPageNow(pageNow);// 保存当前页号
		fy.setPageCount(4);// 保存每页数据条数
		// 根据bname和author查询所有图书总数
		String bname = book.getBname();
		String author = book.getAuthor();
		int total = this.getTotalCount(bname, author);
		// 设置url
		String url = "";
		if (bname != null && !"".equals(bname)) {
			url = url + "&bname=" + bname;
		}
		if (author != null && !"".equals(author)) {
			url = url + "&author=" + author;
		}
		fy.setUrl(url);// 保存url
		fy.setTotalCount(total);// 保存总数据条数

		StringBuffer sb = new StringBuffer("select * from book where 1=1 ");
		List list = new ArrayList();
		if (bname != null && !"".equals(bname)) {
			sb.append("and bname=?");
			list.add(bname);
		}
		if (author != null && !"".equals(author)) {
			sb.append("and author=?");
			list.add(author);
		}
		sb.append("limit ?,?");
		int first = (fy.getPageNow() - 1) * fy.getPageCount();// 计算当前页第一个数的索引
		list.add(first);
		list.add(fy.getPageCount());
		String sql = sb.toString();
		// 3.执行sql
		ResultSet rs = DbUtil.query(conn, sql, list);
		List bookList = new ArrayList();
		try {
			while (rs.next()) {
				Book book1 = new Book();
				book1.setBid((Integer) rs.getObject("bid"));
				book1.setBname((String) rs.getObject("bname"));
				book1.setAuthor((String) rs.getObject("author"));
				book1.setPrice((Double) rs.getObject("price"));
				book1.setCount((Integer) rs.getObject("count"));
				book1.setImagurl((String) rs.getObject("imagurl"));
				book1.setBclass((String) rs.getObject("bclass"));
				book1.setBdate((Date) rs.getObject("bdate"));
				book1.setDsce((String) rs.getObject("dsce"));
				book1.setBflag((Integer) rs.getInt("bflag"));
				bookList.add(book1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fy.setList(bookList);// 保存List到fy中
		// 4.关闭资源
		DbUtil.close(conn, rs);
		return fy;
	}

}
