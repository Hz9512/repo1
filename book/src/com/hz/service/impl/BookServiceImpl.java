package com.hz.service.impl;

import com.hz.dao.BookDao;
import com.hz.dao.impl.BookDaoImpl;
import com.hz.pojo.Book;
import com.hz.pojo.FenYe;
import com.hz.service.BookService;

public class BookServiceImpl implements BookService {
	BookDao bo = new BookDaoImpl();

	/**
	 * 查询分页信息
	 */
	@Override
	public FenYe queryFenYe(int pageNow, Book book) {
		return bo.queryFenYe(pageNow, book);
	}

}
