package com.hz.service.impl;

import com.hz.dao.BookDao;
import com.hz.dao.impl.BookDaoImpl;
import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.service.BookService;

public class BookServiceImpl implements BookService {
	/**
	 * 查询所有图书信息和分页信息
	 */
	BookDao bd = new BookDaoImpl();
	
	@Override
	public FenYe queryFenYe(Book book, int pageNow) {
		// TODO Auto-generated method stub
		return bd.queryFenYe(book, pageNow);
	}

}
