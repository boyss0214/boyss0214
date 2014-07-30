<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.money.financing.util.ProjectConstants"%>
<%@ page import="com.money.financing.dto.FaUserDTO;"%>
 <style type="text/css">
	  body{
		font: 62.5% "Trebuchet MS", sans-serif;
		margin: 20px;
	  }
	  
	  a{
		font: 14 "Trebuchet MS", sans-serif;
		margin: 10px;
	  }
	  .style1{
	  	padding: 4px;
	  }
	  </style>
  
  <body>
  	<table style="width:100%;height:100%;"  border="1">
  		<tr>
  			<td width="180px" colspan="2" align="center" height="75">
  				<%
  				FaUserDTO userDto = (FaUserDTO)session.getAttribute(ProjectConstants.SESSION_KEY_LOGINUSER);
  				String loginName = "未登录";
  				if(userDto!=null){
  					loginName = userDto.getuLoginName();
  				};
  				%>
  				CRM,当前登录用户：<%=loginName%>
  			</td>
  		</tr>
  		<tr>
  			<td width="180px">
  				<div id="menuTree" style="height: 100%;width: 100%;">
				<h3>产品管理</h3>
				<div>
					<a href="projectList.do" target="context_frame">产品列表</a>
					<div class="style1"></div>
					<a href="projectAdd.do" target="context_frame">新增产品</a>
				</div>
				<h3>客户管理</h3>
				<div>
					<a href="clientUserList.do" target="context_frame">客户列表</a>
					<div class="style1"></div>
					<a href="clientUserAdd.do" target="context_frame">新增客户</a>
				</div>
				<h3>系统管理</h3>
				<div>
					<a href="userList.do" target="context_frame">FA列表</a>
					<div class="style1"></div>
				</div>
</div>
  			</td>
  			<td>
  				<iframe id="context_frame" name="context_frame" style="width: 100%;height: 100%;" scrolling="auto" src="http://www.baidu.com">
  				</iframe>
  			</td>
  		</tr>
  	</table>
  	<script type="text/javascript">
  	$( "#menuTree" ).accordion();
  	</script>
  </body>

