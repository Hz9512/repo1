package com.hz.service;

import com.hz.pojo.FenYe;
import com.hz.pojo.ShopCar;

public interface SelectCarService {
	/**
	 * ���ҹ��ﳵ������Ʒ
	 */
	public FenYe selectCar(int pageNow,String username);
	/**
	 * ��ѯ���ﳵ����
	 * @param username
	 * @return
	 */
	public int selectCount(String username);
}
