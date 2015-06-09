<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>modal_window</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			
			// modal 窗口 begin
			$("#btn3").click(function() {
				$(document.body).css("overflow", "hidden");
				//var height = $(window).height(); // IE 可视窗口高度，FF 页面高度
				//var height = window.innerHeight; // IE 可视窗口高度，FF 可视窗口高度
				var height = document.body.clientHeight;
				var width = $(window).width();
				var h2 = $(document).height(); // IE/FF 页面高度
				var h3 = document.body.scrollHeight; // IE/FF 页面高度
				var h4 = document.body.offsetHeight; // IE/FF 页面高度 比 scrollHeight 小点
				//alert(height + "-" + h2 + "-" + h3 + "-" + h4);
				//var dialog_height = parseInt($("#div_modal_dialog").css("height"));
				var dialog_height = $("#div_modal_dialog").height();
				var top = (height - dialog_height)/2 - 30;
				//alert(dialog_height + "-" + top);
				
				$("#div_modal_win").css("height", height).css("width", width).css("z-index", "10").css("display", "block");
				$("#div_modal_shield").css("height", height).css("width", width);
				$("#div_modal_dialog_box").css("height", height).css("width", width);
				$("#div_modal_dialog").css("margin-top", top);
			});
			// modal 窗口 end
		});
		
	</script>
	<style type="text/css">
		#div_modal_win {
			display:none; position:absolute; top:0px; left:0px;
		}
		#div_modal_shield {
			background-color:#696969; position: relative;
			filter:alpha(opacity=80); opacity:0.8;
		}
		#div_modal_dialog_box {
			position:absolute; top:0px; left:0px; z-index:15;
		}
		#div_modal_dialog {
			width:300px; height:200px; border: #C0C0C0 solid 1px;  margin: 0px auto; padding: 10px;
			background-color: #F5F5F5;
		}
	</style>

  </head>
  
  <body>
    <!-- modal 窗口 begin -->
    <input type="button" id="btn3" value="modal窗口" />
    <div id="div_modal_win">
	    <div id="div_modal_shield"></div>
	    <div id="div_modal_dialog_box">
	    	<div id="div_modal_dialog">哈哈</div>
	    </div>
    </div>
    <!-- modal 窗口 end -->
    
    <div style="height:1000px;"></div>
  </body>
</html>
