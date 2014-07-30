package com.money.financing.service;

import java.util.List;


import com.money.financing.dto.ProjectLikeDTO;




/**
 * 产品收藏的service
 * @author Mars
 * @createDate 2014年7月10日
 */
public interface IProjectLikeService {

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
	 * 删除收藏
	 * @param dto
	 * @return id
	 */
	public void deleteProjectLike(int id);
}
