package com.hz.dao;

public interface UserDao {
	
	/**
	 * ��ѯ�û�
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean queryUser(String username, String password);
}
