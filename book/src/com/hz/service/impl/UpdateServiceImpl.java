package com.hz.service.impl;

import com.hz.dao.UpdateDao;
import com.hz.dao.impl.UpdateDaoImpl;
import com.hz.pojo.Book;
import com.hz.service.UpdateService;

public class UpdateServiceImpl implements UpdateService {
	UpdateDao ud = new UpdateDaoImpl();
	/**
	 * 修改信息
	 */
	@Override
	public void updBook(Book book) {
		ud.updBook(book);
	}
	/**
	 * 修改信息
	 */
	@Override
	public Book getBook(int bid) {
		return ud.getBook(bid);
	}

}
