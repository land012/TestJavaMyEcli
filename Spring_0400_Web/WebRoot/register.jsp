<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>�û�ע��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="account_register.do" method="post">
    <table>
    	<tr>
    		<td>�û���</td>
    		<td><input type="text" name="username" /></td>
    	</tr>
    	<tr>
    		<td>����</td>
    		<td><input type="password" name="password" /></td>
    	</tr>
    	<tr>
    		<td>����ȷ��</td>
    		<td><input type="password" name="password2" /></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="submit" value="ע��" /></td>
    	</tr>
    </table>
    </form>
  </body>
</html>
