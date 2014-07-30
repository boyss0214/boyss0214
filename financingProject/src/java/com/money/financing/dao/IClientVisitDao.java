package com.money.financing.dao;

import java.util.List;


import com.money.financing.dto.ClientVisitDTO;
import com.money.financing.vo.QueryClientVisitVo;

public interface IClientVisitDao extends
		IBaseDao<ClientVisitDTO, java.lang.Integer> {

	

	
	/**
	 * 客户拜访记录列表
	 * @param queryVo
	 * @return
	 */
	public List<ClientVisitDTO> getClientVisitList(QueryClientVisitVo queryVo);
	

	/**
	 * 记录数
	 * @param queryVo
	 * @return
	 */
	public  int getClientVisitListCount(QueryClientVisitVo queryVo);
	
	/**
	 * 拜访详情
	 * @param queryVo
	 * @return
	 */
	public ClientVisitDTO searchClientVisitById(Integer id);
	
	/**
	 * 新增客户拜访信息
	 * @param dto
	 * @return id
	 */
	public int insertClientVisit(ClientVisitDTO dto);

	/**
	 * 修改客户拜访信息
	 * @param dto
	 * @return id
	 */
	public int updateClientVisit(ClientVisitDTO dto);
}
