package com.hz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hz.dao.SelectCarDao;
import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.util.DbUtil;

public class SelectCarDaoImpl implements SelectCarDao {

	@Override
	public FenYe selectCar(int pageNow, String username) {
		FenYe fenYe = new FenYe();
		fenYe.setPageCount(4);// ��ҳ��
		fenYe.setPageNow(pageNow);
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql
		String sql = "select * from book b,shopcar s where username=? and b.bid=s.bid limit ?,? ";
		// 3.ִ��sql
		List list = new ArrayList();

		System.out.println(username + "+++++++++++++++++++++");
		list.add(username);
		int total = this.getTotal(username);
		fenYe.setTotalCount(total);
		// ���÷�ҳ��Ϣ
		int first = (fenYe.getPageNow() - 1) * fenYe.getPageCount();// ���㵱ǰҳ��һ����������
		list.add(first);
		list.add(fenYe.getPageCount());

		System.out.println(sql + "++++++++++++++++++++++++++++++");

		List bookList = new ArrayList();
		// 4.ִ��sql
		ResultSet rs = DbUtil.query(conn, sql, list);
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

		fenYe.setList(bookList);
		return fenYe;
	}

	public int getTotal(String username) {
		Connection conn = DbUtil.getConn();
		String sql = "select count(*) from shopcar where username=?";
		List list = new ArrayList();
		list.add(username);
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

		return count;
	}

	/**
	 * ��ѯ���ﳵ����
	 */
	@Override
	public int selectCount(String username) {
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql
		String sql = "select count(carid) from shopcar where username=? ";
		List list = new ArrayList();
		list.add(username);
		// 3.ִ��sql
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
		// 4.�ر���Դ
		DbUtil.close(conn, rs);

		return count;
	}
}
