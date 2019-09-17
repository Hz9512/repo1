package com.hz.pojo;

import java.util.Date;

public class Book {
	private Integer bid; // ͼ��id
	private String bname; // ͼ������
	private String author; // ͼ������
	private Double price; // ͼ��۸�
	private Integer count; // ͼ������
	private String imagurl; // ͼƬurl
	private String bclass; // ͼ�����
	private Date bdate; // ͼ���������
	private String dsce; // ͼ������
	private Integer bflag; // �ϼ�״̬

	public Book() {
	}

	public Book(Integer bid, String bname, String author, Double price,
			Integer count, String imagurl, String bclass, Date bdate,
			String dsce, Integer bflag) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.count = count;
		this.imagurl = imagurl;
		this.bclass = bclass;
		this.bdate = bdate;
		this.dsce = dsce;
		this.bflag = bflag;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImagurl() {
		return imagurl;
	}

	public void setImagurl(String imagurl) {
		this.imagurl = imagurl;
	}

	public String getBclass() {
		return bclass;
	}

	public void setBclass(String bclass) {
		this.bclass = bclass;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getDsce() {
		return dsce;
	}

	public void setDsce(String dsce) {
		this.dsce = dsce;
	}

	public int getBflag() {
		return bflag;
	}

	public void setBflag(int bflag) {
		this.bflag = bflag;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author
				+ ", price=" + price + ", count=" + count + ", imagurl="
				+ imagurl + ", bclass=" + bclass + ", bdate=" + bdate
				+ ", dsce=" + dsce + ", bflag=" + bflag + "]";
	}

}
