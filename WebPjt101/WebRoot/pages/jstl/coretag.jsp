<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="cp" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${cp }">
    
    <title>JSTL入门</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<style type="text/css">
		.tbl_std {
			
		}
		.tbl_std th, .tbl_std td {
			border-right:#800080 solid 1px; padding:3px 10px;
		}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		jQuery(function() {
			
		});
	</script>
  </head>
  
  <body>
    <c:out value="5"></c:out>
    <hr>
    <table class="tbl_std">
    	<tr>
    		<td>pageContext.request.contextPath</td>
    		<td>${pageContext.request.contextPath }</td>
    	</tr>
    </table>
  </body>
</html>
