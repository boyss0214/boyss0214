<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<body>
	<form action="clientUserUpdateSubmit.do" method="post" id="submitForm" name="submitForm">
		<input type="hidden" id="id" name="id" value='<c:out value="${resultMap.resultObject.id}"/>'>
		<table style="width: 100%;" border="1">
			<tr>
				<td>顾问代码</td><td colspan="3"><c:out value="${resultMap.resultObject.cPaCode}"/></td>
			</tr>
			<tr>
				<td>客户姓名</td><td colspan="3"><input type="text" id="cName" name="cName" value='<c:out value="${resultMap.resultObject.cName}"/>'></td>
			</tr>
			<tr>
				<td>年龄</td><td><input type="text" id="cAge" name="cAge" value='<c:out value="${resultMap.resultObject.cAge}"/>'></td>
				<td>性别</td>
				<td>
					<select id="cSex" name="cSex" >
						<c:forEach items="${resultMap.sexSelect}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.cSex}">
  									selected="selected"
  								</c:if>>
  							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>证件类型</td>
				<td>
					<select id="cNumberType" name="cNumberType" >
						<c:forEach items="${resultMap.numberTypeSelect}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.cNumberType}">
  									selected="selected"
  								</c:if>>
  							</option>
						</c:forEach>
					</select>
				</td>
				<td>证件号码</td><td><input type="text" id="cNumber" name="cNumber" value='<c:out value="${resultMap.resultObject.cNumber}"/>'></td>
			</tr>
			<tr>
				<td>总资产</td><td><input type="text" id="cAsset" name="cAsset" value='<c:out value="${resultMap.resultObject.cAsset}"/>'></td>
				<td>客户等级</td>
				<td>
					<select id="cLevel" name="cLevel" >
						<c:forEach items="${resultMap.clientLevelSelect}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.cLevel}">
  									selected="selected"
  								</c:if>>
  							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>电话号码</td><td><input type="text" id="cTelephone" name="cTelephone" value='<c:out value="${resultMap.resultObject.cTelephone}"/>'></td>
				<td>手机号码</td><td><input type="text" id="cMobile" name="cMobile" value='<c:out value="${resultMap.resultObject.cMobile}"/>'></td>
			</tr>
			<tr>
				<td>电子邮件</td><td><input type="text" id="cEmail" name="cEmail" value='<c:out value="${resultMap.resultObject.cEmail}"/>'></td>
				<td>地址</td><td><input type="text" id="cAddress" name="cAddress" value='<c:out value="${resultMap.resultObject.cAddress}"/>'></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><textarea id="cRemark" name="cRemark" rows="5" style="width: 100%;"><c:out value="${resultMap.resultObject.cRemark}"/></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" name="saveButton" id="saveButton" value="提交">
					<input type="button" name="backButton" id="backButton" value="返回" onclick="backPage()">
				</td>
			</tr>
		</table>
		
	</form>
</body>

<script type="text/javascript">
/*
 * 返回上一页
 */
	function backPage(){
		history.go(-1);
	}
</script>


