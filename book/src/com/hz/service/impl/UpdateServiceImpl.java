package com.hz.service.impl;

import com.hz.dao.UpdateDao;
import com.hz.dao.impl.UpdateDaoImpl;
import com.hz.pojo.Book;
import com.hz.service.UpdateService;

public class UpdateServiceImpl implements UpdateService {
	UpdateDao ud = new UpdateDaoImpl();
	/**
	 * �޸���Ϣ
	 */
	@Override
	public void updBook(Book book) {
		ud.updBook(book);
	}
	/**
	 * �޸���Ϣ
	 */
	@Override
	public Book getBook(int bid) {
		return ud.getBook(bid);
	}

}
