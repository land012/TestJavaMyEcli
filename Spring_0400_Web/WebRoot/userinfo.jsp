<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table {
			border-collapse: collapse;
			border:#333333 solid 1px;
		}
		th, td {
			border:#333333 solid 1px;
		}
	</style>
  </head>
  
  <body>
    <s:if test="#request.user != null">
    	<table>
    		<tr>
    			<th>ID</th>
    			<th>username</th>
    			<th>password</th>
    		</tr>
    		<tr>
    			<td><s:property value="#request.user.id" /></td>
    			<td><s:property value="#request.user.username" /></td>
    			<td><s:property value="#request.user.password" /></td>
    		</tr>
    	</table>
    </s:if>
    <s:else>
    	找不到用户
    </s:else>
  </body>
</html>
