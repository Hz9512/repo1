package com.hz.service;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookService {
	/**
	 * ��ѯ��ҳ��Ϣ
	 * 
	 * @param pageNow
	 * @return
	 */
	public FenYe queryFenYe(int pageNow,Book book);
	
}
