package com.hz.service.impl;

import com.hz.dao.AddDao;
import com.hz.dao.impl.AddDaoImpl;
import com.hz.pojo.Book;
import com.hz.service.AddService;

public class AddServiceImpl implements AddService {
	AddDao ad = new AddDaoImpl();
	
	/**
	 * ÃÌº”Õº È
	 */
	@Override
	public void addBook(Book book) {
		ad.addBook(book);
	}

}
