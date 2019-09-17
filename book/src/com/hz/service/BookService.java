package com.hz.service;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookService {
	/**
	 * 查询分页信息
	 * 
	 * @param pageNow
	 * @return
	 */
	public FenYe queryFenYe(int pageNow,Book book);
	
}
