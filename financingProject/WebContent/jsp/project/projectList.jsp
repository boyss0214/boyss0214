<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
  <body>
  <form action="projectList.do"  id="searchForm" name="searchForm" method="post">
  <table style="width: 100%;" border="1">
			<tr>
				<td>产品代码</td><td><input type="text" id="pCode" name="pCode" value='<c:out value="${resultMap.queryVo.pCode}"/>' ></td>
				<td>产品名称</td><td><input type="text" id="pName" name="pName" value='<c:out value="${resultMap.queryVo.pName}"/>' ></td>
			</tr>
			<tr>
				<td>产品类型</td>
				<td>
					<select id="pType" name="pType" >
						<option value="" label=""></option>
						<c:forEach items="${resultMap.pTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"  
								<c:if test="${item.value eq resultMap.queryVo.pType}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>分配方式</td>
				<td>
					<select id="pAssignmentType" name="pAssignmentType" >
						<option value="" label="" ></option>
						<c:forEach items="${resultMap.pAssignmentTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.queryVo.pAssignmentType}">
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
						<option value="" label=""></option>
						<c:forEach items="${resultMap.pSignTypeItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.queryVo.pSignType}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>代理公司</td>
				<td>
					<select id="pAgentCompany" name="pAgentCompany" >
					<option value="" label=""></option>
						<c:forEach items="${resultMap.pAgentCompanyItems}" var="item">
							<option value="${item.value}" label="${item.label}"
								<c:if test="${item.value eq resultMap.queryVo.pAgentCompany}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>销售周期</td> -->
<!-- 				<td colspan="3"> -->
<%-- 				<input type="text" value='<c:out value="${resultMap.queryVo.pSaleTimeStartStr}"/>' class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeStartStr" name="pSaleTimeStartStr" >~<input type="text" value='<c:out value="${resultMap.queryVo.pSaleTimeEndStr}"/>' class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  id="pSaleTimeEndStr" name="pSaleTimeEndStr" > --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan="4" align="center">
					<input type="button" name="saveButton" id="saveButton" value="查询" onclick="searchSubmit()">
					<input type="hidden" name="currentPage" id="currentPage" value="0">
					<input type="hidden" name="pageSize" id="pageSize" value="<c:out value="${resultMap.queryVo.pageSize}"/>">
					
				</td>
			</tr>
  </table>
  </form>
  	<table style="width: 100%;"  border="1">
  		<tr>
  			<td>
  				ID
  			</td>
  			<td>
  				产品代码
  			</td>
  			<td>
  				产品名称
  			</td>
  			<td>
  				产品类型
  			</td>
  			<td>
  				预期收益
  			</td>
  			<td>
  				总份数
  			</td>

  			<td>
  				分配方式
  			</td>
  			<td>
  				签约方式
  			</td>
  			<td>
  				代理公司
  			</td>

  			<td>
  				销售周期
  			</td>
  			<td>
  				操作
  			</td>
  		</tr>

  		<c:forEach items="${resultMap.resultList}" var="recordList">
  			<tr>
  			<td>
  				<c:out value="${recordList.id}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.pCode}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.pName}"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.pTypeItems}" var="item">
  					<c:if test="${recordList.pType eq item.value}">
  						<c:out value="${item.label}"/>
  					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<c:out value="${recordList.pProfit}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.pCount}"/>
  			</td>

  			<td>
  				<c:forEach items="${resultMap.pAssignmentTypeItems}" var="item">
  					<c:if test="${recordList.pAssignmentType eq item.value}">
  						<c:out value="${item.label}"/>
  					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.pSignTypeItems}" var="item">
  					<c:if test="${recordList.pSignType eq item.value}">
  						<c:out value="${item.label}"/>
  					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.pAgentCompanyItems}" var="item">
  					<c:if test="${recordList.pAgentCompany eq item.value}">
  						<c:out value="${item.label}"/>
  					</c:if>
  				</c:forEach>
  			</td>

  			<td>
<%--   				<c:out value="${recordList.pSaleTimeStart}"/> --%>
<%--   				<c:out value="${recordList.pSaleTimeEnd}"/> --%>
  				<fmt:formatDate value="${recordList.pSaleTimeStart}" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${recordList.pSaleTimeEnd}" pattern="yyyy-MM-dd"/>
  			</td>
  			<td>
  				<a href="#" onclick="showInfo(<c:out value="${recordList.id}"/>)">详细</a>
  				<a href="#" onclick="editProject(<c:out value="${recordList.id}"/>)">编辑</a>
  			</td>
  		</tr>
  		</c:forEach>
  		
  	</table>
  	<div id="Pagination" class="pagination"></div>
  </body>

<script type="text/javascript">
// 分页js
	var loadType = 0;
     function pageselectCallback(page_index, jq){
    	 loadType++;
    	 //alert(loadType);
        $("#currentPage").val(page_index);
        if(loadType>1){
        	document.searchForm.submit();
        }   
         return false;
     }
     function getOptionsFromForm(){
         var opt = {callback: pageselectCallback};
         opt.items_per_page = <c:out value="${resultMap.queryVo.pageSize}"/>;//pageSize
	     opt.prev_text = "上一页";
	     opt.next_text = "下一页";
	     opt.current_page = <c:out value="${resultMap.queryVo.currentPage}"/>;
         return opt;
     }

     $(document).ready(function(){
         var count = <c:out value="${resultMap.resultCount}"/>;
          
          var optInit = getOptionsFromForm();
         $("#Pagination").pagination(count, optInit);
     });
// 分页js END 
    

    /**展示详情*/
    
	function showInfo(id){
	var url = "searchProjectById.do?id="+id
    	 window.open(url,"_self");
     }
	 /**编辑*/
	function editProject(id){
		var url = "searchProjectById.do?edit=1&id="+id
	    	 window.open(url,"_self");
	     }
	/** 查询提交 */
	 function searchSubmit(){
		 $("#currentPage").val(0);
		 document.searchForm.submit();
	 }
	
</script>
	
