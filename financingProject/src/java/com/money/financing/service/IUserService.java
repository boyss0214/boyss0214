package com.money.financing.service;

import java.util.List;







import com.money.financing.dto.ClientUserBaseDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.vo.QueryClientUserVo;
import com.money.financing.vo.QueryFaUserVo;



/**
 * 用户信息控制service
 * @author Mars
 * @createDate 2014年7月10日
 */
public interface IUserService {

	/**
	 * 查询系统中FA信息
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
	 * 获取客户基础信息详情
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
