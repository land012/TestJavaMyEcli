<%@ page 
	language="java" 
	import="java.util.*" 
	pageEncoding="GB18030"
	contentType="text/html;charset=GB18030"
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Index 页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="contentType" content="text/html;charset=gb18030" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Index 页面<br>
<form action="login" method="post">
	用户名：<input type="text" name="user.name" /><br/>
	年龄：<input type="text" name="user.age" /><br/>
	<input type="submit" />
</form>
<hr/>

用户名：<s:property value="user.name" /><br/>
年龄：<s:property value="user.age" />
<s:debug></s:debug>
  </body>
</html>
