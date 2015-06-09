<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
path = request.getContextPath();
basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fn1_1.jsp' starting page</title>
    
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
    <table>
    	<tr><td>
    		<i>js:</i>
    		<script type="text/javascript">
		    	document.write(g_k1);
		    </script>
		    
    	</td></tr>
    	<tr><td><i>java:</i> <%=k1 %></td></tr>
    </table>
  </body>
</html>
