<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="refresh" content="5;url=/index.jsp">
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		var timerCountdown;
		function countdown() {
			var cur = parseInt($("#leavetime").text());
			var next = cur - 1;
			if(next == 0) {
				clearInterval(timerCountdown);
			}
			
			$("#leavetime").text(next);
		}
		timerCountdown = setInterval(countdown, 1000);
	</script>
	
  </head>
  
  <body>
    操作成功，<span id="leavetime">5</span> 秒后跳到首页！
  </body>
</html>
