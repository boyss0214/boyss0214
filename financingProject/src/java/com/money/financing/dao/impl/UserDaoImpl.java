package com.money.financing.dao.impl;



import java.util.List;


import org.springframework.stereotype.Repository;
import com.money.financing.dao.IUserDao;
import com.money.financing.dto.ClientUserBaseDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.vo.QueryClientUserVo;
import com.money.financing.vo.QueryFaUserVo;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<FaUserDTO, java.lang.Integer>
		implements IUserDao {

	

	@Override
	public Class<FaUserDTO> getEntityClass() {
		return FaUserDTO.class;
	}

	public List<FaUserDTO> getFaUserList(QueryFaUserVo queryVo) {
	
		List<FaUserDTO> result = this.getSqlMapClientTemplate().queryForList("user.getFaUserList",queryVo);
		return result;
	}

	public List<ClientUserBaseDTO> getClientUserList(QueryClientUserVo queryVo) {
		List<ClientUserBaseDTO> result = this.getSqlMapClientTemplate().queryForList("user.getClientUserBaseInfoList",queryVo);
		return result;
	}

	public int getClientUserListCount(QueryClientUserVo queryVo) {
		Integer count = (Integer)this.getSqlMapClientTemplate().queryForObject("user.getClientUserBaseInfoListCount",queryVo);
		return count;
	}

	public ClientUserBaseDTO searchClientUserBaseById(Integer id) {
		ClientUserBaseDTO dto = (ClientUserBaseDTO)this.getSqlMapClientTemplate().queryForObject("user.searchClientUserBaseById",id);
		return dto;
	}

	public int insertClientUserBase(ClientUserBaseDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("user.insertClientUserBase",dto);
		return id;
	}

	public int updateClientUserBase(ClientUserBaseDTO dto) {
		this.getSqlMapClientTemplate().update("user.updateClientUserBaseById",dto);
		return dto.getId();
	}

	public int insertFaUserInfo(FaUserDTO dto) {
		Integer id = (Integer)this.getSqlMapClientTemplate().insert("user.insertFaUserInfo",dto);
		return id;
	}

	public int updateFaUserInfo(FaUserDTO dto) {
		this.getSqlMapClientTemplate().update("user.updateFaUserInfo",dto);
		return dto.getId();
	}

	
	
	


}
