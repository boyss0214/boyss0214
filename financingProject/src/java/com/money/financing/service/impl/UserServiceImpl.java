package com.money.financing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import com.money.financing.dao.IUserDao;
import com.money.financing.dto.ClientUserBaseDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.service.IUserService;
import com.money.financing.vo.QueryClientUserVo;
import com.money.financing.vo.QueryFaUserVo;


@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	public List<FaUserDTO> getFaUserList(QueryFaUserVo queryVo) {
		List<FaUserDTO> l= userDao.getFaUserList(queryVo);
		return l;
	}

	public List<ClientUserBaseDTO> getClientUserList(QueryClientUserVo queryVo) {

		return userDao.getClientUserList(queryVo);
	}

	public int getClientUserListCount(QueryClientUserVo queryVo) {
		
		return userDao.getClientUserListCount(queryVo);
	}

	public ClientUserBaseDTO searchClientUserBaseById(Integer id) {

		return userDao.searchClientUserBaseById(id);
	}

	public int insertClientUserBase(ClientUserBaseDTO dto) {
		return userDao.insertClientUserBase(dto);
	}

	public int updateClientUserBase(ClientUserBaseDTO dto) {
		return userDao.updateClientUserBase(dto);
	}

	public int insertFaUserInfo(FaUserDTO dto) {
		return userDao.insertFaUserInfo(dto);
	}

	public int updateFaUserInfo(FaUserDTO dto) {
		return userDao.updateFaUserInfo(dto);
	}


}
