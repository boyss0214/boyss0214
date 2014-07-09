package com.paic.mall.vo;

import java.util.List;

public class QueryFaqVo {
	private int start;
	private int size;
	private List<Integer> faqTypeList;

	public QueryFaqVo() {
		super();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Integer> getFaqTypeList() {
		return faqTypeList;
	}

	public void setFaqTypeList(List<Integer> faqTypeList) {
		this.faqTypeList = faqTypeList;
	}

}
