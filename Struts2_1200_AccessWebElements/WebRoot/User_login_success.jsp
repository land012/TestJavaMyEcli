<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User_login_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    User Login Success!
	<br/>
	<s:property value="#request.r1_name"/> | <%=request.getAttribute("r1_name") %>
	<br/>
	<s:property value="#session.s1_name"/>
	<br/>
	<s:property value="#application.a1_name"/>
	<hr/>
	ÓÃ»§Ãû£º<s:property value="#request.username"/> | <s:property value="username"/>
	<br/>
	ÃÜÂë£º<s:property value="#request.password"/>
	<br/>
	<s:debug></s:debug>
  </body>
</html>
