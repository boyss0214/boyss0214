package com.money.financing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.money.financing.dao.IClientVisitDao;
import com.money.financing.dto.ClientVisitDTO;
import com.money.financing.service.IClientVisitService;
import com.money.financing.vo.QueryClientVisitVo;


@Service("clientVisitService")
public class ClientVisitServiceImpl implements IClientVisitService {
	@Autowired
	private IClientVisitDao clientVisitDao;

	public List<ClientVisitDTO> getClientVisitList(QueryClientVisitVo queryVo) {
		
		return clientVisitDao.getClientVisitList(queryVo);
	}

	public int getClientVisitListCount(QueryClientVisitVo queryVo) {
		
		return clientVisitDao.getClientVisitListCount(queryVo);
	}

	public ClientVisitDTO searchClientVisitById(Integer id) {
		
		return clientVisitDao.searchClientVisitById(id);
	}

	public int insertClientVisit(ClientVisitDTO dto) {
		
		return clientVisitDao.insertClientVisit(dto);
	}

	public int updateClientVisit(ClientVisitDTO dto) {

		return clientVisitDao.updateClientVisit(dto);
	}

	
}
