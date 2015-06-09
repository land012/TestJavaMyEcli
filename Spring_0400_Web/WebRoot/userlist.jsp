<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>用户列表</title>
    
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
			border:#333333 solid 1px; padding:3px 5px;
		}
	</style>

  </head>
  
  <body>
    <s:if test="#request.userlist != null">
    	<table>
    		<tr>
    			<th>ID</th>
    			<th>username</th>
    			<th>password</th>
    			<th>操作</th>
    		</tr>
	    	<s:iterator	value="#request.userlist" var="user">
	    		<tr>
	    			<td><s:property value="#user.id" /></td>
	    			<td><s:property value="#user.username" /></td>
	    			<td><s:property value="#user.password" /></td>
	    			<td>
	    				<a href="account_userinfo.do?id=<s:property value="#user.id" />" target="_blank">查看</a>
	    			</td>
	    		</tr>
	    	</s:iterator>
    	</table>
    </s:if>
    <s:else>
    	找不到用户
    </s:else>
  </body>
</html>
