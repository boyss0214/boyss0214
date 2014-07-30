package com.money.financing.web;


import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.financing.dto.ProjectDTO;
import com.money.financing.vo.SelectItemVo;
import com.money.financing.vo.QueryProjectVo;
import com.money.financing.web.utils.ResponseUtils;
import com.money.financing.service.IProjectService;
import com.money.financing.util.DateUtils;
import com.money.financing.util.ParseXmlUtils;



@Controller
public class ProjectAction {
	 Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IProjectService projectService;

	/**
	 * 产品列表接口说明：
	 * 接口入参：currentPage：当前页
	 * 接口出参：status：接口返回状态，currentPage：当前页，count：总条数,pageSize:每页记录数，result：返回记录集合，详见ProjectDTO
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectListForJson.do")
	public void getProjectListForJson(HttpServletRequest request, HttpServletResponse response,QueryProjectVo queryVo) {
		logger.info("into getProjectListForJson");
		List<ProjectDTO> result = new ArrayList<ProjectDTO>();
		queryVo.setPageSize(5);
		Integer count = projectService.getProjectListCount(queryVo);
		result = projectService.getProjectList(queryVo);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("currentPage", queryVo.getCurrentPage());
		jsonMap.put("pageSize", queryVo.getPageSize());
		jsonMap.put("count", count);
		jsonMap.put("result", result);
		ResponseUtils.doResponse(response, jsonMap);
		return ;

	}

	
	/**
	 * 产品详情展示接口说明：
	 * 接口入参：id
	 * 接口出参：产品详情，详见projectDTO
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/searchProjectByIdForJson.do")
	public void searchProjectByIdForJson(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into searchProjectById");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		ProjectDTO dto = projectService.searchProjectByIdOrCode(id);
//		ParseXmlUtils xmlUtils = new ParseXmlUtils();
//		List<SelectItemVo> pTypeItems = xmlUtils.parseApplicationConfigXML("pType");
//		List<SelectItemVo> pAssignmentTypeItems = xmlUtils.parseApplicationConfigXML("pAssignmentType");
//		List<SelectItemVo> pSignTypeItems = xmlUtils.parseApplicationConfigXML("pSignType");
//		List<SelectItemVo> pAgentCompanyItems = xmlUtils.parseApplicationConfigXML("pAgentCompany");	
//		request.setAttribute("resultObject", dto);
//		request.setAttribute("pTypeItems", pTypeItems);
//		request.setAttribute("pAssignmentTypeItems", pAssignmentTypeItems);
//		request.setAttribute("pSignTypeItems", pSignTypeItems);
//		request.setAttribute("pAgentCompanyItems", pAgentCompanyItems);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("status", "1");//状态正常
		jsonMap.put("result", dto);
		ResponseUtils.doResponse(response, jsonMap);
		return;

	}
	
	
		/**
		 * 产品详情展示
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value = "/searchProjectById.do")
		public String searchProjectById(HttpServletRequest request, HttpServletResponse response) {
			logger.info("into searchProjectById");
			Map<String,Object> resultMap = new HashMap<String,Object>();
			request.setAttribute("resultMap", resultMap);
			
			String edit = request.getParameter("edit");
			String idStr = request.getParameter("id");
			String pCode = request.getParameter("pCode");
			ProjectDTO dto = null;
			if(StringUtils.isNotBlank(pCode)){
				dto = projectService.searchProjectByIdOrCode(pCode);
			}else if(StringUtils.isNotBlank(idStr)){
				int id = Integer.valueOf(idStr);
				dto = projectService.searchProjectByIdOrCode(id);
			}
			
			ParseXmlUtils xmlUtils = new ParseXmlUtils();
			List<SelectItemVo> pTypeItems = xmlUtils.parseApplicationConfigXML("pType");
			List<SelectItemVo> pAssignmentTypeItems = xmlUtils.parseApplicationConfigXML("pAssignmentType");
			List<SelectItemVo> pSignTypeItems = xmlUtils.parseApplicationConfigXML("pSignType");
			List<SelectItemVo> pAgentCompanyItems = xmlUtils.parseApplicationConfigXML("pAgentCompany");
			List<SelectItemVo> pPublicStatusSelect = xmlUtils.parseApplicationConfigXML("pPublicStatusSelect");
			
			resultMap.put("resultObject", dto);
			resultMap.put("pTypeItems", pTypeItems);
			resultMap.put("pAssignmentTypeItems", pAssignmentTypeItems);
			resultMap.put("pSignTypeItems", pSignTypeItems);
			resultMap.put("pAgentCompanyItems", pAgentCompanyItems);
			resultMap.put("pPublicStatusSelect", pPublicStatusSelect);
			
			if("1".equals(edit)){
				logger.info("to projectEdit");
				return "project/projectEdit";
			}
			logger.info("to searchProjectById");
			return "project/searchProjectById";

		}
	/**
	 * 产品列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectList.do")
	public String getProjectList(HttpServletRequest request, HttpServletResponse response,QueryProjectVo queryVo) {
		logger.info("into getProjectList");
		List<ProjectDTO> list = new ArrayList<ProjectDTO>();
		logger.info("=====当前页pageSize数=====");
//		queryVo.setPageSize(5);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		request.setAttribute("resultMap", resultMap);
		
		ParseXmlUtils xmlUtils = new ParseXmlUtils();
		List<SelectItemVo> pTypeItems = xmlUtils.parseApplicationConfigXML("pType");
		List<SelectItemVo> pAssignmentTypeItems = xmlUtils.parseApplicationConfigXML("pAssignmentType");
		List<SelectItemVo> pSignTypeItems = xmlUtils.parseApplicationConfigXML("pSignType");
		List<SelectItemVo> pAgentCompanyItems = xmlUtils.parseApplicationConfigXML("pAgentCompany");
		if(StringUtils.isNotBlank(queryVo.getpSaleTimeStartStr())&&StringUtils.isNotBlank(queryVo.getpSaleTimeEndStr())){
			logger.info("========销售周期开始及结束都作为查询条件=====");
			queryVo.setSaleTimeType("1");
		}else{
			if(StringUtils.isNotBlank(queryVo.getpSaleTimeStartStr())&&StringUtils.isBlank(queryVo.getpSaleTimeEndStr())){
				logger.info("========销售周期开始作为查询条件=====");
				queryVo.setSaleTimeType("2");
			}
			if(StringUtils.isBlank(queryVo.getpSaleTimeStartStr())&&StringUtils.isNotBlank(queryVo.getpSaleTimeEndStr())){
				logger.info("========销售周期结束都作为查询条件=====");
				queryVo.setSaleTimeType("3");
			}
		}
		
		Integer count = projectService.getProjectListCount(queryVo);
		list = projectService.getProjectList(queryVo);
		resultMap.put("resultList", list);
		resultMap.put("resultCount", count);
		resultMap.put("queryVo", queryVo);
		
		resultMap.put("pTypeItems", pTypeItems);
		resultMap.put("pAssignmentTypeItems", pAssignmentTypeItems);
		resultMap.put("pSignTypeItems", pSignTypeItems);
		resultMap.put("pAgentCompanyItems", pAgentCompanyItems);

		return "project/projectList";

	}

	/**
	 * 产品新增
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectAddSubmit.do")
	public String addProjectSubmit(HttpServletRequest request, HttpServletResponse response,ProjectDTO projectDto) {
		logger.info("into addProjectSubmit");
		try {
			request.setCharacterEncoding("utf-8");
//			String loginUser = (String)request.getSession().getAttribute("loginUser");
			String loginUser = "sys";
			String pSaleTimeStartStr = request.getParameter("pSaleTimeStartStr");
			String pSaleTimeEndStr = request.getParameter("pSaleTimeEndStr");
			
			Date pSaleTimeStart = null;
			if(StringUtils.isNotBlank(pSaleTimeStartStr)){
				pSaleTimeStart = DateUtils.formatStrToDate(pSaleTimeStartStr, "yyyy-MM-dd");
			}
			Date pSaleTimeEnd = null;
			if(StringUtils.isNotBlank(pSaleTimeEndStr)){
				pSaleTimeEnd = DateUtils.formatStrToDate(pSaleTimeEndStr, "yyyy-MM-dd");
			}
			projectDto.setpSaleTimeStart(pSaleTimeStart);
			projectDto.setpSaleTimeEnd(pSaleTimeEnd);
			projectDto.setCreateBy(loginUser);
			projectDto.setUpdateBy(loginUser);
			projectService.insertProject(projectDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/projectList.do";

	}

	/**
	 * 产品修改
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectUpdateSubmit.do")
	public String updateProjectSubmit(HttpServletRequest request, HttpServletResponse response,ProjectDTO projectDto) {
		logger.info("into updateProjectSubmit");
		try {
			request.setCharacterEncoding("utf-8");
//			String loginUser = (String)request.getSession().getAttribute("loginUser");
			String loginUser = "sys";
			String pSaleTimeStartStr = request.getParameter("pSaleTimeStartStr");
			String pSaleTimeEndStr = request.getParameter("pSaleTimeEndStr");

			Date pSaleTimeStart = null;
			if(StringUtils.isNotBlank(pSaleTimeStartStr)){
				pSaleTimeStart = DateUtils.formatStrToDate(pSaleTimeStartStr, "yyyy-MM-dd");
			}
			Date pSaleTimeEnd = null;
			if(StringUtils.isNotBlank(pSaleTimeEndStr)){
				pSaleTimeEnd = DateUtils.formatStrToDate(pSaleTimeEndStr, "yyyy-MM-dd");
			}
			projectDto.setpSaleTimeStart(pSaleTimeStart);
			projectDto.setpSaleTimeEnd(pSaleTimeEnd);
			projectDto.setUpdateBy(loginUser);
			projectService.updateProject(projectDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/projectList.do";

	}
	

	/**
	 * 产品新增页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projectAdd.do")
	public String AddProject(HttpServletRequest request, HttpServletResponse response) {
		logger.info("into AddProject");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		request.setAttribute("resultMap", resultMap);
		ParseXmlUtils xmlUtils = new ParseXmlUtils();

		List<SelectItemVo> pAgentCompanyItems = xmlUtils.parseApplicationConfigXML("pAgentCompany");
		List<SelectItemVo> pTypeItems = xmlUtils.parseApplicationConfigXML("pType");
		List<SelectItemVo> pAssignmentTypeItems = xmlUtils.parseApplicationConfigXML("pAssignmentType");
		List<SelectItemVo> pSignTypeItems = xmlUtils.parseApplicationConfigXML("pSignType");
		List<SelectItemVo> pPublicStatusSelect = xmlUtils.parseApplicationConfigXML("pPublicStatusSelect");
		
		resultMap.put("pTypeItems", pTypeItems);
		resultMap.put("pAssignmentTypeItems", pAssignmentTypeItems);
		resultMap.put("pSignTypeItems", pSignTypeItems);
		resultMap.put("pAgentCompanyItems", pAgentCompanyItems);
		resultMap.put("pPublicStatusSelect", pPublicStatusSelect);
		
		return "project/projectAdd";

	}

//	/**
//	 * DTO转化为Vo
//	 * @param list
//	 * @return
//	 */
//	private List<QueryProjectVo> projectDTOChangeVo(List<ProjectDTO> list){
//		List<QueryProjectVo> reslutList = new ArrayList<QueryProjectVo>();
//		QueryProjectVo vo = new QueryProjectVo();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for(ProjectDTO dto:list){
//			BeanUtils.copyProperties(dto, vo);
//			vo.setCreateDateStr(sdf.format(dto.getCreateDate()));
//			vo.setUpdateDateStr(sdf.format(dto.getUpdateDate()));
//			vo.setpSaleTimeStartStr(sdf.format(dto.getpSaleTimeStart()));
//			vo.setpSaleTimeEndStr(sdf.format(dto.getpSaleTimeEnd()));
//			reslutList.add(vo);
//		}
//		return reslutList;
//	}
}
