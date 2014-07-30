<%@ include  file="/jsp/base.jsp" %>
<%@ page pageEncoding="UTF-8"%>


  <body>

		<div class="ui-overlay" >
			<div class="ui-widget-overlay"></div>
			<div class="ui-widget-shadow ui-corner-all" style="width: 582px; height: 282px; position: absolute; left: 30%; top: 20%;"></div>
		</div>
		<div style="position: absolute; width: 560px; height: 260px;left: 30%; top: 20%; padding: 10px;" class="ui-widget ui-widget-content ui-corner-all">
			<div class="ui-dialog-content ui-widget-content" style="background: none; border: 0;">
				<table style="width: 98%;height: 98%;" >
					<tr>
						<td align="center" colspan="2" style="height: 80px;">
							
						</td>
					</tr>
					<tr>
						<td>
							账号:<input type="text" value="test" name="loginName" id="loginName" style="width: 240px;">
						</td>
						<td>
							<div id="loginNameError"  class="ui-widget" style="height: 25px;width: 90%;display: none;">
								<div class="ui-state-highlight ui-corner-all" style="margin-top: 1px; padding: 0 .7em; height: 24px;">
									<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
									<strong>Hey!</strong> 账户不存在！
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							密码:<input type="password" value="123" name="password" id="password"  style="width: 240px;">
							
						</td>
						<td>
							<div id="passwrodError" class="ui-widget" style="height: 25px;width: 90%; display: none;">
								<div class="ui-state-highlight ui-corner-all" style="margin-top: 1px; padding: 0 .7em; height: 24px;">
									<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
									<strong>Hey!</strong> 密码错误！
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<br/><br/>
							<input type="button" onclick="login()" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="取消" onclick="test()" >
						</td>
					</tr>
				</table>
			</div>
		</div>
  </body>
<script type="text/javascript">
function login(){
	var uLoginName = $("#loginName").val();
	var uPassWord = $("#password").val();
	var gotoUrl = "index.jsp";
	$.ajax({
		   type: "POST",
		   url: "loginActionAjax.do",
		   data: "uLoginName="+uLoginName+"&uPassWord="+uPassWord,
		   dataType:"json",
		   success: function(msg){
			   var status = msg.status;
			   if("1"==status){
				   $("#loginNameError").css('display','none');
				   $("#passwrodError").css('display','none');
				   window.open(gotoUrl,"_self");
				   return;
			   }
			   if("2"==status){
				   //用户名不存在
				   $("#loginNameError").css('display','block');
				   $("#passwrodError").css('display','none');
				   return;
			   }
			   if("3"==status){
				   //密码错误
				    $("#loginNameError").css('display','none');
				   $("#passwrodError").css('display','block');
				   return;
			   }
		   }
		});
}

function test(){
	window.open("loginActionAjax.do?uLoginName=t33","_self");
}
</script>
