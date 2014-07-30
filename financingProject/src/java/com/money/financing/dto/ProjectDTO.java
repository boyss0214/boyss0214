package com.money.financing.dto;

import java.math.BigDecimal;
import java.util.Date;




/**
 * @author Mars
 * @createDate 2014年7月10日
 */
public class ProjectDTO extends BaseDTO{

	private static final long serialVersionUID = 16597129840992541L;

	/**
	 * 产品代码
	 */
	private String pCode;
	
	/**
	 * 产品名称
	 */
	private String pName;
	
	/**
	 * 产品类型
	 */
	private String pType;
	
	/**
	 * 产品预期收益
	 */
	private String pProfit;
	
	/**
	 * 产品开放频率
	 */
	private String pFrequencyOpen;
	
	/**
	 * 期限
	 */
	private int pDueTime;
	
	/**
	 * 简介
	 */
	private String pSummary;
	
	/**
	 * 详情
	 */
	private String pComment;
	
	/**
	 * 总份数
	 */
	private int pCount;
	
	/**
	 * 产品最低投注额
	 */
	private BigDecimal pMinimumAmount;
	
	/**
	 * 分配方式
	 */
	private String pAssignmentType;
	
	/**
	 * 签约方式
	 */
	private String pSignType;
	
	/**
	 * 代理公司
	 */
	private String pAgentCompany;
	
	/**
	 * 销售周期-开始
	 */
	private Date pSaleTimeStart;
	
	/**
	 * 销售周期-结束
	 */
	private Date pSaleTimeEnd;
	
	/**
	 * 管理者
	 */
	private String pManager;
	
	/**
	 * 发布状态，1未发布，2已发布
	 */
	private int pPublicStatus;
	
	/**
	 * 销售周期str-开始
	 */
	private String pSaleTimeStartStr = null;
	
	/**
	 * 销售周期str-结束
	 */
	private String pSaleTimeEndStr = null;
	
	/**
	 * 产品图片
	 */
	private String pImageUrl;
	
	/**
	 * 销售状态 1.未开始 2.募集中 3.募满
	 */
	private int pSaleStutas;
	
	
	
	public int getpSaleStutas() {
		return pSaleStutas;
	}



	public void setpSaleStutas(int pSaleStutas) {
		this.pSaleStutas = pSaleStutas;
	}



	public String getpImageUrl() {
		return pImageUrl;
	}



	public void setpImageUrl(String pImageUrl) {
		this.pImageUrl = pImageUrl;
	}



	public ProjectDTO() {
		super();
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



	public String getpProfit() {
		return pProfit;
	}



	public void setpProfit(String pProfit) {
		this.pProfit = pProfit;
	}



	public String getpFrequencyOpen() {
		return pFrequencyOpen;
	}



	public void setpFrequencyOpen(String pFrequencyOpen) {
		this.pFrequencyOpen = pFrequencyOpen;
	}



	public int getpDueTime() {
		return pDueTime;
	}



	public void setpDueTime(int pDueTime) {
		this.pDueTime = pDueTime;
	}



	public String getpSummary() {
		return pSummary;
	}



	public void setpSummary(String pSummary) {
		this.pSummary = pSummary;
	}



	public String getpComment() {
		return pComment;
	}



	public void setpComment(String pComment) {
		this.pComment = pComment;
	}



	public int getpCount() {
		return pCount;
	}



	public void setpCount(int pCount) {
		this.pCount = pCount;
	}



	public BigDecimal getpMinimumAmount() {
		return pMinimumAmount;
	}



	public void setpMinimumAmount(BigDecimal pMinimumAmount) {
		this.pMinimumAmount = pMinimumAmount;
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



	public Date getpSaleTimeStart() {
		return pSaleTimeStart;
	}



	public void setpSaleTimeStart(Date pSaleTimeStart) {
		this.pSaleTimeStart = pSaleTimeStart;
	}



	public Date getpSaleTimeEnd() {
		return pSaleTimeEnd;
	}



	public void setpSaleTimeEnd(Date pSaleTimeEnd) {
		this.pSaleTimeEnd = pSaleTimeEnd;
	}



	public String getpManager() {
		return pManager;
	}



	public void setpManager(String pManager) {
		this.pManager = pManager;
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



	public int getpPublicStatus() {
		return pPublicStatus;
	}



	public void setpPublicStatus(int pPublicStatus) {
		this.pPublicStatus = pPublicStatus;
	}




}
