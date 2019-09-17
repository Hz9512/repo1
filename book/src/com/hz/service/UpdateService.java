package com.hz.service;

import com.hz.pojo.Book;

public interface UpdateService {
	/**
	 * 修改信息
	 */
	public void updBook(Book book);
	/**
	 * 获取某个book对象
	 */
	public Book getBook(int bid);
}
