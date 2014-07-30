package com.money.financing.vo;

import java.io.Serializable;
import java.util.List;

/**
 * vo的基类
 * @author Mars
 * @createDate 2014年7月10日
 */
public class BaseVo<E> implements Serializable{
	

	private static final long serialVersionUID = -8534685278941340394L;

	private int id;
	/**
	 * 当前页
	 */
	private int currentPage=0;
	
	/**
	 * 起始条数
	 */
	private int start=1;
	/**
	 * 分页数
	 */
	private int pageSize=10;
	
	private List<E> objectList;

	public BaseVo() {
		super();
	}


	public int getStart() {
		start = getCurrentPage()*getPageSize();
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public List<?> getObjectList() {
		return objectList;
	}



	public void setObjectList(List<E> objectList) {
		this.objectList = objectList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	
}
