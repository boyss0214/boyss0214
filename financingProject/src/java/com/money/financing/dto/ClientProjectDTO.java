package com.money.financing.dto;


import java.math.BigDecimal;





/**
 * 客户涉及产品信息表
 * @author Mars
 * @createDate 2014年7月10日
 */
public class ClientProjectDTO extends BaseDTO{


	private static final long serialVersionUID = 2671620733315266205L;
	
	private int id;

	/**
	 * 拜访的客户ID
	 */
	private int cpCUserId;
	
	/**
	 * 购买的产品编号
	 */
	private String cpProjectCode;
	
	/**
	 * FA业务编码
	 */
	private String uCode;
	
	/**
	 * 购买份额
	 */
	private int cpShare;
	
	/**
	 * 购买产品总价
	 */
	private BigDecimal cpValue;
	
	/**
	 * 总收益
	 */
	private BigDecimal cpGain;
	
	/**
	 * 客户产品状态：1成单，2促单，3推单
	 */
	private String cpProjectStatus;
	
	public ClientProjectDTO() {
		super();
	}

	public int getCpCUserId() {
		return cpCUserId;
	}

	public void setCpCUserId(int cpCUserId) {
		this.cpCUserId = cpCUserId;
	}

	public String getCpProjectCode() {
		return cpProjectCode;
	}

	public void setCpProjectCode(String cpProjectCode) {
		this.cpProjectCode = cpProjectCode;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public int getCpShare() {
		return cpShare;
	}

	public void setCpShare(int cpShare) {
		this.cpShare = cpShare;
	}

	public BigDecimal getCpValue() {
		return cpValue;
	}

	public void setCpValue(BigDecimal cpValue) {
		this.cpValue = cpValue;
	}

	public BigDecimal getCpGain() {
		return cpGain;
	}

	public void setCpGain(BigDecimal cpGain) {
		this.cpGain = cpGain;
	}

	public String getCpProjectStatus() {
		return cpProjectStatus;
	}

	public void setCpProjectStatus(String cpProjectStatus) {
		this.cpProjectStatus = cpProjectStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}

