package com.paic.mall.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.paic.mall.dto.FaqDTO;
import com.paic.mall.service.IFaqService;


@Controller
public class FaqAction {
	static Logger logger = Logger.getLogger("defultlog");

	@Autowired
	private IFaqService faqService;

	@RequestMapping(value = "/faqList.shtml")
	@ResponseBody
	public String getFaqList(HttpServletRequest request, HttpServletResponse response) {
		
			List<FaqDTO> result = new ArrayList<FaqDTO>();
			return JSON.toJSONString(result);

	}

}
