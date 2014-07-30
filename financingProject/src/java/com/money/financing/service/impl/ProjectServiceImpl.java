package com.money.financing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.financing.dao.IProjectLikeDao;

import com.money.financing.dto.ProjectLikeDTO;
import com.money.financing.service.IProjectLikeService;

@Service("projectLikeService")
public class ProjectServiceImpl implements IProjectLikeService {
	@Autowired
	private IProjectLikeDao projectLikeDao;

	public List<ProjectLikeDTO> getProjectLikeList(int uId) {
		return projectLikeDao.getProjectLikeList(uId);
	}

	public int insertProjectLike(ProjectLikeDTO dto) {
		return projectLikeDao.insertProjectLike(dto);
	}

	public void deleteProjectLike(int id) {
		projectLikeDao.deleteProjectLike(id);
		
	}


	
}
