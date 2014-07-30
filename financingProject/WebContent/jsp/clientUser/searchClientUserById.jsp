<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>


<body>
		<table style="width: 100%;" border="1">
			<tr>
				<td>顾问代码</td><td colspan="3"><c:out value="${resultMap.resultObject.cPaCode}"/></td>
			</tr>
			<tr>
				<td>客户姓名</td><td colspan="3"><c:out value="${resultMap.resultObject.cName}"/></td>
			</tr>
			<tr>
				<td>年龄</td><td><c:out value="${resultMap.resultObject.cAge}"/></td>
				<td>性别</td>
				<td>
						<c:forEach items="${resultMap.sexSelect}" var="item">
								<c:if test="${item.value eq resultMap.resultObject.cSex}">
  									<c:out value="${item.label}"/>
  								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>证件类型</td>
				<td>
						<c:forEach items="${resultMap.numberTypeSelect}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.cNumberType}">
  									<c:out value="${item.label}"/>
  							</c:if>
						</c:forEach>
				</td>
				<td>证件号码</td><td><c:out value="${resultMap.resultObject.cNumber}"/></td>
			</tr>
			<tr>
				<td>总资产</td><td><c:out value="${resultMap.resultObject.cAsset}"/></td>
				<td>客户等级</td>
				<td>
						<c:forEach items="${resultMap.clientLevelSelect}" var="item">
							<c:if test="${item.value eq resultMap.resultObject.cLevel}">
  									<c:out value="${item.label}"/>
  							</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>电话号码</td><td><c:out value="${resultMap.resultObject.cTelephone}"/></td>
				<td>手机号码</td><td><c:out value="${resultMap.resultObject.cMobile}"/></td>
			</tr>
			<tr>
				<td>电子邮件</td><td><c:out value="${resultMap.resultObject.cEmail}"/></td>
				<td>地址</td><td><c:out value="${resultMap.resultObject.cAddress}"/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><textarea id="cRemark" name="cRemark" rows="5" style="width: 100%;" disabled="disabled"><c:out value="${resultMap.resultObject.cRemark}"/></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" name="backButton" id="backButton" value="返回" onclick="backPage()">
					<input type="button" name="assetButton" id="assetButton" value="资产详情" onclick="alert('doing...')">
					<input type="button" name="addVisitButton" id="addVisitButton" value="添加拜访记录">
				</td>
			</tr>
		</table>
		<table style="width: 100%;"  border="1" id="clientVisitTable">
  		<tr>
  			<td>
  				ID
  			</td>
  			<td>
  				拜访时间
  			</td>
  			<td>
  				拜访方式
  			</td>
  			<td>
  				FA业务编码
  				
  			</td>
<!--   			<td> -->
<!--   				客户id -->
<!--   			</td> -->
  			<td>
  				产品编号
  			</td>
  			<td>
  				访问备注
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
  				<fmt:formatDate value="${recordList.cvDate}" pattern="yyyy-MM-dd"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.cvTypeSelect}" var="item">
					<c:if test="${item.value eq recordList.cvType}">
						<c:out value="${item.label}"/>
						<input name="cvTypeValueHid" value="<c:out value="${item.value}"/>" type="hidden">
					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<c:out value="${recordList.uCode}"/>
  			</td>
  			
<!--   			<td> -->
<%--   				<c:out value="${recordList.cvCUserId}"/> --%>
<!--   			</td> -->
  			<td>
  				<c:out value="${recordList.cvPCode}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.cvRemark}"/>
  			</td>
  			<td>
  				<a  href="#" onclick="editClientVisitInfo(<c:out value="${recordList.id}"/>,this)">编辑</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	<div id="Pagination" class="pagination"></div>
  	<form action="searchClientUserById.do"  id="searchForm" name="searchForm" method="post">
		<input type="hidden" name="id" id="id" value="<c:out value="${resultMap.resultObject.id}"/>">
		<input type="hidden" name="currentPage" id="currentPage" value="0">
		<input type="hidden" name="pageSize" id="pageSize" value="<c:out value="${resultMap.queryVo.pageSize}"/>">
  	</form>
  	
  	<!-- 新增访问记录页面 -->
	<div id="addClientVisitDiv" title="新增客户访问记录">
	  <form action="clientVisitFormSubmit.do"  id="clientVisitFormSubmit" name="clientVisitFormSubmit" method="post">
		<table style="width: 100%;"  border="1">
	  		<tr>
	  			<td>FA业务编码</td>
	  			<td ><input type="text" id="uCode" name="uCode" value='<c:out value="${resultMap.resultObject.cPaCode}"/>'></td>
	  		</tr>
	  		<tr>	
	  			<td>拜访时间</td>
	  			<td><input type="text"  id="cvDateStr" name="cvDateStr" ></td>
	  		</tr>
	  		
	  		<tr>
	  			<td>拜访方式</td>
	  			<td>
	  				<select id="cvType" name="cvType" >
						<c:forEach items="${resultMap.cvTypeSelect}" var="item">
							<option value="${item.value}" label="${item.label}">${item.label}</option>
		  				</c:forEach>
					</select>
	  			</td>
			</tr>
	  		<tr>
	  			<td>产品编号</td>
	  			<td><input type="text" id="cvPCode" name="cvPCode" value=""></td>
	  		</tr>
	  		<tr>
	  			<td>访问备注</td>
	  			<td><textarea name="cvRemark" id="cvRemark" rows="5" style="width: 100%;" ></textarea></td>
	  		</tr>
	  	</table>
	  	<!-- 客户ID -->
  		<input name="cvCUserId" id="cvCUserId"  type="hidden" value="<c:out value='${resultMap.resultObject.id}'/>"  >
  		<input name="visitId" id="visitId"  type="hidden">
	  </form>
	</div>
