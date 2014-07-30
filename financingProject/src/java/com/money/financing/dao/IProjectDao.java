package com.money.financing.dao;

import java.util.List;



import com.money.financing.dto.ProjectDTO;
import com.money.financing.vo.QueryProjectVo;

public interface IProjectDao extends
		IBaseDao<ProjectDTO, java.lang.Integer> {

	/**
	 * 获取产品列表
	 * @param queryVo
	 * @return
	 */
	public List<ProjectDTO> getProjectList(QueryProjectVo queryVo);
	

	/**
	 * 产品总数
	 * @param queryVo
	 * @return
	 */
	public Integer getProjectListCount(QueryProjectVo queryVo);
	
	
	/**
	 * 根据ID获取产品详情
	 * @param id
	 * @return
	 */
	public ProjectDTO searchProjectByIdOrCode(Integer id);
	
	/**
	 * 根据pCode获取产品详情
	 * @param pCode
	 * @return
	 */
	public ProjectDTO searchProjectByIdOrCode(String pCode);
	
	
	/**
	 * 新增产品
	 * @param dto
	 * @return id
	 */
	public int insertProject(ProjectDTO dto);

	/**
	 * 更新产品
	 * @param dto
	 * @return id
	 */
	public int updateProject(ProjectDTO dto);
}
