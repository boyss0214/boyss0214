<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
	  <link href="js/jquery.ui.custom/jquery-ui.css" rel="stylesheet">
	  <script src="js/jquery.ui.custom/external/jquery/jquery.js"></script>
	  <script src="js/jquery.ui.custom/jquery-ui.js"></script>
  </head>
  
  <body>
  	<table width="100%"  border="1">
  		<tr>
  			<td>
  				ID
  			</td>
  			<td>
  				用户名称
  			</td>
  			<td>
  				证件类型
  			</td>
  			<td>
  				证件号
  			</td>
  			<td>
  				角色：资深FA、初级FA等
  			</td>
  			<td>
  				电话号码
  			</td>
  			<td>
  				移动电话
  			</td>
  			<td>
  				业务编码
  			</td>
  			<td>
  				电子邮件
  			</td>
  			<td>
  				性别1：男，2：女，3：隐私
  			</td>
  			<td>
  				年龄
  			</td>
  			<td>
  				地址
  			</td>
  		</tr>
  		<c:forEach items="${resultMap.resultList}" var="recordList">
  			<tr>
  			<td>
  				<c:out value="${recordList.id}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uName}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uNumberType}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uNumber}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uRole}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uTelephone}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uMobile}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uCode}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uEmail}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uSex}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uAge}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.uAddress}"/>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
