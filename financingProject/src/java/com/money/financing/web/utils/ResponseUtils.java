package com.money.financing.web.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;



public class ResponseUtils {
	private static final Logger logger = Logger.getLogger("ResponseUtils");
	public static void doResponse(HttpServletResponse response,Map<String,Object> jsonMap){
		PrintWriter out = null;
		try {
			response.setContentType("text/html;charset=uft-8");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			out.flush();

		} catch (IOException e) {
			jsonMap.put("status", "2");//系统异常
			logger.error("response writer error ！");
			logger.error("error Message ==>"+e.getLocalizedMessage());
		} finally{
//			out.println(JSONObject.fromObject(jsonMap).toString());
			out.println(JSONObject.fromObject(jsonMap).toString());
			out.close();
		}
	}
}
