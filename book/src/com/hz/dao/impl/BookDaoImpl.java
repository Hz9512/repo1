package com.hz.dao.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hz.dao.BookDao;
import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.util.DbUtil;

public class BookDaoImpl implements BookDao {
	/**
	 * 查询总数据条数
	 * 
	 * @return
	 */
	public int getTotalCount(String bname, String author) {
		// 1.建立连接
		Connection conn = DbUtil.getConn();
		// 2.创建sql语句
		StringBuffer sb = new StringBuffer("select count(bid) from book where 1=1 ");
		List list = new ArrayList();
		if (bname != null && !"".equals(bname)) {// 避免存入空值或者空串
			sb.append("and bname=?");
			list.add(bname);
		}
		if (author != null && !"".equals(author)) {// 避免存入空值或者空串
			sb.append("and author=?");
			list.add(author);
		}
		String sql = sb.toString();
		// 3.获取预编译对象
		// 4.给占位符赋值（list赋值）
		// 5.遍历结果集
		ResultSet rs = DbUtil.query(conn, sql, list);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 6.关闭资源
		DbUtil.close(conn, rs);
		return count;
	}

	/**
	 * 分页查询
	 */
	@Override
	public FenYe queryFenYe(int pageNow, Book book1) {
		// 首先上来先把FenYe对象创建起来
		FenYe fy = new FenYe();
		fy.setPageNow(pageNow); // 当前页号
		fy.setPageCount(4); // 每页显示的数据条数
		// 从传进来的book对象中获取到bname和author
		String bname = book1.getBname();
		String author = book1.getAuthor();
		System.out.println("daoooooooooooooooooooooo"+bname);
		// 保存url地址
		String url = "";
		if (bname != null) {
			url = url + "bname=" + bname;
		}
		if (author != null) {
			url = url + "&author=" + author;
		}
		fy.setUrl(url);

		int totalCount = this.getTotalCount(bname, author);
		fy.setTotalCount(totalCount);//设置总数据条数
		// 1. 建立连接
		Connection conn = DbUtil.getConn();
		// 2. 创建sql语句
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

		int first = (fy.getPageNow() - 1) * fy.getPageCount();// 每页第一个位数号
		list.add(first);
		list.add(fy.getPageCount());
		String sql = sb.toString();
		System.out.println(fy.getPage()+"+++++"+fy.getPageCount()+"++++++"+fy.getTotalCount());
		// 3.获取预编译对象
		// 4.给占位符赋值（list赋值）
		// 5.执行sql遍历结果集
		ResultSet rs = DbUtil.query(conn, sql, list);
		
		List fenList = new ArrayList();
		if (rs != null) {
			try {
				while (rs.next()) {
					Book book = new Book();
					book.setBid((Integer) rs.getObject("bid"));
					book.setBname((String) rs.getObject("bname"));
					book.setAuthor((String) rs.getObject("author"));
					book.setPrice((Double) rs.getObject("price"));
					book.setCount((Integer) rs.getObject("count"));
					book.setImagurl((String) rs.getObject("imagurl"));
					book.setBclass((String) rs.getObject("bclass"));
					book.setBdate((Date) rs.getObject("bdate"));
					book.setDsce((String) rs.getObject("dsce"));
					book.setBflag((Integer) rs.getInt("bflag"));
					fenList.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 6. 关闭资源
		DbUtil.close(conn, rs);

		// 分别给FenYE对象的属性赋值
		
		fy.setList(fenList);// book集合
		return fy;
	}
}
