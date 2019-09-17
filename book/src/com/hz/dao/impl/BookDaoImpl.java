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
	 * ��ѯ����������
	 * 
	 * @return
	 */
	public int getTotalCount(String bname, String author) {
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql���
		StringBuffer sb = new StringBuffer("select count(bid) from book where 1=1 ");
		List list = new ArrayList();
		if (bname != null && !"".equals(bname)) {// ��������ֵ���߿մ�
			sb.append("and bname=?");
			list.add(bname);
		}
		if (author != null && !"".equals(author)) {// ��������ֵ���߿մ�
			sb.append("and author=?");
			list.add(author);
		}
		String sql = sb.toString();
		// 3.��ȡԤ�������
		// 4.��ռλ����ֵ��list��ֵ��
		// 5.���������
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
		// 6.�ر���Դ
		DbUtil.close(conn, rs);
		return count;
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public FenYe queryFenYe(int pageNow, Book book1) {
		// ���������Ȱ�FenYe���󴴽�����
		FenYe fy = new FenYe();
		fy.setPageNow(pageNow); // ��ǰҳ��
		fy.setPageCount(4); // ÿҳ��ʾ����������
		// �Ӵ�������book�����л�ȡ��bname��author
		String bname = book1.getBname();
		String author = book1.getAuthor();
		System.out.println("daoooooooooooooooooooooo"+bname);
		// ����url��ַ
		String url = "";
		if (bname != null) {
			url = url + "bname=" + bname;
		}
		if (author != null) {
			url = url + "&author=" + author;
		}
		fy.setUrl(url);

		int totalCount = this.getTotalCount(bname, author);
		fy.setTotalCount(totalCount);//��������������
		// 1. ��������
		Connection conn = DbUtil.getConn();
		// 2. ����sql���
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

		int first = (fy.getPageNow() - 1) * fy.getPageCount();// ÿҳ��һ��λ����
		list.add(first);
		list.add(fy.getPageCount());
		String sql = sb.toString();
		System.out.println(fy.getPage()+"+++++"+fy.getPageCount()+"++++++"+fy.getTotalCount());
		// 3.��ȡԤ�������
		// 4.��ռλ����ֵ��list��ֵ��
		// 5.ִ��sql���������
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
		// 6. �ر���Դ
		DbUtil.close(conn, rs);

		// �ֱ��FenYE��������Ը�ֵ
		
		fy.setList(fenList);// book����
		return fy;
	}
}
