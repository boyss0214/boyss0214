<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<body>
	<form action="projectAddSubmit.do" method="post" id="submitForm" name="submitForm">
		<table style="width: 100%;" border="1">
			<tr>
				<td>ID</td><td><input type="text" id="id" name="id" disabled="disabled"></td>
				<td>产品代码</td><td><input type="text" id="pCode" name="pCode" ></td>
			</tr>
			<tr>
				<td>产品名称</td><td><input type="text" id="pName" name="pName" ></td>
				<td>产品类型</td>
				<td>
					<select id="pType" name="pType" >
						<c:forEach items="${resultMap.pTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>产品预期收益</td><td><input type="text" id="pProfit" name="pProfit" value="1.00"></td>
				<td>产品开放频率</td><td><input type="text" id="pFrequencyOpen" name="pFrequencyOpen" ></td>
			</tr>
			<tr>
				<td>期限</td><td><input type="text" id="pDueTime" name="pDueTime" value="1">个月</td>
				<td>总份数</td><td><input type="text" id="pCount" name="pCount" value="0"></td>
			</tr>
			<tr>
				<td>产品最低投注额</td><td><input type="text" id="pMinimumAmount" name="pMinimumAmount" value="0" ></td>
				<td>分配方式</td>
				<td>
					<select id="pAssignmentType" name="pAssignmentType" >
						<c:forEach items="${resultMap.pAssignmentTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>签约方式</td>
				<td>
					<select id="pSignType" name="pSignType" >
						<c:forEach items="${resultMap.pSignTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
				<td>代理公司</td>
				<td>
					<select id="pAgentCompany" name="pAgentCompany" >
						<c:forEach items="${resultMap.pAgentCompanyItems}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>管理者</td><td><input type="text" id="pManager" name="pManager" ></td>
				<td>销售周期</td>
				<td>
<!-- 				<input type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeStartStr" name="pSaleTimeStartStr" >~<input type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeEndStr" name="pSaleTimeEndStr" > -->
					<input type="text"  id="pSaleTimeStartStr" name="pSaleTimeStartStr" >~<input type="text"  id="pSaleTimeEndStr" name="pSaleTimeEndStr" >
				</td>
			</tr>
			<tr>

				<td>发布状态</td>
				<td colspan="3">
					<select id="pPublicStatus" name="pPublicStatus" >
						<c:forEach items="${resultMap.pPublicStatusSelect}" var="item">
							<option value="${item.value}" label="${item.label}"></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td colspan="3"><textarea id="pSummary" name="pSummary" rows="5" style="width: 100%;"></textarea></td>
			</tr>
			<tr>
				<td>详情</td>
				<td colspan="3"><textarea id="pComment" name="pComment" rows="5" style="width: 100%;"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" name="saveButton" id="saveButton" value="提交">
					
				</td>
			</tr>
		</table>
			
	</form>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$("#pSaleTimeStartStr").datepicker();
	$("#pSaleTimeEndStr").datepicker();
});
</script>


