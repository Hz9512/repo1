package com.hz.dao;

import com.hz.pojo.FenYe;

public interface SelectCarDao {
	/**
	 * ���ҹ��ﳵ������Ʒ
	 */
	public FenYe selectCar(int pageNow, String username);
	/**
	 * ��ѯ���ﳵ����
	 * @param username
	 * @return
	 */
	public int selectCount(String username);
}
