package com.hz.service.impl;

import com.hz.dao.BuyBookDao;
import com.hz.dao.impl.BuyBookDaoImpl;
import com.hz.pojo.Book;
import com.hz.service.BuyBookService;

public class BuyBookServiceImpl implements BuyBookService {
	BuyBookDao bbd = new BuyBookDaoImpl();

	@Override
	public Book getBook(int bid) {
		// TODO Auto-generated method stub
		return bbd.getBook(bid);
	}

}
