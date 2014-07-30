package com.money.financing.vo;



import com.money.financing.dto.ClientUserBaseDTO;


public class QueryClientUserVo extends BaseVo<ClientUserBaseDTO> {


	private static final long serialVersionUID = -4927999770412843730L;

	public QueryClientUserVo() {
		super();
	}
	
	/**
	 * 姓名
	 */
	private String cName;
	
	/**
	 * 证件号：身份证号码/护照号/驾照
	 */
	private String cNumber;
	/**
	 * 客户级别，A类，B类，C类...
	 */
	private int cLevel;
	
	/**
	 * 移动电话
	 */
	private String cMobile;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public int getcLevel() {
		return cLevel;
	}

	public void setcLevel(int cLevel) {
		this.cLevel = cLevel;
	}

	public String getcMobile() {
		return cMobile;
	}

	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}
	
	

}
