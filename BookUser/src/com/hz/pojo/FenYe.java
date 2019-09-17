package com.hz.pojo;

import java.util.ArrayList;
import java.util.List;

public class FenYe {
	private int pageNow; // 当前页
	private int pageCount; // 一页显示多少条数据
	private int totalCount; // 一共有多少条数据
	private int page; // 一共多少页
	List<Book> list = new ArrayList<Book>();
	private String url;

	public FenYe() {
	}

	public FenYe(int pageNow, int pageCount, int totalCount, int page,
			List<Book> list, String url) {
		super();
		this.pageNow = pageNow;
		this.pageCount = pageCount;
		this.totalCount = totalCount;
		this.page = page;
		this.list = list;
		this.url = url;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPage() {
		return totalCount % pageCount == 0 ? (totalCount / pageCount):(totalCount / pageCount + 1);
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FenYe [pageNow=" + pageNow + ", pageCount=" + pageCount
				+ ", totalCount=" + totalCount + ", page=" + page + ", list="
				+ list + ", url=" + url + "]";
	}

}
