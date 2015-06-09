<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'opener2.jsp' starting page</title>
    
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
			// 弹出窗口被阻止
			//window.open("opener3.jsp", "_blank");
			
			$("#btn1").click(function() {
				//window.opener.document.getElementById("txt1").value = "def";
				/*
				 * window.parent,window.top不能取到打开该页面的页面(也就是上一个页面)
				 */
				//window.parent.document.getElementById("txt1").value = "abc";
				//window.top.document.getElementById("txt1").value = "abc";
				
				/*
				 * 在页面A中用 window.open(),链接a 或 form-post,打开新页面B
				 * 都可以用 window.opener 在页面B 获取到前一个页面A的引用
				 */
				var p_txt1 = window.opener.document.getElementById("txt1");
				//alert($(p_txt1).val());
				//alert(p_txt1); // HTMLInputElement
				$(p_txt1).val("def");
				//p_txt1 = window.parent.document.getElementById("txt1");
			});
			
			$("#btn2").click(function() {
				
			});
			
			$("#btn3").click(function() {
				/*
				 * 当第二个页面B不关闭时，可以在第三个页面C 拿到第一个页面A的引用
				 */
				var pp_txt1 = window.opener.opener.document.getElementById("txt1");
				alert(pp_txt1.value);
			});
			
			$("#btn4").click(function() {
				window.open("", "_self");
				//window.opener=null;
				window.close();
			});
			
			$("#btn5").click(function() {
				/*
				 * 用 window.parent或window.top都可以
				 * 让iframe中的页面B,获取到iframe所有页面A中的元素
				 */
				var p_txt1 = window.parent.document.getElementById("txt1");
				//var p_txt1 = window.top.document.getElementById("txt1");
				$(p_txt1).css("color", "#FF0000").val("我的内容改变了！");
			});
		});
	</script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="修改前一个窗口的内容" />
    <br/><br/>
    <input type="button" id="btn2" value="I'm Button2!" />
    <br/><br/>
    <input type="button" id="btn3" value="第三个窗口获取第一个窗口的内容" />
    <br/><br/>
    <input type="button" id="btn4" value="关闭当前窗口，不提示" />
    <br/><br/>
    <input type="button" id="btn5" value="修改父窗口 parent内容" />
    <br/><br/>
    <a href="pages/js/opener3.jsp">opener3</a>
  </body>
</html>
