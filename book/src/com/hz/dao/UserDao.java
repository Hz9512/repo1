package com.hz.dao;

public interface UserDao {
	
	/**
	 * ≤È—Ø”√ªß
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean queryUser(String username, String password);
}
