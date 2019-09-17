package com.hz.dao;

import com.hz.pojo.Book;

public interface UpdateDao {
	/**
	 * 修改信息
	 */
	public void updBook(Book book);
	/**
	 * 获取某个对象
	 * @param bid
	 * @return
	 */
	public Book getBook(int bid);
}
