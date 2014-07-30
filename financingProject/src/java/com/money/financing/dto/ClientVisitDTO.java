package com.money.financing.dto;


import java.util.Date;




/**
 * 客户拜访信息表
 * @author Mars
 * @createDate 2014年7月10日
 */
public class ClientVisitDTO extends BaseDTO{

	private static final long serialVersionUID = 7713382079698600800L;
	
	private int Id;
	
	/**
	 * 拜访时间
	 */
	private Date cvDate;
	
	/**
	 * 拜访时间字符串
	 */
	private String cvDateStr;
	
	/**
	 * 拜访方式：1:电话拜访，2：上门拜访，3:网络拜访，4：售后拜访
	 */
	private int cvType;
	
	/**
	 * FA业务编码
	 */
	private String uCode;
	
	/**
	 * 拜访的客户ID
	 */
	private int cvCUserId;
	
	/**
	 * 访问备注
	 */
	private String cvRemark;
	
	/**
	 * 产品编号
	 */
	private String cvPCode;
	
	public ClientVisitDTO() {
		super();
	}

	public Date getCvDate() {
		return cvDate;
	}

	public void setCvDate(Date cvDate) {
		this.cvDate = cvDate;
	}

	public int getCvType() {
		return cvType;
	}

	public void setCvType(int cvType) {
		this.cvType = cvType;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public int getCvCUserId() {
		return cvCUserId;
	}

	public void setCvCUserId(int cvCUserId) {
		this.cvCUserId = cvCUserId;
	}

	public String getCvRemark() {
		return cvRemark;
	}

	public void setCvRemark(String cvRemark) {
		this.cvRemark = cvRemark;
	}

	public String getCvPCode() {
		return cvPCode;
	}

	public void setCvPCode(String cvPCode) {
		this.cvPCode = cvPCode;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCvDateStr() {
		return cvDateStr;
	}

	public void setCvDateStr(String cvDateStr) {
		this.cvDateStr = cvDateStr;
	}

	
}

