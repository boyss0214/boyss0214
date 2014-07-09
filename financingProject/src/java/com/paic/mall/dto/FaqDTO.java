package com.paic.mall.dto;

import java.util.Date;


public class FaqDTO {
	private int id;
	private String title;
	private String content;
	private int sort;
	private int faqType;
	private Date addTime;
	private Date lastModifyTime;

	public FaqDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public int getFaqType() {
		return faqType;
	}

	public void setFaqType(int faqType) {
		this.faqType = faqType;
	}

}
