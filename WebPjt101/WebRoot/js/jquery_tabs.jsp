<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jquery tabs</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=gbk" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<!--  
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
	-->
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.all.css" />
	<!--  
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.core.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.tabs.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3/themes/base/jquery.ui.theme.css" />
	-->
	
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
	
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3/ui/jquery.ui.tabs.js"></script>
	
	<script type="text/javascript">
		jQuery(function() {
			$("#tabs1").tabs();
		});
	</script>
	<style type="text/css">
		body {
			font-size:9pt;
		}
	</style>
  </head>
  
  <body>
    <div id="tabs1">
    	<ul>
    		<li><a href="#tabs1_1">tabs1_1</a></li>
    		<li><a href="#tabs1_2">tabs1_2</a></li>
    		<li><a href="#tabs1_3">tabs1_3</a></li>
    	</ul>
    	<div id="tabs1_1">
    		<p>tabs1_1 contents</p>
    	</div>
    	<div id="tabs1_2">
    		<p>tabs1_2 contents</p>
    	</div>
    	<div id="tabs1_3">
    		<p>tabs1_3 contents</p>
    	</div>
    </div>
  </body>
</html>
