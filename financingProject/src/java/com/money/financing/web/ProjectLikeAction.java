package com.money.financing.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.financing.dto.ProjectLikeDTO;
import com.money.financing.service.IProjectLikeService;
import com.money.financing.web.utils.ResponseUtils;



@Controller
public class ProjectLikeAction {
	static Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IProjectLikeService projectLikeService;

	/**
	 * 根据fa的id获取收藏
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/searchProjectLikeListByCodeForJson.do")
	public void searchProjectLikeListByCodeForJson(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into searchProjectLikeListByCodeForJson");
		List<ProjectLikeDTO> result = new ArrayList<ProjectLikeDTO>();
		String uIdStr = request.getParameter("uId");
		int uId = Integer.parseInt(uIdStr);
		result = projectLikeService.getProjectLikeList(uId);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("result", result);//状态正常
		ResponseUtils.doResponse(response, jsonMap);

	}
	/**
	 * 新增收藏
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insertProjectLikeForJson.do")
	public void insertProjectLikeForJson(HttpServletRequest request, HttpServletResponse response,ProjectLikeDTO dto) {
		logger.info("into insertProjectLikeForJson");
		int id = projectLikeService.insertProjectLike(dto);
		dto.setCreateBy(String.valueOf(dto.getuId()));
		dto.setCreateDate(new Date());
		dto.setUpdateBy(String.valueOf(dto.getuId()));
		dto.setUpdateDate(new Date());
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("id", id);
		ResponseUtils.doResponse(response, jsonMap);

	}

	
	
	
	/**
	 * 删除收藏
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteProjectLikeByIdForJson.do")
	public void deleteProjectLikeByIdForJson(HttpServletRequest request, HttpServletResponse response) {
		logger.info("delete deleteProjectLikeByIdForJson");
		int id = Integer.parseInt(request.getParameter("id"));
		projectLikeService.deleteProjectLike(id);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		ResponseUtils.doResponse(response, jsonMap);

	}

	


}
