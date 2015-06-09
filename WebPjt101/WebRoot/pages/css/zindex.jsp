<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zindex.jsp' starting page</title>
    
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
    <div style="position:relative; background-color:#808000; width:400px; height:100px;">
    	<div style="position:relative; background-color:#800000; width:40px; height:40px;"></div>
    	<div style="position:absolute; z-index:10; background-color:#008000; width:60px; height:40px; top: 10px;"></div>
    	<div style="position:relative; z-index:1; background-color:#000080; width:40px; height:40px;"></div>
    	<div style="position:absolute; z-index:10; background-color:#008080; width:50px; height:30px; top: 10px;"></div>
    </div>
    <div style="background-color:#800080; height:50px;">
    	<input type="text" style="border:#333333 solid 1px; height:30px; line-height:20px; padding:3px 5px 2px 5px;" />
    	<label style="background-color:#808080; height:30px;">哈哈</label>
    </div>
  </body>
</html>
