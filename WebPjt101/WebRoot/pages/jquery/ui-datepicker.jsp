<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>datepicker</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	
	<!-- ui.1.9.2 -->
	<!--  
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.9.2.custom/themes/base/jquery.ui.all.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.9.2.custom/themes/base/jquery.ui.datepicker.css" />
	<script type="text/javascript" src="js/jquery-ui-1.9.2.custom/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.9.2.custom/ui/jquery.ui.datepicker.js"></script>
	-->
	
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.core.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.datepicker.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/flick/jquery.ui.theme.css" />
	
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.datepicker.js"></script>
	
	<style type="text/css">
		body {
			font-size: 11pt;
		}
		* {
			font-size: 9pt;
		}
		#txt_date2 {
			background:url(images/datePicker.gif) center right no-repeat;
			border:#333333 solid 1px;
			height:18px;
		}
		
		#div_date_3 {
			/*border:#800080 solid 1px;*/
		}
		#txt_date3 {
			margin:0px; float:left;
		}
		/* 下面的样式效果同  buttonImageOnly:true 相同 */
		/*#div_date_3 .ui-datepicker-trigger {
			margin:0px; padding:0px 0px 0px 1px; border:none; background:none;
		}*/
	</style>
	
	<script type="text/javascript">
		$(function() {
			$("#txt_date2").datepicker({
				dateFormat: "yy-mm-dd",
				changeMonth: true,
				changeYear: true,
				showButtonPanel: true,
				currentText: "Today", // 回到今天，并不是将今天填到 input 中
				firstDay: 1
			});
			$("#txt_date2").datepicker("setDate", "yy-mm-dd"); // 设置默认日期
			
			$("#txt_date3").datepicker({
				dateFormat: "yy-mm-dd",
				showOn: "both",
				buttonImage: "images/datePicker.gif",
				buttonImageOnly: true // 仅显示图片，而不将图片显示为按钮的背景
			});
		});
	</script>
  </head>
  
  <body>
  	<br><br>
  	
  	WdatePicker:<br/>
    <input type="text" name="txt_date" onclick="WdatePicker();" class="Wdate" />
    
    <br><br>
    
    ui-datepicker:<br/>
    <input type="text" name="txt_date2" id="txt_date2" />
    
    <br><br>
    
    
    <div id="div_date_3">
    	<input type="text" name="txt_date3" id="txt_date3" />
    </div>
    
  </body>
</html>
