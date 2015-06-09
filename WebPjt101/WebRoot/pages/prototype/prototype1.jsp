<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>PROTOTYPE1</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/prototype-1.7.1.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			
			// 绑定事件
			Event.observe($("btn1"), "click", function() {
				/*var arr = [ "v1", "v2" ];
				alert(arr);
				
				var arr1 = [ { "k1" : "v11", "k2" : "v12" }, { "k1" : "v21", "k2" : "v22" }];
				alert(arr1);
				// 将数组转换为 JSONString
				var data1 = Object.toJSON(arr1);
				alert(data1);*/
				
				var obj21 = new Object();
				obj21.k1 = "v11";
				obj21.k2 = "v12";
				var obj22 = new Object();
				obj22.k1 = "v21";
				obj22.k2 = "v22";
				var arr2 = [ obj21, obj22 ];
				var data2 = Object.toJSON(arr2);
				alert(data2);
			});
		}
	</script>
  </head>
  
  <body>
    <input type="button" value="button1" id="btn1" />
  </body>
</html>
