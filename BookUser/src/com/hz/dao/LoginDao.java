package com.hz.dao;

import com.hz.pojo.User;

public interface LoginDao {
	/**
	 * ��¼
	 * @return
	 */
	public User checkLogin(User user);
}
