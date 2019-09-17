package com.hz.dao;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookDao {
	/**
	 * ∑÷“≥≤È—Ø
	 * @param pageNow
	 * @param book
	 * @return
	 */
	public FenYe queryFenYe(int pageNow, Book book);
}
