<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery.1.7.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css" />
	<script type="text/javascript" src="extjs/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="extjs/ext-all.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function() {
			//Ext.Msg.alert('here is title','this is message!');
		});
		jQuery(function(){
			jQuery("#btn1").click(function(){
				window.showModalDialog("http://www.baidu.com", "","dialogWidth:750px; dialogHeight:500px; center:1; resizable:0;");
			});
		});
	</script>
	
	<style type="text/css">
		body {
			padding:10px;
		}
	</style>
  </head>
  
  <body>
    <input type="button" id="btn1" value="点击我弹出窗口！" />
    <hr>
    <ul>
    	<li><a href="/extjs/examples/" target="_blank">extjs_examples</a></li>
    	<li><a href="/extjs/docs/" target="_blank">extjs_docs</a></li>
    	<li><a href="/MyWebPjt/" target="_blank">MyWebPjt</a></li>
    	<li><a href="/extjs.jsp" target="_blank">ExtJS</a></li>
    	<li><a href="/main" target="_blank">前台首页</a></li>
    </ul>
  </body>
</html>
