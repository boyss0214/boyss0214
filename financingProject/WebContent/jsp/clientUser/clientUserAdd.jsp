<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<body>
	<form action="clientUserAddSubmit.do" method="post" id="submitForm" name="submitForm">
		<table style="width: 100%;" border="1">
			<tr>
				<td>客户姓名</td><td><input type="text" id="cName" name="cName" ></td>
				<td>顾问代码</td><td><input type="text" id="cPaCode" name="cPaCode" value="<c:out value="${resultMap.cPaCodeDefault}"/>"></td>
			</tr>
			<tr>
				<td>年龄</td><td><input type="text" id="cAge" name="cAge" ></td>
				<td>性别</td>
				<td>
					<select id="cSex" name="cSex" >
						<c:forEach items="${resultMap.sexSelect}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>证件类型</td>
				<td>
					<select id="cNumberType" name="cNumberType" >
						<c:forEach items="${resultMap.numberTypeSelect}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
				<td>证件号码</td><td><input type="text" id="cNumber" name="cNumber" ></td>
			</tr>
			<tr>
				<td>总资产</td><td><input type="text" id="cAsset" name="cAsset" value="0"></td>
				<td>客户等级</td>
				<td>
					<select id="cLevel" name="cLevel" >
						<c:forEach items="${resultMap.clientLevelSelect}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>电话号码</td><td><input type="text" id="cTelephone" name="cTelephone" ></td>
				<td>手机号码</td><td><input type="text" id="cMobile" name="cMobile" ></td>
			</tr>
			<tr>
				<td>电子邮件</td><td><input type="text" id="cEmail" name="cEmail" ></td>
				<td>地址</td><td><input type="text" id="cAddress" name="cAddress" ></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><textarea id="cRemark" name="cRemark" rows="5" style="width: 100%;"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" name="saveButton" id="saveButton" value="提交">
					
				</td>
			</tr>
		</table>
		
	</form>
</body>




