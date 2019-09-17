package com.hz.pojo;

public class User {
	private String username;
	private String password;
	private int act;
	private int vip;
	private String address;
	private String phone;

	public User() {
	}

	public User(String username, String password, int act, int vip,
			String address, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.act = act;
		this.vip = vip;
		this.address = address;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", act=" + act + ", vip=" + vip + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
