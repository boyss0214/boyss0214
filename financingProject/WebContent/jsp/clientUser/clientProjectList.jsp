<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<script src="js/jquery.ui.custom/jquery-ui.js"></script>
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
					<input type="button" name="addProjectButton" id="addProjectButton" value="新增客户产品" >
<!-- 					<input type="button" name="ttButton" id="ttButton" value="测试" onclick="insertRecordToListByJs('dd')"> -->
				</td>
			</tr>
		</table>
		<table style="width: 100%;"  border="1" id="clientProjectTable">
  		<tr>
  			<td>
  				ID
  			</td>
  			<td>
  				产品编号
  			</td>
  			<td>
  				FA业务编码
  			</td>
  			<td>
  				购买份额
  			</td>
<!--   			<td> -->
<!--   				客户id -->
<!--   			</td> -->
  			<td>
  				购买产品总价
  			</td>
  			<td>
  				总收益
  			</td>
  			<td>
  				客户产品状态
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
  				<a href="#" onclick='showProjectInfoByCode("<c:out value="${recordList.cpProjectCode}"/>")'>
  				<c:out value="${recordList.cpProjectCode}"/>
  				</a>
  			</td>
  			<td>
  				<c:out value="${recordList.uCode}"/>
  			</td>
  			
<!--   			<td> -->
<%--   				<c:out value="${recordList.cvCUserId}"/> --%>
<!--   			</td> -->
  			<td>
  				<c:out value="${recordList.cpShare}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.cpValue}"/>
  			</td>
  			<td>
  				<c:out value="${recordList.cpGain}"/>
  			</td>
  			<td>
  				<c:forEach items="${resultMap.cpProjectStatusSelect}" var="item">
					<c:if test="${item.value eq recordList.cpProjectStatus}">
						<c:out value="${item.label}"/>
					</c:if>
  				</c:forEach>
  			</td>
  			<td>
  				<a href="#" >编辑</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	<div id="Pagination" class="pagination"></div>
  	<form action="searchClientUserById.do?clientProject=1"  id="searchForm" name="searchForm" method="post">
		<input type="hidden" name="id" id="id" value="<c:out value="${resultMap.resultObject.id}"/>">
		<input type="hidden" name="currentPage" id="currentPage" value="0">
		<input type="hidden" name="pageSize" id="pageSize" value="<c:out value="${resultMap.queryVo.pageSize}"/>">
  	</form>
  	<!-- 新增产品页面 -->
<div id="addClientProjectDiv" title="新增客户产品">
	<form action="clientProjectFormSubmit.do"  id="clientProjectFormSubmit" name="clientProjectFormSubmit" method="post">
		<table style="width: 100%;"  border="1">
	  		<tr>	
	  			<td>产品编号</td>
	  			<td><input type="text" id="cpProjectCode" name="cpProjectCode" value=""></td>
	  		</tr>
	  		<tr>
	  			<td>FA业务编码</td>
	  			<td><input type="text" id="uCode" name="uCode" value='<c:out value="${resultMap.resultObject.cPaCode}"/>'></td>
	  		</tr>
	  		<tr>
	  			<td>购买份额</td>
	  			<td><input type="text" id="cpShare" name="cpShare" value="0"></td>
			</tr>
	  		<tr>
	  			<td>购买产品总价</td>
	  			<td><input type="text" id="cpValue" name="cpValue" value="0"></td>
	  		</tr>
	  		<tr>
	  			<td>总收益</td>
	  			<td><input type="text" id="cpGain" name="cpGain" value="0"></td>
	  		</tr>
	  		<tr>
	  			<td>客户产品状态</td>
	  			<td>
	  			<select id="cpProjectStatus" name="cpProjectStatus" >
					<c:forEach items="${resultMap.cpProjectStatusSelect}" var="item">
						<option value="${item.value}" label="${item.label}">${item.label}</option>
	  				</c:forEach>
				</select>
				</td>
	  		</tr>
	  	</table>
	  	<!-- 客户ID -->
  		<input name="cpCUserId" id="cpCUserId"  type="hidden" value="<c:out value='${resultMap.resultObject.id}'/>"  >
	  	<input name="cId" id="cId"  type="hidden" value="<c:out value='${resultMap.resultObject.id}'/>" >
	  </form>
