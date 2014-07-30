package com.money.financing.dao.impl;



import java.util.List;





import org.springframework.stereotype.Repository;

import com.money.financing.dao.IClientProjectDao;

import com.money.financing.dto.ClientProjectDTO;

import com.money.financing.vo.QueryClientProjectVo;



@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("clientProjectDao")
public class ClientProjectDaoImpl extends BaseDaoImpl<ClientProjectDTO, java.lang.Integer>
		implements IClientProjectDao {

	@Override
	public Class<ClientProjectDTO> getEntityClass() {
		return ClientProjectDTO.class;
	}

	public List<ClientProjectDTO> getClientProjectList(QueryClientProjectVo queryVo) {
		List<ClientProjectDTO> result = this.getSqlMapClientTemplate().queryForList("visit.getClientProjectList",queryVo);
		return result;
	}

	public int getClientProjectListCount(QueryClientProjectVo queryVo) {
		Integer count = (Integer)this.getSqlMapClientTemplate().queryForObject("visit.getClientProjectListCount",queryVo);
		return count;
	}

	public ClientProjectDTO searchClientProjectById(Integer id) {
		ClientProjectDTO dto = (ClientProjectDTO)this.getSqlMapClientTemplate().queryForObject("visit.searchClientProjectById",id);
		return dto;
	}

	public int insertClientProject(ClientProjectDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("visit.insertClientProject",dto);
		return id;
	}

	public int updateClientProject(ClientProjectDTO dto) {
		this.getSqlMapClientTemplate().update("visit.updateClientProjectById",dto);
		return dto.getId();

	
	
	}



}
