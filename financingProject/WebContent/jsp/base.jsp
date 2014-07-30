<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<link rel="stylesheet" type="text/css" href="js/jquery.ui.custom/jquery-ui.css" >
<!-- <link rel="stylesheet" type="text/css" href="js/jquery.easyui/themes/default/easyui.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="js/jquery.easyui/themes/icon.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="js/jquery.easyui/demo.css"> -->
<link rel="stylesheet" type="text/css" href="js/jqueryPaginationPlugin/pagination.css" />
        
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="js/jquery.ui.custom/jquery-ui.js" type="text/javascript"></script>

<!-- <script src="js/jquery.easyui/jquery.easyui.min.js" type="text/javascript" ></script> -->
<script src="js/jqueryPaginationPlugin/jquery.pagination.js" type="text/javascript" ></script>

<script type="text/javascript">
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		};
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		};
	//设置默认的日期控件格式	
		var setting = {
// 				appendText:"(yyyy-mm-dd)",
				showOn:'both',
				buttonImage:'image/datebox_arrow.png',
				buttonImageOnly:'true',
				dateFormat:'yy-mm-dd',
				duration:'fast',
				showButtonPanel:true,
				showOthermonths:true,
				changeMonth:true,
				changeYear:true,
				closeText:'Close'
				};
		$.datepicker.setDefaults(setting);
		
</script>


