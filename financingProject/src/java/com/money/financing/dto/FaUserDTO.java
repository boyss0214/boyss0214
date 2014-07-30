package com.money.financing.dto;




/**
 * @author Mars
 * @createDate 2014年7月10日
 */
public class FaUserDTO extends BaseDTO{

	private static final long serialVersionUID = 5498322570316933915L;
	/**
	 * 用户名称
	 */
	private String uName;
	/**
	 * 登录名
	 */
	private String uLoginName;
	/**
	 * 密码
	 */
	private String uPassWord;
	/**
	 * 证件类型:1:身份证，2：护照,3:驾照
	 */
	private int uNumberType;
	/**
	 * 证件号：身份证号码/护照号/驾照
	 */
	private String uNumber;
	/**
	 * 角色：资深FA、初级FA等
	 */
	private String uRole;
	/**
	 * 电话号码
	 */
	private String uTelephone;
	/**
	 * 移动电话
	 */
	private String uMobile;
	/**
	 * FA业务编码
	 */
	private String uCode;
	/**
	 * 电子邮件
	 */
	private String uEmail;
	/**
	 *1：男，2：女，3：隐私
	 */
	private int uSex;
	/**
	 * 年龄
	 */
	private int uAge;
	/**
	 * 地址
	 */
	private String uAddress;

	/**
	 * 自我介绍
	 */
	private String uRemark;
	
	/**
	 * 所在公司，1自由，2诺亚
	 */
	private String uCompany;
	
	/**
	 * 用户图片地址
	 */
	private String uImage;

	public FaUserDTO() {
		super();
	}


	
	
	public String getuImage() {
		return uImage;
	}




	public void setuImage(String uImage) {
		this.uImage = uImage;
	}




	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuLoginName() {
		return uLoginName;
	}


	public void setuLoginName(String uLoginName) {
		this.uLoginName = uLoginName;
	}


	public String getuPassWord() {
		return uPassWord;
	}


	public void setuPassWord(String uPassWord) {
		this.uPassWord = uPassWord;
	}


	public int getuNumberType() {
		return uNumberType;
	}


	public void setuNumberType(int uNumberType) {
		this.uNumberType = uNumberType;
	}


	public String getuNumber() {
		return uNumber;
	}


	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}


	public String getuRole() {
		return uRole;
	}


	public void setuRole(String uRole) {
		this.uRole = uRole;
	}


	public String getuTelephone() {
		return uTelephone;
	}


	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}


	public String getuMobile() {
		return uMobile;
	}


	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}


	public String getuCode() {
		return uCode;
	}


	public void setuCode(String uCode) {
		this.uCode = uCode;
	}


	public String getuEmail() {
		return uEmail;
	}


	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}


	public int getuSex() {
		return uSex;
	}


	public void setuSex(int uSex) {
		this.uSex = uSex;
	}


	public int getuAge() {
		return uAge;
	}


	public void setuAge(int uAge) {
		this.uAge = uAge;
	}


	public String getuAddress() {
		return uAddress;
	}


	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}


	public String getuRemark() {
		return uRemark;
	}


	public void setuRemark(String uRemark) {
		this.uRemark = uRemark;
	}


	public String getuCompany() {
		return uCompany;
	}


	public void setuCompany(String uCompany) {
		this.uCompany = uCompany;
	}



}
