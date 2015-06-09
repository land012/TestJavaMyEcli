<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jquery_dialog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	
	<!-- <link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.css" /> -->
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.core.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.dialog.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.theme.css" />
	
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.dialog.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#div_dialog1").dialog({
				autoOpen : false,
				title : "说明",
				width : 300,
				height : 300,
				modal : true,
				resizable : true,
				draggable : false,
				closeText : "关闭我！",
				closeOnEscape : false
			});
			
			$("#btn1").click(function() {
				$("#div_dialog1").dialog("open");
			});
		});
	</script>

  </head>
  
  <body>
    <input type="button" id="btn1" value="click" />
    <div id="div_dialog1" style="display:none">弹窗</div>
  </body>
</html>
