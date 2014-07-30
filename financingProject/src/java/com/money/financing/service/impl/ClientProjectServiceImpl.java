package com.money.financing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.financing.dao.IClientProjectDao;

import com.money.financing.dto.ClientProjectDTO;

import com.money.financing.service.IClientProjectService;

import com.money.financing.vo.QueryClientProjectVo;



@Service("clientProjectService")
public class ClientProjectServiceImpl implements IClientProjectService {
	@Autowired
	private IClientProjectDao clientProjectDao;

	public List<ClientProjectDTO> getClientProjectList(
			QueryClientProjectVo queryVo) {
		
		return clientProjectDao.getClientProjectList(queryVo);
	}

	public int getClientProjectListCount(QueryClientProjectVo queryVo) {
		
		return clientProjectDao.getClientProjectListCount(queryVo);
	}

	public ClientProjectDTO searchClientProjectById(Integer id) {
		
		return clientProjectDao.searchClientProjectById(id);
	}

	public int insertClientProject(ClientProjectDTO dto) {
		
		return clientProjectDao.insertClientProject(dto);
	}

	public int updateClientProject(ClientProjectDTO dto) {
		clientProjectDao.updateClientProject(dto);
		return dto.getId();
	}

	
	
}
