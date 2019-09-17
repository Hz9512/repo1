package com.hz.dao;

import com.hz.pojo.Book;

public interface BuyBookDao {
	/**
	 * 获取某一本图书
	 * @param bid
	 * @return
	 */
	public Book getBook(int bid);
}
