package com.hz.service;

import com.hz.pojo.Book;

public interface UpdateService {
	/**
	 * �޸���Ϣ
	 */
	public void updBook(Book book);
	/**
	 * ��ȡĳ��book����
	 */
	public Book getBook(int bid);
}
