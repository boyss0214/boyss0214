package com.money.financing.service;

import java.util.List;



import com.money.financing.dto.ClientProjectDTO;
import com.money.financing.vo.QueryClientProjectVo;





/**
 * 用户涉及产品信息service
 * @author Mars
 * @createDate 2014年7月10日
 */
public interface IClientProjectService {


	
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
