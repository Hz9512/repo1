package com.hz.dao;

import com.hz.pojo.Book;

public interface UpdateDao {
	/**
	 * �޸���Ϣ
	 */
	public void updBook(Book book);
	/**
	 * ��ȡĳ������
	 * @param bid
	 * @return
	 */
	public Book getBook(int bid);
}
