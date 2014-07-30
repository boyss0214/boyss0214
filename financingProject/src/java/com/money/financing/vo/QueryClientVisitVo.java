package com.money.financing.vo;



import com.money.financing.dto.ClientVisitDTO;


/**
 * 拜访客户记录信息vo
 * @author Mars
 * @createDate 2014年7月24日
 */
public class QueryClientVisitVo extends BaseVo<ClientVisitDTO> {


	private static final long serialVersionUID = 872852910402590570L;

	public QueryClientVisitVo() {
		super();
	}
	
	

	/**
	 * FA业务编码
	 */
	private String uCode;
	
	/**
	 * 拜访的客户ID
	 */
	private int cvCUserId;
	
	/**
	 * 产品编号
	 */
	private String cvPCode;

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public int getCvCUserId() {
		return cvCUserId;
	}

	public void setCvCUserId(int cvCUserId) {
		this.cvCUserId = cvCUserId;
	}

	public String getCvPCode() {
		return cvPCode;
	}

	public void setCvPCode(String cvPCode) {
		this.cvPCode = cvPCode;
	}
	
	

}
