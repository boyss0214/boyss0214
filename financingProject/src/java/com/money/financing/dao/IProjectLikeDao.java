package com.money.financing.dao;

import java.util.List;





import com.money.financing.dto.ProjectLikeDTO;


public interface IProjectLikeDao extends
		IBaseDao<ProjectLikeDTO, java.lang.Integer> {

	/**
	 * 获取收藏列表
	 * @param uCode FA编码
	 * @return
	 */
	public List<ProjectLikeDTO> getProjectLikeList(int uId);
	
	/**
	 * 新增收藏
	 * @param dto
	 * @return id
	 */
	public int insertProjectLike(ProjectLikeDTO dto);

	/**
	 * 更新产品
	 * @param dto
	 * @return id
	 */
	public void deleteProjectLike(int id);
}