</body>
<script type="text/javascript">
/*
 * 返回上一页
 */
function backPage(){
	history.back();
}

//分页js
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
//分页js END 


</script>

<script type="text/javascript">
//弹出DIV
$( "#addClientVisitDiv" ).dialog({
	autoOpen: false,
	width: 800,
	buttons: [
		{
			text: "Ok",
			click: function() {
				clientVisitFormSubmit(this);
			}
		},
		{
			text: "Cancel",
			click: function() {
				$( this ).dialog( "close" );
				initClientVisitData();
			}
		}
	]
});

// Link to open the dialog
	$( "#addVisitButton" ).click(function( event ) {
	$( "#addClientVisitDiv" ).dialog( "open" );
	event.preventDefault();
});

	//客户产品新增&更新提交
	function clientVisitFormSubmit(Object){
			var submitJson = getClientVisitData();
			
			$.ajax({
				   type: "POST",
				   url: "clientVisitFormSubmitAjax.do",
				   data: submitJson,
				   dataType:"json",
				   success: function(msg){
					   var submitType = msg.submitType;
						  if("1"==submitType){//新增
							  insertRecordToListByJs(msg.id);
						  }
						  if("2"==submitType){//修改
							  //insertRecordToListByJs(msg.id);
							 editClientVisitInfoSucc(trObjectEdit)
						  }
					  alert("保存完成！");		
					  $( Object ).dialog( "close" );
					 
					  initClientVisitData();
				   }
				});
	}

//提交数据
function getClientVisitData(){
	var visitId =  $("input[name=visitId]").val();
	var cvCUserId = $("input[name=cvCUserId]").val();
	var cvDateStr = $("#cvDateStr").val();
	var uCode =  $("#uCode").val();
	var cvPCode = $("#cvPCode").val();
	var cvRemark =  $("#cvRemark").val();
	var cvType =  $("#cvType").val();
	var cvTypeLabel = $("#cvType").find("option:selected").text();
	
	var submitJson = {
			"visitId":visitId,
			"cvCUserId":cvCUserId,
			"cvDateStr":cvDateStr,
			"uCode":uCode,
			"cvPCode":cvPCode,
			"cvRemark":cvRemark,
			"cvType":cvType,
			"cvTypeLabel":cvTypeLabel
	};
	return submitJson;
}


//新增完成后将新增内容插入
function insertRecordToListByJs(id){
	var submitJson = getClientVisitData();
	var insertValue = 
		"<tr>"+
	 	"<td>"+id+"</td>"+
		"<td>"+submitJson.cvDateStr+"</td>"+
		"<td>"+submitJson.cvTypeLabel+"</td>"+
		"<td>"+submitJson.uCode+"</td>"+
		"<td>"+submitJson.cvPCode+"</td>"+
		"<td>"+submitJson.cvRemark+"</td>"+
		"<td><a href='#' onclick='editClientVisitInfo("+id+",this)'>编辑</a></td>"+
		"</tr>";
			
		
	$("#clientVisitTable").append(insertValue);
};
//初始数据
function initClientVisitData(){

// 	var cvCUserId = $("input[name=cvCUserId]").val();
	$("#cvDateStr").val("");
// 	var uCode =  $("#uCode").val();
	$("#cvPCode").val("");
	$("#cvRemark").val("");
	$("#cvType").val("1");
// 	var cvTypeLabel = $("#cvType").find("option:selected").text();
	$("input[name=visitId]").val("");
};
var trObjectEdit = null;

//编辑
function editClientVisitInfo(id,Object){
	var trObject = $(Object).parent().parent();
	var cvDateStr = $(trObject).children('td').eq(1).text().trim();
	var cvTypeValue = $(trObject).children('td').eq(2).children("input[name=cvTypeValueHid]").val();
	var uCode = $(trObject).children('td').eq(3).text().trim();
	var cvPCode = $(trObject).children('td').eq(4).text().trim();
	var cvRemark = $(trObject).children('td').eq(5).text().trim();

	

	$("input[name=visitId]").val(id);
	$("#cvDateStr").val(cvDateStr);
  	$("#uCode").val(uCode);
	$("#cvPCode").val(cvPCode);
	$("#cvRemark").val(cvRemark);
	$("#cvType").val(cvTypeValue);
	
	//当前编辑的条目
	trObjectEdit = trObject;
	
	$( "#addVisitButton" ).click();
		
}
//编辑完成后回填至前台表格
function editClientVisitInfoSucc(trObjectEdit){
	var visitId = $("input[name=visitId]").val();
	var cvDateStr = $("#cvDateStr").val();
	var uCode = $("#uCode").val();
	var cvPCode = $("#cvPCode").val();
	var cvRemark = $("#cvRemark").val();
	var cvTypeValue = $("#cvType").val();
	
	$(trObjectEdit).children('td').eq(1).text(visitId);
	$(trObjectEdit).children('td').eq(1).text(cvDateStr);
	$(trObjectEdit).children('td').eq(2).children("input[name=cvTypeValueHid]").val(cvTypeValue);
	$(trObjectEdit).children('td').eq(3).text(uCode);
	$(trObjectEdit).children('td').eq(4).text(cvPCode);
	$(trObjectEdit).children('td').eq(5).text(cvRemark);
}
</script>

<script type="text/javascript">
	

	$(document).ready(function(){
		$("#cvDateStr").datepicker();
	});
	

	
</script>
