package com.money.financing.web;




import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import com.money.financing.dto.FaUserDTO;

import com.money.financing.util.ProjectConstants;
import com.money.financing.vo.QueryFaUserVo;
import com.money.financing.web.utils.ResponseUtils;
import com.money.financing.service.IUserService;



@Controller
public class LoginAction {
	 Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IUserService userService;

	/**
	 * 登录ajax方法
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loginActionAjax.do")
	public void loginAjax(HttpServletRequest request, HttpServletResponse response) {
		logger.info("===>into loginActionAjax");
		Map<String,Object> jsonMap = new HashMap<String,Object>();
//		String loginUser = request.getSession().getAttribute("");
		String loginName = request.getParameter("uLoginName");
		String passWord = request.getParameter("uPassWord");
		QueryFaUserVo queryVo = new QueryFaUserVo();
		queryVo.setuLoginName(loginName);
		List<FaUserDTO> faUserList = userService.getFaUserList(queryVo);
		FaUserDTO faUserDTO = null;
		
		if(faUserList.size()>0){
			faUserDTO = faUserList.get(0);
			if(passWord.equals(faUserDTO.getuPassWord())){
				//
				logger.info("====>登录成功！登录账号："+faUserDTO.getuLoginName());
				jsonMap.put("status", "1");
				request.getSession().setAttribute(ProjectConstants.SESSION_KEY_LOGINUSER, faUserDTO);
			}else{
				logger.info("====>密码错误！登录账号："+faUserDTO.getuLoginName());
				jsonMap.put("status", "3");
			}
		}else{
			logger.info("====>账号错误！登录使用错误账号："+loginName);
			jsonMap.put("status", "2");
		}

		ResponseUtils.doResponse(response, jsonMap);
		return ;

	}

	
	
}
