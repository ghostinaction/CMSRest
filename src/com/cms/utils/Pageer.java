package com.cms.utils;

import java.util.List;

public class Pageer<T> {
	//当前下标
	private int currentIndex;
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	//当前页
	private int pageNum;
	//每页显示数
	private int pageSize;
	//总页数
	private int totalPage;
	//总结果数
	private int count;
	//数据
	private List<T> data;
	
	public Pageer() {
		super();
	}
	@Override
	public String toString() {
		return "Pageer [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", count=" + count
				+ ", data=" + data + "]";
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
