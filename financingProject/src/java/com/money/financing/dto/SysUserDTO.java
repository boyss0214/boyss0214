package com.money.financing.dto;




/**
 * @author Mars
 * @createDate 2014年7月10日
 */
public class SysUserDTO extends BaseDTO{


	private static final long serialVersionUID = 8408381217932684386L;

	/**
	 * 登录名
	 */
	private String uLoginName;
	/**
	 * 密码
	 */
	private String uPassWord;

	/**
	 * 角色：资深FA、初级FA等
	 */
	private String uRole;


	public SysUserDTO() {
		super();
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


	public String getuRole() {
		return uRole;
	}


	public void setuRole(String uRole) {
		this.uRole = uRole;
	}



}
