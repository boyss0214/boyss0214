package com.money.financing.dao.impl;



import java.util.List;






import org.springframework.stereotype.Repository;

import com.money.financing.dao.IProjectLikeDao;

import com.money.financing.dto.ProjectLikeDTO;


@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("projectLikeDao")
public class ProjectLikeDaoImpl extends BaseDaoImpl<ProjectLikeDTO, java.lang.Integer>
		implements IProjectLikeDao {

	

	@Override
	public Class<ProjectLikeDTO> getEntityClass() {
		return ProjectLikeDTO.class;
	}

	public List<ProjectLikeDTO> getProjectLikeList(int uId) {
		List<ProjectLikeDTO> result = this.getSqlMapClientTemplate().queryForList("pl.searchProjectByCode",uId);
		return result;
	}

	public int insertProjectLike(ProjectLikeDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("pl.insertProjectLikeInfo",dto);
		return id;
	}

	public void deleteProjectLike(int id) {
		this.getSqlMapClientTemplate().delete("pl.deleteProjectLikeById",id);
	}
	
}
