package com.hz.dao;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookDao {
	/**
	 * 查询所有图书和分页信息
	 * @param book
	 * @param pageNow
	 * @return
	 */
	public FenYe queryFenYe(Book book,int pageNow); 
}
