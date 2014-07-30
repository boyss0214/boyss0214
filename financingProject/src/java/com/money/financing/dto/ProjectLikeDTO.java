package com.money.financing.dto;





/**
 * 收藏关联DTO
 * @author Mars
 * @createDate 2014年7月10日
 */
public class ProjectLikeDTO extends BaseDTO{



	private static final long serialVersionUID = -5394325781089418716L;

	/**
	 * 产品ID
	 */
	private int pId;
	
	/**
	 * 产品名称
	 */
	private String pName;
	
	/**
	 * 预期收益
	 */
	private String pProfit;
	
	/**
	 * 期限
	 */
	private int pDueTime;
	
	/**
	 * 详情
	 */
	private String pComment;
	/**
	 * FA的ID
	 */
	private int uId;
	
	/**
	 * 类型，1收藏
	 */
	private int likeType;
	
	
	
	
	
	public String getpComment() {
		return pComment;
	}

	public void setpComment(String pComment) {
		this.pComment = pComment;
	}

	public String getpProfit() {
		return pProfit;
	}

	public void setpProfit(String pProfit) {
		this.pProfit = pProfit;
	}

	public int getpDueTime() {
		return pDueTime;
	}

	public void setpDueTime(int pDueTime) {
		this.pDueTime = pDueTime;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getLikeType() {
		return likeType;
	}

	public void setLikeType(int likeType) {
		this.likeType = likeType;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	
}
