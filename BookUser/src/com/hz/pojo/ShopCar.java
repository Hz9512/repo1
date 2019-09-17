package com.hz.pojo;

public class ShopCar {
	private String carid; // 购物车编号
	private String username; // 用户名
	private int bid; // 图书编号
	private double price; // 图书价格

	public ShopCar(String carid, String username, int bid, double price) {
		super();
		this.carid = carid;
		this.username = username;
		this.bid = bid;
		this.price = price;
	}

	public ShopCar() {
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShopCar [carid=" + carid + ", username=" + username + ", bid="
				+ bid + ", price=" + price + "]";
	}

}
