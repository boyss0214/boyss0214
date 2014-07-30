package com.money.financing.web;



import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.financing.dto.ClientProjectDTO;
import com.money.financing.web.utils.ResponseUtils;
import com.money.financing.service.IClientProjectService;



@Controller
public class ClientProjectAction {
	 Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IClientProjectService clientProjectService;

	/**
	 * 新增客户产品ajax方法
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientProjectFormSubmitAjax.do")
	public void getProjectListForJson(HttpServletRequest request, HttpServletResponse response,ClientProjectDTO dto) {
		logger.info("into getProjectListForJson");
//		String loginUser = request.getSession().getAttribute("");
		String loginUser = "sys";
		Date currentTime = new Date();
		
		
		dto.setCreateBy(loginUser);
		dto.setCreateDate(currentTime);
		dto.setUpdateBy(loginUser);
		dto.setUpdateDate(currentTime);
		
		
		Integer id = clientProjectService.insertClientProject(dto);
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("id", id);
		ResponseUtils.doResponse(response, jsonMap);
		return ;

	}

	
	
}
