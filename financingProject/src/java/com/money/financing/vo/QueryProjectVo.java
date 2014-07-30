package com.money.financing.vo;


import com.money.financing.dto.ProjectDTO;


public class QueryProjectVo extends BaseVo<ProjectDTO>{
	
	

	private static final long serialVersionUID = 1353705867388785237L;

	/**
	 * 产品代码
	 */
	private String pCode = null;
	
	/**
	 * 产品名称
	 */
	private String pName = null;
	
	/**
	 * 产品类型
	 */
	private String pType = null;
	
	/**
	 * 分配方式
	 */
	private String pAssignmentType = null;
	
	/**
	 * 签约方式
	 */
	private String pSignType = null;
	
	/**
	 * 代理公司
	 */
	private String pAgentCompany = null;
	
	/**
	 * 发布状态，1未发布，2已发布
	 */
	private int pPublicStatus;
	
	/**
	 * 购买周期-开始
	 */
	private String pSaleTimeStartStr = null;
	/**
	 * 购买周期-结束
	 */
	private String pSaleTimeEndStr = null;

	
	/**
	 * 销售周期查询类型1：开始结束时间都有，2：只查询开始时间，3只查询结束时间
	 */
	private String SaleTimeType = "0";
	
	

	
	
	public int getpPublicStatus() {
		return pPublicStatus;
	}

	public void setpPublicStatus(int pPublicStatus) {
		this.pPublicStatus = pPublicStatus;
	}

	public String getSaleTimeType() {
		return SaleTimeType;
	}

	public void setSaleTimeType(String saleTimeType) {
		SaleTimeType = saleTimeType;
	}

	public String getpSaleTimeStartStr() {
		return pSaleTimeStartStr;
	}

	public void setpSaleTimeStartStr(String pSaleTimeStartStr) {
		this.pSaleTimeStartStr = pSaleTimeStartStr;
	}

	public String getpSaleTimeEndStr() {
		return pSaleTimeEndStr;
	}

	public void setpSaleTimeEndStr(String pSaleTimeEndStr) {
		this.pSaleTimeEndStr = pSaleTimeEndStr;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	
	public String getpAssignmentType() {
		return pAssignmentType;
	}

	public void setpAssignmentType(String pAssignmentType) {
		this.pAssignmentType = pAssignmentType;
	}

	public String getpSignType() {
		return pSignType;
	}

	public void setpSignType(String pSignType) {
		this.pSignType = pSignType;
	}

	public String getpAgentCompany() {
		return pAgentCompany;
	}

	public void setpAgentCompany(String pAgentCompany) {
		this.pAgentCompany = pAgentCompany;
	}

	

	
	
}
