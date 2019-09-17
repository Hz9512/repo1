package com.hz.service.impl;

import com.hz.dao.DeleteDao;
import com.hz.dao.impl.DeleteDaoImpl;
import com.hz.pojo.Book;
import com.hz.service.DeleteService;

public class DeleteServiceImpl implements DeleteService {
	DeleteDao dd=new DeleteDaoImpl();
	@Override
	public void delBook(Book book) {
		// TODO Auto-generated method stub
		dd.delBook(book);
	}

}
