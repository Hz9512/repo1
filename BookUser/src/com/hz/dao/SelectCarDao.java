package com.hz.dao;

import com.hz.pojo.FenYe;

public interface SelectCarDao {
	/**
	 * 查找购物车所有商品
	 */
	public FenYe selectCar(int pageNow, String username);
	/**
	 * 查询购物车总数
	 * @param username
	 * @return
	 */
	public int selectCount(String username);
}
