package com.money.financing.service;

import java.util.List;






import com.money.financing.dto.ProjectDTO;
import com.money.financing.vo.QueryProjectVo;



/**
 * 产品信息的service
 * @author Mars
 * @createDate 2014年7月10日
 */
public interface IProjectService {

	/**
	 * 查询系统中产品信息
	 * @param queryVo
	 * @return
	 */
	public List<ProjectDTO> getProjectList(QueryProjectVo queryVo);
	
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
	 * 查询产品总数
	 * @param queryVo
	 * @return
	 */
	public Integer getProjectListCount(QueryProjectVo queryVo);

	
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
