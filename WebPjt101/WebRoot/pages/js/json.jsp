<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>JSON</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		jQuery(function() {
			$("#btn1").click(function() {
				$.ajax({
					type : "GET",
					url : "test1_getJson.do",
					cache : false,
					dataType : "json",
					success : function(data) {
						var res = "<ul>";
						for(var i=0; i<data.length; i++) {
							res += "<li>" + data[i].id + "-" + data[i].username + "</li>";
						}
						res += "</ul>";
						$("#div1").html(res);
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="GET_LIST" />
    <div id="div1">
    </div>
  </body>
</html>
