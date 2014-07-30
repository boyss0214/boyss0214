package com.money.financing.dto;

import java.math.BigDecimal;




/**
 * @author Mars
 * @createDate 2014年7月10日
 */
public class ClientUserBaseDTO extends BaseDTO{

	private static final long serialVersionUID = 7713382079642600800L;

	/**
	 * 姓名
	 */
	private String cName;
	/**
	 *1：男，2：女，3：隐私
	 */
	private int cSex;
	/**
	 * 年龄
	 */
	private int cAge;
	/**
	 * 证件类型:1:身份证，2：护照,3:驾照
	 */
	private int cNumberType;
	/**
	 * 证件号：身份证号码/护照号/驾照
	 */
	private String cNumber;
	/**
	 * 总资产
	 */
	private BigDecimal cAsset;
	
	/**
	 * 客户级别，A类，B类，C类...
	 */
	private int cLevel;
	
	/**
	 * 地址
	 */
	private String cAddress;
	/**
	 * 电话号码
	 */
	private String cTelephone;
	/**
	 * 移动电话
	 */
	private String cMobile;
	
	/**
	 * 电子邮件
	 */
	private String cEmail;
	
	/**
	 * 备注
	 */
	private String cRemark;
	
	/**
	 * FA的业务编码
	 */
	private String cPaCode;
	
	public ClientUserBaseDTO() {
		super();
	}

	
	
	public String getcPaCode() {
		return cPaCode;
	}



	public void setcPaCode(String cPaCode) {
		this.cPaCode = cPaCode;
	}



	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcSex() {
		return cSex;
	}

	public void setcSex(int cSex) {
		this.cSex = cSex;
	}

	public int getcAge() {
		return cAge;
	}

	public void setcAge(int cAge) {
		this.cAge = cAge;
	}

	public int getcNumberType() {
		return cNumberType;
	}

	public void setcNumberType(int cNumberType) {
		this.cNumberType = cNumberType;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public BigDecimal getcAsset() {
		return cAsset;
	}

	public void setcAsset(BigDecimal cAsset) {
		this.cAsset = cAsset;
	}

	public int getcLevel() {
		return cLevel;
	}

	public void setcLevel(int cLevel) {
		this.cLevel = cLevel;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcTelephone() {
		return cTelephone;
	}

	public void setcTelephone(String cTelephone) {
		this.cTelephone = cTelephone;
	}

	public String getcMobile() {
		return cMobile;
	}

	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcRemark() {
		return cRemark;
	}

	public void setcRemark(String cRemark) {
		this.cRemark = cRemark;
	}



}
