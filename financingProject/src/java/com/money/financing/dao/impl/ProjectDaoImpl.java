package com.money.financing.dao.impl;



import java.util.List;



import org.springframework.stereotype.Repository;

import com.money.financing.dao.IProjectDao;
import com.money.financing.dto.ProjectDTO;
import com.money.financing.vo.QueryProjectVo;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<ProjectDTO, java.lang.Integer>
		implements IProjectDao {

	

	@Override
	public Class<ProjectDTO> getEntityClass() {
		return ProjectDTO.class;
	}

	public List<ProjectDTO> getProjectList(QueryProjectVo queryVo) {
		List<ProjectDTO> result = this.getSqlMapClientTemplate().queryForList("crm.getProjectList",queryVo);
		return result;
	}
	
	public Integer getProjectListCount(QueryProjectVo queryVo) {
		Integer count = (Integer)this.getSqlMapClientTemplate().queryForObject("crm.getProjectListCount",queryVo);
		return count;
	}
	

	public int insertProject(ProjectDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("crm.insertProject",dto);
		return id;
	}

	public int updateProject(ProjectDTO dto) {
		this.getSqlMapClientTemplate().update("crm.updateProjectById",dto);
		return dto.getId();
	}

	public ProjectDTO searchProjectByIdOrCode(Integer id) {
		ProjectDTO dto = (ProjectDTO)this.getSqlMapClientTemplate().queryForObject("crm.searchProjectById",id);
		return dto;
	}
	public ProjectDTO searchProjectByIdOrCode(String pCode) {
		ProjectDTO dto = (ProjectDTO)this.getSqlMapClientTemplate().queryForObject("crm.searchProjectByCode",pCode);
		return dto;
	}
	
}
