<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表单提交-中文乱码 handle</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<meta http-equiv="content-type" content="text/html; charset=gbk" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
	String method = request.getMethod();
	out.println(method + "<br/>");
	if("get".equalsIgnoreCase(method)) {
		String str1 = request.getParameter("str1");
		if(str1!=null) {
			str1 = new String(str1.getBytes("ISO-8859-1"), "gbk");
			out.println(str1);
		}
	} else if("post".equalsIgnoreCase(method)) {
		request.setCharacterEncoding("gbk");
		String str1 = request.getParameter("str1");
		if(str1!=null) {
			out.println(str1);
		}
	} else {
		String str1 = request.getParameter("str1");
		out.println(str1);
	}
	
%>
  </body>
</html>
