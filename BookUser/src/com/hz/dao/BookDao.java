package com.hz.dao;

import com.hz.pojo.Book;
import com.hz.pojo.FenYe;

public interface BookDao {
	/**
	 * ��ѯ����ͼ��ͷ�ҳ��Ϣ
	 * @param book
	 * @param pageNow
	 * @return
	 */
	public FenYe queryFenYe(Book book,int pageNow); 
}
