package com.bfei.icrane.common.util;

import java.util.List;
import java.util.Map;

/**
 * 分页类的封装
 */
public class PageBean<T> {
	private int page;	// 当前页数
	private int totalCount; // 总记录数
	private int totalPage; // 总页数
	private int pageSize;	// 每页显示的记录数
	private List<T> list; // 每页显示数据的集合.
	private int start;
	private int end;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
}
