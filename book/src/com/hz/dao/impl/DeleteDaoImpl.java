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
	 * ɾ����Ϣ
	 */
	@Override
	public void delBook(Book book) {
		// 1.��������
		Connection conn = DbUtil.getConn();
		// 2.����sql���
		String sql = "delete from book where bid=?";
		// 3.��ռλ����ֵ
		List list = new ArrayList();
		list.add(book.getBid());
		// 4.ִ��sql
		DbUtil.update(conn, sql, list);
		// 5.�ر���Դ
		DbUtil.close(conn, null);

	}

	
}
