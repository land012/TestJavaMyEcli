<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery.metadata.js"></script>
	
	<style type="text/css">
		label.error {
			color:#FF0000;
		}
	</style>
	
	<script type="text/javascript">
		var flag = false;
		var timer;
		
		jQuery(function() {
			$("#btn1").click(function() {
				var res = ajaxtest();
				alert(res);
			});
		});
		
		function ajaxtest() {
			$.post("wait_wait3.do", {}, function(data) {
				//alert(flag);
				flag = true;
			});
			// 死循环
			/*while(!flag) {
				
			}*/
			return flag;
		}
		
		function getFlag() {
			return flag;
		}
		
		///setInterval(getFlag, 3000);
	</script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="ajax测试" />
  </body>
</html>
