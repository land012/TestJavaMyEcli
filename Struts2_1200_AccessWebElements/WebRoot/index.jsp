<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���� Web Ԫ��</title>
    
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
    <form name="login" action="" method="post">
	�û�����	<input type="text" name="username" /><br/>
	���룺<input type="text" name="password" /><br/>
	<input type="button" value="�ύ1" onclick="document.login.action='login/login1'; document.login.submit()" />
	<input type="button" value="�ύ2" onclick="document.login.action='login/login2'; document.login.submit()" />
	<input type="button" value="�ύ3" onclick="document.login.action='login/login3'; document.login.submit()" />
	<input type="button" value="�ύ4" onclick="document.login.action='login/login4'; document.login.submit()" />
	</form>
  </body>
</html>