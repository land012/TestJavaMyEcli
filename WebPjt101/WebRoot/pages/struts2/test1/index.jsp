<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

session.setAttribute("k1", "v1");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>test1/index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

	<style type="text/css">
    	.left_td {
    		
    	}
    	.tbl1 {
    		color:#F5F5F5; text-align:center;
    	}
    	ul {
    		height:100%; overflow:hidden;
    	}
    	ul li {
    		width:200px; float:left; margin:5px 0px;
    	}
    	dt, dd {
    		display: block;
    	}
    </style>
    
     <script type="text/javascript">
    	
    </script>
  </head>
  
  <body>
  	<p>this is test1_index</p>
  </body>
</html>