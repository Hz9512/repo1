package com.hz.dao;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookDao {
	/**
	 * ��ҳ��ѯ
	 * @param pageNow
	 * @param book
	 * @return
	 */
	public FenYe queryFenYe(int pageNow, Book book);
}
