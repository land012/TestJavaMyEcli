<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>chkbox提交</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

  </head>
  
  <body>
  	
    Struts2接收checkbox的方式:<br/>
    <form action="test1_test3.do" method="post">
    	<input type="hidden" name="operate" value="submit" />
    	cb1:<input type="checkbox" name="cb1" value="1" />
    	<input type="checkbox" name="cb1" value="2" />
    	<input type="checkbox" name="cb1" value="3" />
    	<br/>
    	cb2:<input type="checkbox" name="cb2" value="1" />
    	<input type="checkbox" name="cb2" value="2" />
    	<input type="checkbox" name="cb2" value="3" />
    	<br/>
    	cb3:<input type="checkbox" name="cb3" value="1" />
    	<input type="checkbox" name="cb3" value="2" />
    	<input type="checkbox" name="cb3" value="3" />
    	<br/>
    	<input type="submit" />
    </form>
    
  </body>
</html>
