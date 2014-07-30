package com.money.financing.dao;

import java.util.List;

import com.money.financing.dto.ClientProjectDTO;
import com.money.financing.vo.QueryClientProjectVo;



/**
 * 客户涉及产品关系表
 * @author Mars
 * @createDate 2014年7月24日
 */
public interface IClientProjectDao extends
		IBaseDao<ClientProjectDTO, java.lang.Integer> {
	/**
	 * 客户涉及产品列表
	 * @param queryVo
	 * @return
	 */
	public List<ClientProjectDTO> getClientProjectList(QueryClientProjectVo queryVo);
	

	/**
	 * 记录数
	 * @param queryVo
	 * @return
	 */
	public  int getClientProjectListCount(QueryClientProjectVo queryVo);
	
	/**
	 * 客户涉及产品详情
	 * @param queryVo
	 * @return
	 */
	public ClientProjectDTO searchClientProjectById(Integer id);
	
	/**
	 * 新增客户关联产品信息
	 * @param dto
	 * @return id
	 */
	public int insertClientProject(ClientProjectDTO dto);

	/**
	 * 修改客户关联产品信息
	 * @param dto
	 * @return id
	 */
	public int updateClientProject(ClientProjectDTO dto);
}
