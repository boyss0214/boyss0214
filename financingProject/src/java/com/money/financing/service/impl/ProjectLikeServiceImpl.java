package com.money.financing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.financing.dao.IProjectDao;
import com.money.financing.dto.ProjectDTO;
import com.money.financing.service.IProjectService;
import com.money.financing.vo.QueryProjectVo;

@Service("projectService")
public class ProjectLikeServiceImpl implements IProjectService {
	@Autowired
	private IProjectDao projectDao;

	public List<ProjectDTO> getProjectList(QueryProjectVo queryVo) {
		List<ProjectDTO> l= projectDao.getProjectList(queryVo);
		return l;
	}

	public int insertProject(ProjectDTO dto) {
		
		return projectDao.insertProject(dto);
	}

	public Integer getProjectListCount(QueryProjectVo queryVo) {
		return projectDao.getProjectListCount(queryVo);
	}

	public int updateProject(ProjectDTO dto) {
		
		return projectDao.updateProject(dto);
	}

	public ProjectDTO searchProjectByIdOrCode(Integer id) {
		
		return projectDao.searchProjectByIdOrCode(id);
	}

	public ProjectDTO searchProjectByIdOrCode(String pCode) {
		
		return projectDao.searchProjectByIdOrCode(pCode);
	}
}
