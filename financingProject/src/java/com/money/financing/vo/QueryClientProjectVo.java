package com.money.financing.vo;



import com.money.financing.dto.ClientProjectDTO;



/**
 * 拜访客户记录信息vo
 * @author Mars
 * @createDate 2014年7月24日
 */
public class QueryClientProjectVo extends BaseVo<ClientProjectDTO> {


	private static final long serialVersionUID = 872852910402590570L;

	public QueryClientProjectVo() {
		super();
	}
	
	

	/**
	 * FA业务编码
	 */
	private String uCode;
	
	/**
	 * 拜访的客户ID
	 */
	private int cpCUserId;
	
	/**
	 * 购买的产品编号
	 */
	private String cpProjectCode;

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
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

	

	
	
	

}
