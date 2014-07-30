package com.money.financing.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.money.financing.dto.FaUserDTO;
import com.money.financing.util.ProjectConstants;


public class LoginFilter extends HttpServlet implements Filter {

	Logger logger = Logger.getLogger("defultlog");
	private static final long serialVersionUID = 82253936463810530L;
	/**
	 * 未登录用户过滤
	 */


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest  httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		FaUserDTO faUserDto = (FaUserDTO)httpRequest.getSession().getAttribute(ProjectConstants.SESSION_KEY_LOGINUSER);
		String requestUrl = httpRequest.getServletPath();

		boolean isExceptionUrl = exceptionFilter(requestUrl);
		if(!isExceptionUrl&&faUserDto==null){
			logger.info("===>登录失败");
			String gotoUrl = "http://"+httpRequest.getHeader("Host")+httpRequest.getContextPath()+"/login.jsp";
			httpResponse.sendRedirect(gotoUrl);
		}


		filterChain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init();
	}

	/**
	 * 过滤例外url
	 * @param url
	 * @return
	 */
	private boolean exceptionFilter(String url){
		if("/loginActionAjax.do".equals(url)){
			return true;
		}
		if("/login.jsp".equals(url)){
			return true;
		}if("/searchProjectByIdForJson.do".equals(url)){
			return true;
		}if("/projectListForJson.do".equals(url)){
			return true;
		}if("/searchFaUserByIdForJson.do".equals(url)){
			return true;
		}if("/updateFaUserByIdForJson.do".equals(url)){
			return true;
		}if("/searchProjectLikeListByCodeForJson.do".equals(url)){
			return true;
		}if("/insertProjectLikeForJson.do".equals(url)){
			return true;
		}if("/deleteProjectLikeByIdForJson.do".equals(url)){
			return true;
		}
		
		return false;
	}

}
