package com.money.financing.vo;


import com.money.financing.dto.FaUserDTO;

public class QueryFaUserVo extends BaseVo<FaUserDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4537757248947402578L;
	
	/**
	 * 登录名
	 */
	private String uLoginName;
	
	/**
	 * 密码
	 */
	private String uPassWord;

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
	
	
}
