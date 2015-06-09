<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>首页</title>
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
  </head>
  
  <body>
  	<ul>
  		<li><a href="account_register.do" target="_blank">用户注册</a></li>
  		<li><a href="account_userlist.do" target="_blank">用户列表</a></li>
  	</ul>
  	<hr />
    <table border="1">
    	<tr>
    		<td>request.getContextPath()</td>
    		<td><%=request.getContextPath() %></td>
    	</tr>
    </table>
  </body>
</html>
