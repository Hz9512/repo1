package com.hz.service;

public interface UserService {
	/**
	 * 查询用户名和登录密码
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean queryUser(String username, String password);
	
}
