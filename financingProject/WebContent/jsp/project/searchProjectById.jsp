<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<body>
		<table style="width: 100%;" border="1">
			<tr>
				<td>ID</td>
				<td>
					<c:out value="${resultMap.resultObject.id}"/>
				</td>
				<td>产品代码</td><td><c:out value="${resultMap.resultObject.pCode}"/></td>
			</tr>
			<tr>
				<td>产品名称</td><td><c:out value="${resultMap.resultObject.pName}"/></td>
				<td>产品类型</td>
				<td>
					
						<c:forEach items="${resultMap.pTypeItems}" var="item">
								<c:if test="${item.value eq resultMap.resultObject.pType}">
  									<c:out value="${item.label}"/>
  								</c:if>
						</c:forEach>
				
				</td>
			</tr>
			<tr>
				<td>产品预期收益</td><td><c:out value="${resultMap.resultObject.pProfit}"/></td>
				<td>产品开放频率</td><td><c:out value="${resultMap.resultObject.pFrequencyOpen}"/></td>
			</tr>
			<tr>
				<td>期限</td><td><c:out value="${resultMap.resultObject.pDueTime}"/>个月</td>
				<td>总份数</td><td><c:out value="${resultMap.resultObject.pCount}"/></td>
			</tr>
			<tr>
				<td>产品最低投注额</td><td><c:out value="${resultMap.resultObject.pMinimumAmount}"/></td>
				<td>分配方式</td>
				<td>
					
						<c:forEach items="${resultMap.pAssignmentTypeItems}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.pAssignmentType}">
  									<c:out value="${item.label}"/>
  							</c:if>
						</c:forEach>
					
				</td>
			</tr>
			<tr>
				<td>签约方式</td>
				<td>
				
						<c:forEach items="${resultMap.pSignTypeItems}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.pSignType}">
  									<c:out value="${item.label}"/>
  							</c:if>
						</c:forEach>
					
				</td>
				<td>代理公司</td>
				<td>
					
						<c:forEach items="${resultMap.pAgentCompanyItems}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.pAgentCompany}">
  									<c:out value="${item.label}"/>
  							</c:if>
						</c:forEach>
					
				</td>
			</tr>
			<tr>
				<td>管理者</td><td><c:out value="${resultMap.resultObject.pManager}"/></td>
				<td>销售周期</td>
				<td><fmt:formatDate value="${resultMap.resultObject.pSaleTimeStart}" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${resultMap.resultObject.pSaleTimeEnd}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>发布状态</td>
				<td colspan="3">
					<c:forEach items="${resultMap.pPublicStatusSelect}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.pPublicStatus}">
  									<c:out value="${item.label}"/>
  							</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td colspan="3"><textarea id="pSummary" name="pSummary" rows="5" style="width: 100%;" disabled="disabled"><c:out value="${resultMap.resultObject.pSummary}"/></textarea></td>
			</tr>
			<tr>
				<td>详情</td>
				<td colspan="3"><textarea id="pComment" name="pComment" rows="5" style="width: 100%;" disabled="disabled"><c:out value="${resultMap.resultObject.pComment}"/></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" name="backButton" id="backButton" value="返回" onclick="backPage()">
					
				</td>
			</tr>
		</table>
</body>
<script type="text/javascript">
/*
 * 返回上一页
 */
	function backPage(){
		history.back();
	}
</script>



