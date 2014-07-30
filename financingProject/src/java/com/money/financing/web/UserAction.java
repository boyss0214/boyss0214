package com.money.financing.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.financing.dto.ClientProjectDTO;
import com.money.financing.dto.ClientUserBaseDTO;
import com.money.financing.dto.ClientVisitDTO;
import com.money.financing.dto.FaUserDTO;
import com.money.financing.service.IClientProjectService;
import com.money.financing.service.IClientVisitService;
import com.money.financing.service.IUserService;
import com.money.financing.util.ParseXmlUtils;
import com.money.financing.vo.QueryClientProjectVo;
import com.money.financing.vo.QueryClientUserVo;
import com.money.financing.vo.QueryClientVisitVo;
import com.money.financing.vo.QueryFaUserVo;
import com.money.financing.vo.SelectItemVo;
import com.money.financing.web.utils.ResponseUtils;



@Controller
public class UserAction {
	static Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IUserService userService;
	@Autowired
	private IClientVisitService clientVisitService;
	@Autowired
	private IClientProjectService clientProjectService;
	/**
	 * FA详情json格式
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/searchFaUserByIdForJson.do")
	public void searchFaUserByIdForJson(HttpServletRequest request, HttpServletResponse response,QueryFaUserVo queryVo) {
		logger.info("into searchFaUserByIdForJson");
		List<FaUserDTO> result = new ArrayList<FaUserDTO>();
//		QueryFaUserVo queryVo = new QueryFaUserVo();
		result = userService.getFaUserList(queryVo);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		if(result==null||result.isEmpty()){
			jsonMap.put("status", "3");//没有查到相关数据
		}
		jsonMap.put("result", result.get(0));
		ResponseUtils.doResponse(response, jsonMap);

	}

	
	/**
	 * 修改FA信息json格式
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateFaUserByIdForJson.do")
	public void updateFaUserByIdForJson(HttpServletRequest request, HttpServletResponse response,FaUserDTO dto) {
		logger.info("into updateFaUserByIdForJson");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		dto.setuName(request.getParameter("uName"));
		dto.setuLoginName(request.getParameter("uLoginName"));
		dto.setuImage(request.getParameter("uImage"));
		dto.setuCompany(request.getParameter("uCompany"));
		dto.setuAddress(request.getParameter("uAddress"));
		dto.setuRemark(request.getParameter("uRemark"));
		int id = userService.updateFaUserInfo(dto);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("id", id);//状态正常
		ResponseUtils.doResponse(response, jsonMap);

	}
	
	/**
	 * FA列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userList.do")
	public String getFaqList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into UserAction");
		List<FaUserDTO> list = new ArrayList<FaUserDTO>();
		QueryFaUserVo queryVo = new QueryFaUserVo();
		list = userService.getFaUserList(queryVo);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("resultList", list);
		request.setAttribute("resultMap", resultMap);
		return "faUser/faUserList";

	}

	/**
	 * 客户列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientUserList.do")
	public String getClientUserList(HttpServletRequest request, HttpServletResponse response,QueryClientUserVo queryVo) {
		logger.info("into getClientUserList");
		//		queryVo.setPageSize(1);//每页记录条数,默认10条
		Map<String,Object> resultMap = new HashMap<String,Object>();
		request.setAttribute("resultMap", resultMap);
		
		List<ClientUserBaseDTO> list = new ArrayList<ClientUserBaseDTO>();
		ParseXmlUtils xmlUtils = new ParseXmlUtils();
		List<SelectItemVo> sex = xmlUtils.parseApplicationConfigXML("sex");
		List<SelectItemVo> clientLevel = xmlUtils.parseApplicationConfigXML("clientLevel");
		List<SelectItemVo> numberTypeSelect =  xmlUtils.parseApplicationConfigXML("numberTypeSelect");

		list = userService.getClientUserList(queryVo);
		Integer count = userService.getClientUserListCount(queryVo);
		
		resultMap.put("resultCount", count);
		resultMap.put("resultList", list);
		resultMap.put("queryVo", queryVo);
		
		resultMap.put("sexSelect", sex);
		resultMap.put("clientLevelSelect", clientLevel);
		resultMap.put("numberTypeSelect", numberTypeSelect);
		return "clientUser/clientUserList";

	}
	

	/**
	 * 客户基础信息详情展示
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/searchClientUserById.do")
	public String searchProjectById(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into searchProjectById");
//		String uCode = request.getSession().getAttribute("LoginUser");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		request.setAttribute("resultMap", resultMap);
		String uCode  = "001";
		String edit = request.getParameter("edit");
		String clientProject = request.getParameter("clientProject");
		int id = Integer.valueOf(request.getParameter("id"));
		ParseXmlUtils xmlUtils = new ParseXmlUtils();
		List<SelectItemVo> sex = xmlUtils.parseApplicationConfigXML("sex");
		List<SelectItemVo> clientLevel = xmlUtils.parseApplicationConfigXML("clientLevel");
		List<SelectItemVo> numberTypeSelect =  xmlUtils.parseApplicationConfigXML("numberTypeSelect");
		ClientUserBaseDTO dto = userService.searchClientUserBaseById(id);
		resultMap.put("resultObject", dto);
		resultMap.put("sexSelect", sex);
		resultMap.put("clientLevelSelect", clientLevel);
		resultMap.put("numberTypeSelect", numberTypeSelect);
		
		if("1".equals(edit)){
			//调至编辑页面
			logger.info("to clientUserEdit");
			return "clientUser/clientUserEdit";
		}
		if("1".equals(clientProject)){
			//调至客户涉及产品页面
			logger.info("to clientProject");
			QueryClientProjectVo clientProjectQueryVo = new QueryClientProjectVo();
//			clientProjectQueryVo.setPageSize(1);
			String currentPageStr = request.getParameter("currentPage");
			if(StringUtils.isNotBlank(currentPageStr)){
				clientProjectQueryVo.setCurrentPage(Integer.parseInt(currentPageStr));
			}
			
			
			clientProjectQueryVo.setCpCUserId(id);
			clientProjectQueryVo.setuCode(uCode);
			List<SelectItemVo> cpProjectStatusSelect = xmlUtils.parseApplicationConfigXML("cpProjectStatusSelect");
			List<ClientProjectDTO> clientProjectList = clientProjectService.getClientProjectList(clientProjectQueryVo);
			Integer count = clientProjectService.getClientProjectListCount(clientProjectQueryVo);
			

			resultMap.put("resultCount", count);
			resultMap.put("queryVo", clientProjectQueryVo);
			resultMap.put("resultList", clientProjectList);
			
			resultMap.put("cpProjectStatusSelect", cpProjectStatusSelect);
			

			return "clientUser/clientProjectList";
		}
		//详情查看页面
		logger.info("to searchClientUserById");
		QueryClientVisitVo visitQueryVo = new QueryClientVisitVo();
	
		String currentPageStr = request.getParameter("currentPage");
		if(StringUtils.isNotBlank(currentPageStr)){
			visitQueryVo.setCurrentPage(Integer.parseInt(currentPageStr));
		}
		
		visitQueryVo.setCvCUserId(id);
		visitQueryVo.setuCode(uCode);
		
		List<SelectItemVo> cvTypeSelect = xmlUtils.parseApplicationConfigXML("cvTypeSelect");
		
		List<ClientVisitDTO> clientVisitList = clientVisitService.getClientVisitList(visitQueryVo);
		Integer count = clientVisitService.getClientVisitListCount(visitQueryVo);
		
		resultMap.put("resultCount", count);
		resultMap.put("queryVo", visitQueryVo);
		
		resultMap.put("cvTypeSelect", cvTypeSelect);
		resultMap.put("resultList", clientVisitList);
		return "clientUser/searchClientUserById";

	}

	/**
	 * 产品新增页面初始化
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientUserAdd.do")
	public String addProjectInit(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into clientUserAdd");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		request.setAttribute("resultMap", resultMap);
		
		ParseXmlUtils xmlUtils = new ParseXmlUtils();
		List<SelectItemVo> sex = xmlUtils.parseApplicationConfigXML("sex");
		List<SelectItemVo> clientLevel = xmlUtils.parseApplicationConfigXML("clientLevel");
		List<SelectItemVo> numberTypeSelect =  xmlUtils.parseApplicationConfigXML("numberTypeSelect");
		String cPaCodeDefault = "001";//FA的业务编码
		resultMap.put("sexSelect", sex);
		resultMap.put("clientLevelSelect", clientLevel);
		resultMap.put("numberTypeSelect", numberTypeSelect);
		resultMap.put("cPaCodeDefault", cPaCodeDefault);



		return "clientUser/clientUserAdd";

	}
	/**
	 * 客户新增
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientUserAddSubmit.do")
	public String clientUserAddSubmit(HttpServletRequest request, HttpServletResponse response,ClientUserBaseDTO dto) {
		logger.info("into clientUserAddSubmit");
		try {
			//			String loginUser = (String)request.getSession().getAttribute("loginUser");
			String loginUser = "sys";

			dto.setCreateBy(loginUser);
			dto.setUpdateBy(loginUser);
			userService.insertClientUserBase(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/clientUserList.do";

	}

	/**
	 * 产品修改
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/clientUserUpdateSubmit.do")
	public String clientUserUpdateSubmit(HttpServletRequest request, HttpServletResponse response,ClientUserBaseDTO dto) {
		logger.info("into updateProjectSubmit");
		try {
			request.setCharacterEncoding("utf-8");
			//			String loginUser = (String)request.getSession().getAttribute("loginUser");
			String loginUser = "sys";

			dto.setUpdateBy(loginUser);
			userService.updateClientUserBase(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/clientUserList.do";

	}




}
