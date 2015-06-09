<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>跨站点脚本编制 XSS</title>
    
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    

  </head>
  
  <body>
  	&lt;img src=&quot;&lt;script&gt;alert(1)&lt;/script&gt;&quot; /&gt;
  	<br/><br/>
  	上面的方式在 ie6 下有效，ie7往后就不行了
  	
  	<hr/>
  	
  	<form action="pages/secure/xss2.jsp" method="post">
  	</form>
    
  </body>
</html>
