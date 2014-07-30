package com.money.financing.dto;

import java.io.Serializable;
import java.util.Date;





/**
 * DTO的基类
 * @author Mars
 * @createDate 2014年7月10日
 */
public class BaseDTO implements Serializable{
	
	private static final long serialVersionUID = 8321656369370987951L;
	/**
	 * 系统自增ID
	 */
	private int id;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 1:正常，2：删除，3：注销
	 */
	private int status;



	public BaseDTO() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getCreateBy() {
		return createBy;
	}


	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getUpdateBy() {
		return updateBy;
	}


	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	
}
