<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>fn1_3.jsp</title>
    
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
		/*
		 * 这种写法不兼容 搜狗
		 * 兼容 qq,chrome,firefox,傲游,百度,IE10,360
		 */
		window.onload = function() {
			//window.parent.document.getElementById("iframe1_id").height = document.body.scrollHeight;
		};
		
		// 这种写法兼容所有浏览器
		jQuery(function() {
			window.parent.document.getElementById("iframe1_id").height = document.body.scrollHeight;
		});
		
		jQuery(function() {

		});
		
		function fn1(domobj) {
			// 在这里直接用 this 的话，获取的是当前页面所在的 iframe
			//alert(this.name + "-" +domobj.name);
			
			/*
			 * 下面的 this,在不同浏览器中，
			 * 有的指向当前文档 document(FF,Chrome等标准浏览器),
			 * 有的指向 iframe（IE等少数）
			 * 而搜狗获取的高度是 0，不知道指向哪了！！！！！
			 */
			alert($(this).height());
		}
	</script>
  </head>
  
  <body>
    fn1_3
    <hr>
    <a href="pages/iframe1_1.jsp?key=1">增加当前页面内容</a>
    <div id="div1" style="width:200px; height:200px; border:#808000 solid 1px;">你好</div>
    
    <br/><br/>
    
    <input type="button" onclick="fn1(this);" value="this" />
    
    <%
    	String key = request.getParameter("key");
    	if("1".equals(key)) {
	%>
	<br><br>
	你好
	<br><br>
	<%
    	}
    %>
  </body>
</html>

