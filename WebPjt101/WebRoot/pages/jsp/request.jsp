<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>REQUEST</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  </head>
  
  <body>
    <table class="tbl_std">
    	<tr>
    		<td>request.getScheme()</td>
    		<td><%=request.getScheme() %></td>
    	</tr>
    	<tr>
    		<td>request.getServerName()</td>
    		<td><%=request.getServerName() %></td>
    	</tr>
    	<tr>
    		<td>request.getServerPort()</td>
    		<td><%=request.getServerPort() %></td>
    	</tr>
    	<tr>
    		<td>request.getLocalAddr()</td>
    		<td><%=request.getLocalAddr() %></td>
    	</tr>
    	<tr>
    		<td>request.getLocalName()</td>
    		<td><%=request.getLocalName() %></td>
    	</tr>
    	<tr>
    		<td>request.getLocalPort()</td>
    		<td><%=request.getLocalPort() %></td>
    	</tr>
    	<tr>
    		<td>request.getRemoteAddr()</td>
    		<td><%=request.getRemoteAddr() %></td>
    	</tr>
    	<tr>
    		<td>request.getRemoteHost()</td>
    		<td><%=request.getRemoteHost() %></td>
    	</tr>
    	<tr>
    		<td>request.getRemotePort()</td>
    		<td><%=request.getRemotePort() %></td>
    	</tr>
    	<tr>
    		<td>request.getRemoteUser()</td>
    		<td><%=request.getRemoteUser() %></td>
    	</tr>
    	
    	<tr>
    		<td>&nbsp;</td>
    		<td></td>
    	</tr>
    	
    	<tr>
    		<td width="200">request.getPathInfo()</td>
    		<td><%=request.getPathInfo() %></td>
    	</tr>
    	<tr>
    		<td>request.getContextPath()</td>
    		<td><%=request.getContextPath() %></td>
    	</tr>
    	<tr>
    		<td>request.getServletPath()</td>
    		<td><%=request.getServletPath() %></td>
    	</tr>
    	<tr>
    		<td>request.getRequestURL()</td>
    		<td><%=request.getRequestURL() %></td>
    	</tr>
    	<tr>
    		<td>request.getRequestURI()</td>
    		<td><%=request.getRequestURI() %></td>
    	</tr>
    	<tr>
    		<td>request.getRealPath("")</td>
    		<td><%=request.getRealPath("") %></td>
    	</tr>
    	<tr>
    		<td>request.getRealPath("/")</td>
    		<td><%=request.getRealPath("/") %></td>
    	</tr>
    	<tr>
    		<td>request.getRealPath("/web1")</td>
    		<td><%=request.getRealPath("/web1") %></td>
    	</tr>
    	<tr>
    		<td>request.getRealPath("request.jsp")</td>
    		<td><%=request.getRealPath("request.jsp") %></td>
    	</tr>
    	<tr>
    		<td>request.getQueryString()</td>
    		<td><%=request.getQueryString() %></td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td></td>
    	</tr>
    	<tr>
    		<td><b>request.getHeaderNames()</b></td>
    		<td></td>
    	</tr>
    	<%
    		Enumeration<String> headers = request.getHeaderNames();
    		while(headers.hasMoreElements()) {
    			String temp = headers.nextElement();
		%>
		<tr>
			<td><%=temp %></td>
			<td><%=request.getHeader(temp) %></td>
		</tr>
		<%
    		}
    	%>
    </table>
  </body>
</html>
