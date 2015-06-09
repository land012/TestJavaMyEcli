<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JS日期</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<!--  
	<script type="text/javascript" src="js/des.js" charset="utf-8"></script>
	-->
	
	<script type="text/javascript">
		jQuery(function() {
			// 获取 yyyyMMddHHMISS
			var now = new Date();
			var year = now.getFullYear().toString();
			var month = (now.getMonth()+1).toString();
			var day = now.getDate().toString();
			var hour = now.getHours().toString();
			var minute = now.getMinutes().toString();
			var second = now.getSeconds().toString();
			month = padleftZ(month);
			day = padleftZ(day);
			hour = padleftZ(hour);
			minute = padleftZ(minute);
			second = padleftZ(second);
			//alert(year + month + day + hour + minute + second);
			
			// 获取随机字符串
			var rnd = (Math.random()*1000000).toString();
			//alert(rnd.substr(0, 6));
		});
		
		function padleftZ(str) {
			return padleft(str, "0", 2);
		}
		
		function padleft(str, substr, num) {
			var left = num - str.length;
			for(i=1; i<=left; i++) {
				str = substr + str;
			}
			return str;
		}
	</script>
  </head>
  
  <body>
    
  </body>
</html>
