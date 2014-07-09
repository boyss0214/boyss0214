package com.paic.mall.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.paic.mall.dto.FaqDTO;

@Controller
public class TestAction {
	
	@RequestMapping(value = "/faqList.shtml")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response) {
		
			List<FaqDTO> result = new ArrayList<FaqDTO>();
			return JSON.toJSONString(result);

	}

}
