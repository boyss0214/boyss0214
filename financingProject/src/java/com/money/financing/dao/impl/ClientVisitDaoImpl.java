package com.money.financing.dao.impl;



import java.util.List;


import org.springframework.stereotype.Repository;

import com.money.financing.dao.IClientVisitDao;

import com.money.financing.dto.ClientVisitDTO;
import com.money.financing.vo.QueryClientVisitVo;


@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("clientVisitDao")
public class ClientVisitDaoImpl extends BaseDaoImpl<ClientVisitDTO, java.lang.Integer>
		implements IClientVisitDao {

	@Override
	public Class<ClientVisitDTO> getEntityClass() {
		return ClientVisitDTO.class;
	}

	public List<ClientVisitDTO> getClientVisitList(QueryClientVisitVo queryVo) {
		List<ClientVisitDTO> result = this.getSqlMapClientTemplate().queryForList("visit.getClientVisitList",queryVo);
		return result;
	}

	public int getClientVisitListCount(QueryClientVisitVo queryVo) {
		Integer count = (Integer)this.getSqlMapClientTemplate().queryForObject("visit.getClientVisitListCount",queryVo);
		return count;
	}

	public ClientVisitDTO searchClientVisitById(Integer id) {
		ClientVisitDTO dto = (ClientVisitDTO)this.getSqlMapClientTemplate().queryForObject("visit.searchClientVisitById",id);
		return dto;
	}

	public int insertClientVisit(ClientVisitDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("visit.insertClientVisit",dto);
		return id;
	}

	public int updateClientVisit(ClientVisitDTO dto) {
		this.getSqlMapClientTemplate().update("visit.updateClientVisitById",dto);
		return dto.getId();

	
	
	}


}
