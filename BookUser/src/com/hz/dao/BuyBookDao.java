package com.hz.dao;

import com.hz.pojo.Book;

public interface BuyBookDao {
	/**
	 * ��ȡĳһ��ͼ��
	 * @param bid
	 * @return
	 */
	public Book getBook(int bid);
}
