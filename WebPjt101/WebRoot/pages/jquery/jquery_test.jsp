<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  	<!-- jquery tabs 与 这个标签冲突，不能用这个标签 -->
  	<!-- 
    <base href="<%=basePath%>">
    -->
    <title>jquery test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=gbk" />

	<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function() {
			$("#btn1").click(function() {
				$("#div1").css("display", "");
			});
		});
	</script>
	<style type="text/css">
		body {
			font-size:9pt;
		}
	</style>
  </head>
  
  <body>
    <input type="button" id="btn1" value="display" />
    <div id="div1" style="width:100px; height:100px; border:#800080 solid 1px; display:none;"></div>
  </body>
</html>