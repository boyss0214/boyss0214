package com.money.financing.web;



import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.financing.dto.ClientVisitDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.util.DateUtils;
import com.money.financing.util.ProjectConstants;
import com.money.financing.web.utils.ResponseUtils;
import com.money.financing.service.IClientVisitService;



@Controller
public class ClientVisitAction {
	 Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IClientVisitService clientVisitService;

	/**
	 * 新增客户产品ajax方法
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientVisitFormSubmitAjax.do")
	public void getProjectListForJson(HttpServletRequest request, HttpServletResponse response,ClientVisitDTO dto) {
		logger.info("into getProjectListForJson");
		FaUserDTO loginUser = (FaUserDTO)request.getSession().getAttribute(ProjectConstants.SESSION_KEY_LOGINUSER);		
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		String loginUserCode = loginUser.getuCode();
		
		Date currentTime = new Date();

		String cvDateStr = dto.getCvDateStr();
		Date cvDate = currentTime;
		if(StringUtils.isNotBlank(cvDateStr)){
			cvDate = DateUtils.formatStrToDate(cvDateStr, "yyyy-MM-dd");
		}
		
		dto.setCvDate(cvDate);
		dto.setCreateBy(loginUserCode);
		dto.setCreateDate(currentTime);
		dto.setUpdateBy(loginUserCode);
		dto.setUpdateDate(currentTime);
		
		String visitId = request.getParameter("visitId");
		Integer id = 0;
	
		if(StringUtils.isBlank(visitId)){
			logger.info("====新增访问记录");
			id = clientVisitService.insertClientVisit(dto);
			jsonMap.put("submitType", "1");//新增
		}else{
			logger.info("====修改拜访记录");
			dto.setId(Integer.parseInt(visitId));
			id = clientVisitService.updateClientVisit(dto);
			jsonMap.put("submitType", "2");//修改
		}
		
		
		
		
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("id", id);
		ResponseUtils.doResponse(response, jsonMap);
		return ;

	}

	
	
}
