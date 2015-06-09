<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>dom</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
		function isCheckRadio() {
			
			var isCheck = false;
			
			// r1.length 不兼容Firefox
			var r1R = document.getElementsByName("r1");
			
			for(var i=0; i<r1R.length; i++) {
				if(r1R[i].checked) {
					isCheck = true;
					break;
				}
			}
			alert(isCheck);
		}
	</script>
  </head>
  
  <body>
    <label><input type="radio" name="r1" value="1" />1</label><br/>
    <label><input type="radio" name="r1" value="2" />2</label><br/>
    <label><input type="radio" name="r1" value="3" />3</label><br/>
    <label><input type="radio" name="r1" value="4" />4</label><br/>
    <input type="button" onclick="isCheckRadio();" value="是否选中了radio" />
  </body>
</html>
