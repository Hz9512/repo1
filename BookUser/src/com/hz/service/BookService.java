package com.hz.service;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookService {
	/**
	 * ��ѯ����ͼ��ͷ�ҳ��Ϣ
	 * @param book
	 * @param pageNow
	 * @return
	 */
	public FenYe queryFenYe(Book book, int pageNow);
}