</div>

</body>
<script type="text/javascript">


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

/*
* 返回上一页
*/
	function backPage(){
		history.back();
	}
	//显示产品详情
	function showProjectInfoByCode(pCode){
		var url = "searchProjectById.do?pCode="+pCode;
		window.open(url,"_self");
	}
</script>

<script type="text/javascript">
//弹出DIV
$( "#addClientProjectDiv" ).dialog({
	autoOpen: false,
	width: 800,
	buttons: [
		{
			text: "Ok",
			click: function() {
				clientProjectFormSubmit(this);
				//$( this ).dialog( "close" );
			}
		},
		{
			text: "Cancel",
			click: function() {
				$( this ).dialog( "close" );
				initClientProjectData();
			}
		}
	]
});

//Link to open the dialog
$( "#addProjectButton" ).click(function( event ) {
	$( "#addClientProjectDiv" ).dialog( "open" );
	event.preventDefault();
});

function getClientProjectData(){
	var cpCUserId = $("input[name=cpCUserId]").val();
	var cpProjectCode = $("#cpProjectCode").val();
	var uCode =  $("#uCode").val();
	var cpShare =  $("#cpShare").val();
	var cpValue =  $("#cpValue").val();
	var cpGain =  $("#cpGain").val();
	var cpProjectStatus =  $("#cpProjectStatus").val();
	var cpProjectStatusLabel = $("#cpProjectStatus").find("option:selected").text();
	
	var submitJson = {
			"cpCUserId":cpCUserId,
			"cpProjectCode":cpProjectCode,
			"uCode":uCode,
			"cpShare":cpShare,
			"cpValue":cpValue,
			"cpGain":cpGain,
			"cpProjectStatus":cpProjectStatus,
			"cpProjectStatusLabel":cpProjectStatusLabel,
	};
	return submitJson;
}

//客户产品新增&更新提交
function clientProjectFormSubmit(Object){
		var submitJson = getClientProjectData();
		
		$.ajax({
			   type: "POST",
			   url: "clientProjectFormSubmitAjax.do",
			   data: submitJson,
			   dataType:"json",
			   success: function(msg){
			     insertRecordToListByJs(msg.id);
				  alert("保存完成！");		
				  $( Object ).dialog( "close" );
				  initClientProjectData();
			   }
			});
}
//新增完成后将新增内容插入
function insertRecordToListByJs(id){
	var submitJson = getClientProjectData();
	var insertValue = 
		"<tr>"+
	 	"<td>"+id+"</td>"+
		"<td><a href='#' onclick='showProjectInfoByCode("+submitJson.cpProjectCode+")'>"+submitJson.cpProjectCode+"</a></td>"+
		"<td>"+submitJson.uCode+"</td>"+
		"<td>"+submitJson.cpShare+"</td>"+
		"<td>"+submitJson.cpValue+"</td>"+
		"<td>"+submitJson.cpGain+"</td>"+
		"<td>"+submitJson.cpProjectStatusLabel+"</td>"+
		"<td>编辑</td>"+
		"</tr>";
			
		
	$("#clientProjectTable").append(insertValue);
}

//初始数据
function initClientProjectData(){

	var cpProjectCode = $("#cpProjectCode").val("");
// 	var uCode =  $("#uCode").val("");
	var cpShare =  $("#cpShare").val("0");
	var cpValue =  $("#cpValue").val("0");
	var cpGain =  $("#cpGain").val("0");
	var cpProjectStatus =  $("#cpProjectStatus").val("1");
}

</script>

