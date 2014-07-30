<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
 <body>
<form action="clientUserList.do"  id="searchForm" name="searchForm" method="post">
  <table style="width: 100%;" border="1">
			<tr>
				<td>客户姓名</td><td><input type="text" id="cName" name="cName" value='<c:out value="${resultMap.queryVo.cName}"/>' ></td>
				<td>证件号</td><td><input type="text" id="cNumber" name="cNumber" value='<c:out value="${resultMap.queryVo.cNumber}"/>' ></td>
				
			</tr>
			<tr>
				<td>客户等级</td>
				<td>
					<select id="cLevel" name="cLevel" >
						<option value="0" label=""></option>
						<c:forEach items="${resultMap.clientLevelSelect}" var="item">
							<option value="${item.value}" label="${item.label}"  
								<c:if test="${item.value eq resultMap.queryVo.cLevel}">
  									selected="selected"
  								</c:if>>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>手机号码</td><td><input type="text" id="cMobile" name="cMobile" value='<c:out value="${resultMap.queryVo.cMobile}"/>' ></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" name="searchButton" id="searchButton" value="查询" onclick="searchSubmit()">
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
  				用户名称
  			</td>
  			<td>
  				证件类型
  			</td>
  			<td>
  				证件号
  			</td>
  			<td>
  				客户评级
  			</td>
  			<td>
  				电话号码
  			</td>
  			<td>
  				移动电话
  			</td>
  			<td>
  				性别
  			</td>
  			<td>
  				年龄
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
  				<c:out value="${recordList.cName}"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.numberTypeSelect}" var="item">
					<c:if test="${item.value eq recordList.cNumberType}">
						<c:out value="${item.label}"/>
					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<c:out value="${recordList.cNumber}"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.clientLevelSelect}" var="item">
					<c:if test="${item.value eq recordList.cLevel}">
						<c:out value="${item.label}"/>
					</c:if>
  				</c:forEach>
  				
  			</td>
  			<td>
  				<c:out value="${recordList.cTelephone}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.cMobile}"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.sexSelect}" var="item">
					<c:if test="${item.value eq recordList.cSex}">
						<c:out value="${item.label}"/>
					</c:if>
  				</c:forEach>
  				
  			</td>
  			<td>
  				<c:out value="${recordList.cAge}"/>
  			</td>
  			<td>
  				<a href="#" onclick="showInfo(<c:out value="${recordList.id}"/>)">详细</a>
  				<a href="#" onclick="editClientUser(<c:out value="${recordList.id}"/>)">编辑</a>
  				<a href="#" onclick="showProject(<c:out value="${recordList.id}"/>)">产品</a>
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
	var url = "searchClientUserById.do?id="+id
    	 window.open(url,"_self");
     }
	 /**编辑*/
	function editClientUser(id){
		var url = "searchClientUserById.do?edit=1&id="+id
	    	 window.open(url,"_self");
	 }
	 function showProject(id){
		 var url = "searchClientUserById.do?clientProject=1&id="+id
    	 window.open(url,"_self");
     }

	 /** 查询提交 */
	 function searchSubmit(){
		 $("#currentPage").val(0);
		 document.searchForm.submit();
	 }
	
</script>
	
