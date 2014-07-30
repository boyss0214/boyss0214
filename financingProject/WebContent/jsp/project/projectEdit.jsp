<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<body>
	<form action="projectUpdateSubmit.do" method="post" id="submitForm" name="submitForm">
		<table style="width: 100%;" border="1">
			<tr>
				<td>ID</td>
				<td>
				<c:out value="${resultMap.resultObject.id}"/>
				<input type="hidden" id="id" name="id" value='<c:out value="${resultMap.resultObject.id}"/>'>
				</td>
				<td>产品代码</td><td><input type="text" id="pCode" name="pCode" value='<c:out value="${resultMap.resultObject.pCode}"/>'></td>
			</tr>
			<tr>
				<td>产品名称</td><td><input type="text" id="pName" name="pName" value='<c:out value="${resultMap.resultObject.pName}"/>'></td>
				<td>产品类型</td>
				<td>
					<select id="pType" name="pType" >
						<c:forEach items="${resultMap.pTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.pType}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>产品预期收益</td><td><input type="text" id="pProfit" name="pProfit" value='<c:out value="${resultMap.resultObject.pProfit}"/>'></td>
				<td>产品开放频率</td><td><input type="text" id="pFrequencyOpen" name="pFrequencyOpen" value='<c:out value="${resultMap.resultObject.pFrequencyOpen}"/>'></td>
			</tr>
			<tr>
				<td>期限</td><td><input type="text" id="pDueTime" name="pDueTime" value='<c:out value="${resultMap.resultObject.pDueTime}"/>'>个月</td>
				<td>总份数</td><td><input type="text" id="pCount" name="pCount" value='<c:out value="${resultMap.resultObject.pCount}"/>'></td>
			</tr>
			<tr>
				<td>产品最低投注额</td><td><input type="text" id="pMinimumAmount" name="pMinimumAmount" value='<c:out value="${resultMap.resultObject.pMinimumAmount}"/>' ></td>
				<td>分配方式</td>
				<td>
					<select id="pAssignmentType" name="pAssignmentType" >
						<c:forEach items="${resultMap.pAssignmentTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.pAssignmentType}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>签约方式</td>
				<td>
					<select id="pSignType" name="pSignType" >
						<c:forEach items="${resultMap.pSignTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.pSignType}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>代理公司</td>
				<td>
					<select id="pAgentCompany" name="pAgentCompany" >
						<c:forEach items="${resultMap.pAgentCompanyItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.pAgentCompany}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>管理者</td><td><input type="text" id="pManager" name="pManager" value='<c:out value="${resultMap.resultObject.pManager}"/>' ></td>
				<td>销售周期</td>
				<td>
<%-- 				<input type="text" value='<fmt:formatDate value="${resultMap.resultObject.pSaleTimeStart}" pattern="yyyy-MM-dd"/>' class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeStartStr" name="pSaleTimeStartStr" >~<input type="text" value='<fmt:formatDate value="${resultMap.resultObject.pSaleTimeEnd}" pattern="yyyy-MM-dd"/>' class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeEndStr" name="pSaleTimeEndStr" > --%>
					<input type="text" value='<fmt:formatDate value="${resultMap.resultObject.pSaleTimeStart}" pattern="yyyy-MM-dd"/>' id="pSaleTimeStartStr" name="pSaleTimeStartStr" >~<input type="text" value='<fmt:formatDate value="${resultMap.resultObject.pSaleTimeEnd}" pattern="yyyy-MM-dd"/>' id="pSaleTimeEndStr" name="pSaleTimeEndStr" >
				</td>
			</tr>
			<tr>
				<td>发布状态</td>
				<td colspan="3">
					<select id="pPublicStatus" name="pPublicStatus" >
						<c:forEach items="${resultMap.pPublicStatusSelect}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.resultObject.pPublicStatus}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td colspan="3"><textarea id="pSummary" name="pSummary" rows="5" style="width: 100%;"><c:out value="${resultMap.resultObject.pSummary}"/></textarea></td>
			</tr>
			<tr>
				<td>详情</td>
				<td colspan="3"><textarea id="pComment" name="pComment" rows="5" style="width: 100%;"><c:out value="${resultMap.resultObject.pComment}"/></textarea></td>
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
	

	$(document).ready(function(){
		$("#pSaleTimeStartStr").datepicker();
		$("#pSaleTimeEndStr").datepicker();
	});

</script>


