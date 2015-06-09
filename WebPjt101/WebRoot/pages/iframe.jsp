<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>fn1</title>
    
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
		$(function() {
			//alert($(document).height());
			//alert(document.body.scrollHeight);
			//alert(iframe1_id.document.body.scrollHeight);
			//document.frames("iframe1_name").document.getElementById("div1").style.background = "#FF0000";
			//iframe1_id.document.getElementById("div1").style.background = "#008000";
			
			// IE
			//var subdoc = iframe1_id.contentWindow.document;
			//$("#div1", subdoc).css("background-color", "#0000FF");
			
			// 获取的是当前文档
			var doc = $(document, "#iframe1_id");
			
			//var subdoc = $("#iframe1_id").contents().document;
			
			//$("#iframe1_id").contents().find("body #div1").css("background-color", "#000066");
			//$("#iframe1_id").contents().find("body").html("<div>咻咻</div>");
			//subdoc.find("body").append("哈哈");
			// alert($("#iframe1_id").contents().find("body").outerHeight());
			
			//var subdoc = document.iframe1_id.document;
			//var subdoc = document.frames("iframe1_id").document;
			//alert(subdoc);
			
			// 仅兼容 IE
			//var subheight = document.iframe1_id.document.body.scrollHeight;
			
			
			//var subheight = $(subdoc).height();
			
			//alert(subheight);
			//$("#iframe1_id").height(subheight);
			
			//$("#iframe1_id").height();
			// alert($("#iframe1_id").contents().find("#div1").text());
			
			//var subWin = document.getElementById("iframe1_id").contentWindow;
			//var subheight = subWin.document.body.scrolltHeight;
			
			//var div1 = $("#iframe1_id").contents().find("#div1");
			//alert($(div1).text());
			
			document.getElementById("iframe1_id").onload = function() {
				// alert("iframe onload!");
				/*var subdoc = document.getElementById("iframe1_id").contentDocument;
				var subheight = $(subdoc).height();
				
				alert(subheight);
				$("#iframe1_id").height(subheight);*/
				
				// 仅 IE 可用
				//$("#iframe1_id").height(document.iframe1_id.document.body.scrollHeight);
			};
			
			$("#iframe1_id").load(function() {
				alert("1=" + $(this).contents().find("body").height());
				alert("2=" + document.getElementById("iframe1_id").contentDocument.body.scrollHeight);
			});
			
			
			/**
			 * 获取iframe中的文档
			 */
			var subdoc1 = document.iframe1_id.contentDocument;
			$(subdoc1).ready(function() {
				//alert("iframe document ready!");
				
				// scrollHeight 对象为 null 或 未定义
				//var subheight = document.iframe1_id.document.body.scrollHeight;
				//var subdoc = document.getElementById("iframe1_id").contentDocument;
				//subdoc.getElementById("div1").style.background = "red";
				//var subheight = $(subdoc).height();
				
				//alert(subheight);
				//$("#iframe1_id").height(subheight);
				
			});
			
			// loading
			// alert(document.getElementById("iframe1_id").readyState);
		});
		
		
		
		/*window.onload = function() {
			alert("哈哈");
		}*/
		
		function iframeA(){
			var a = getIFrameDOM("wIframeA");
			a.getElementById('hello').style.background = "red";
		}
		
		function iframeB(){
			var a = getIFrameDOM("wIframeB");
			a.getElementById('hello').style.background = "green";
		}
		
		function getIFrameDOM(id){
			return document.getElementById(id).contentDocument || document.frames[id].document;
		}
		
		function optSubFrame() {
			/*
			 * 在使用  contentDocument 对象时，必须等待加载完成 iframe页面的内容
			 * 而 jquery 的 ready() 只是加载完成了父页面，而并没有加载完 iframe 中的页面
			 * 所以得到的 contentDocument 内容为空
			 */
			//var subdoc = document.getElementById("iframe1_id").contentDocument;
			//subdoc.getElementById("div1").style.background = "red";
			//$("#iframe1_id").height($(subdoc).height());
			
			//$("#iframe1_id").contents().find("#div1").css("background-color", "#008000");
			
			// 该属性仅兼容 IE
			// complete
			//alert(document.getElementById("iframe1_id").readyState);
			// undefined
			//alert(document.frames["iframe1_id"].readyState);
			
			// alert(document.getElementById("iframe1_id").document.body.scrollHeight);
			
			// ----------------- 以下 只适用 IE BEGIN -----------------
			
			// 获取的是当前 document
			//document.getElementById("iframe1_id").document.getElementById("p_div1").style.background = "#0000FF";
			
			//var ifm = document.getElementById("iframe1_id");
			//ifm.document.getElementById("p_div1").style.background = "#0000FF"; // 依然得到当前文档
			
			// iframe 中的文档
			//iframe1_id.document.getElementById("div1").style.background = "#0000FF";
			
			// 当前文档
			//alert(document.getElementById("iframe1_id").document.body.scrollHeight);
			// iframe 文档
			//alert(iframe1_id.document.body.scrollHeight);
			
			// ----------------- 以下 只适用 IE END -----------------
			
			/*document.getElementById("iframe1_id").src = "pages/fn1_3.jsp";
			document.getElementById("iframe1_id").onload = function() {
				this.height = this.contentDocument.body.scrollHeight;
			}*/
		}
	</script>
  </head>
  
  <body>
    <!-- request.getQueryString():<%=request.getQueryString() %>  -->
    
    <hr>
    
    
    <script type="text/javascript">
		var g_k1 = "v1";
	</script>
	<% String k1 = "v1"; %>
    include:<br>
    <dl>
    	<dt><b>@include - fn1_1.jsp：</b>可以使用父文件中的变量</dt>
    	<%if(true) { %>
    	<dd><%@ include file="fn1_1.jsp" %></dd>
    	<%} %>
    </dl>
    <dl>
    	<dt><b>jsp:include - fn1_2.jsp：</b>不能使用父文件中的变量，会报错</dt>
    	<%if(true) { %>
    	<dd><jsp:include page="fn1_2.jsp"></jsp:include></dd>
    	<%} %>
    </dl>
    
    <hr>
    
    <div id="p_div1" style="border:5px #000000 double; width:100px; height:20px;"></div>
    
    <hr>
    
    <input type="button" onclick="optSubFrame();" value="操作" />
    <br><br/>
    iframe1_1
    <br/>
    <iframe id="iframe1_id" name="iframe1_name" scrolling="no" src="pages/iframe1_1.jsp"></iframe>
    
    <hr>
    <br/><br/><br/><br/><br/>
  </body>
</html>