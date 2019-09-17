package com.hz.pojo;

public class ShopCar {
	private String carid; // ���ﳵ���
	private String username; // �û���
	private int bid; // ͼ����
	private double price; // ͼ��۸�

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
