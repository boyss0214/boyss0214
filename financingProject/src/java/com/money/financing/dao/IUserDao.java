package com.money.financing.dao;

import java.util.List;

import com.money.financing.dto.ClientUserBaseDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.vo.QueryClientUserVo;
import com.money.financing.vo.QueryFaUserVo;

public interface IUserDao extends
		IBaseDao<FaUserDTO, java.lang.Integer> {

	/**
	 * Fa列表
	 * @param queryVo
	 * @return
	 */
	public List<FaUserDTO> getFaUserList(QueryFaUserVo queryVo);

	/**
	 * 新增FA信息
	 * @param queryVo
	 * @return
	 */
	public int insertFaUserInfo(FaUserDTO dto);
	
	/**
	 * 更新FA信息
	 * @param dto
	 * @return id
	 */
	public int updateFaUserInfo(FaUserDTO dto);
	/**
	 * 客户列表
	 * @param queryVo
	 * @return
	 */
	public List<ClientUserBaseDTO> getClientUserList(QueryClientUserVo queryVo);
	

	/**
	 * 记录数
	 * @param queryVo
	 * @return
	 */
	public  int getClientUserListCount(QueryClientUserVo queryVo);
	
	/**
	 * 获取客户基础信息列表
	 * @param queryVo
	 * @return
	 */
	public ClientUserBaseDTO searchClientUserBaseById(Integer id);
	
	/**
	 * 新增客户基础信息
	 * @param dto
	 * @return id
	 */
	public int insertClientUserBase(ClientUserBaseDTO dto);

	/**
	 * 更新客户基础信息
	 * @param dto
	 * @return id
	 */
	public int updateClientUserBase(ClientUserBaseDTO dto);
}
