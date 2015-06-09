<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'opener1.jsp' starting page</title>
    
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
			/*
			 * 这种弹出窗口
			 * 这个窗口会被浏览器阻止
			 */
			//window.open("opener2.jsp", "_blank");
			
			/*
			 * 这两种弹出窗口
			 * 这个窗口不会被浏览器阻止
			 */
			//window.open("opener2.jsp", "_self");
			//window.open("opener2.jsp", "_top");
			
			$("#btn1").click(function() {
				window.open("opener2.jsp", "_blank");
				window.open("", "_self");
				//window.open("opener2.jsp", "_blank"); // 第二次的页面会被浏览器阻止
			});
			
			$("#btn2").click(function() {
				//alert(navigator.userAgent);
				var params = new Object();
				params.k1 = "v1";
				
				var features = "dialogWidth:600px; dialogHeight:400px; resizable:no;";
				
				if(navigator.userAgent.indexOf("MSIE") != -1) {
					window.showModalDialog("opener3.jsp", params, features);
				} else if(navigator.userAgent.indexOf("Firefox") != -1) {
					window.showModalDialog("pages/js/opener3.jsp", params, features);
				}
			});
		});
	</script>
  </head>
  
  <body>
  	<b>打开页面 opener2.jsp:</b><br/><br/>
    <input type="text" id="txt1" value="abc" />
    <br/><br/>
    <input type="button" id="btn1" value="window.open()" />
    <br/><br/>
    <a href="pages/js/opener2.jsp" target="_blank" >opener2</a>
    <br/><br/>
    <form action="pages/js/opener2.jsp" method="post" target="_blank">
    	<input type="submit" value="提交" />
    </form>
    <hr/>
    
    <iframe src="pages/js/opener2.jsp" style="width:500px; height:300px;"></iframe>
    
    <hr/>
    <b>打开页面opener1_1.jsp:</b><br/><br/>
    <a href="pages/js/opener1_1.jsp" target="_blank">opener1_1</a>
    <hr/>
          打开一个window.showModalDialog()：<br/>
    <input type="button" id="btn2" value="showModalDialog" />
  </body>
</html>
