<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jstest</title>
    
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
			$(":radio[name=r1]").click(function() {
				//alert($(":radio[name=r1]:checked").val());
			});
			
			$("#btn1").click(function() {
				//alert(typeof($(":radio[name=r1]:checked").val()));
				//alert($(":radio[name=r1]:checked").val());
				
				//alert($(":radio[name=r1]:checked").attr("name"));
				alert($(":radio[name=r1]:checked").attr("checked") + "|" + $(":radio[name=r1]:checked").prop("checked")); //没有个这属性，所以一直是 undefined，即使是选中状态
			});
			
			$(":checkbox[name=cb1]").click(function() {
				//alert($(":checkbox[name=cb1][checked=checked]").val());
			});
			
			$("#btn2").click(function() {
				$(":checkbox[name=cb1]:checked").each(function() {
					alert($(this).val());
				});
				//alert(.val());
				//$(":checkbox[name=cb1]").each(function() {
				//	alert($(this).attr("checked"));
				//});
			});
			
			var str = null;
			if(str!=null) {
				var arr = str.split("|");
			}
			
			/*var str2 = "1|2||3";
			var arr2 = str2.split("|");
			alert(arr2.length);*/
			
			
			
			$("#btn4").click(function() {
				var h1 = document.body.clientHeight; // 可视窗口高度
				var h1_1 = document.documentElement.clientWidth;
				//alert(h1 + "-" + h1_1);
				//var h2 = $(document.body).attr("clientHeight");
				//alert(h2); // undefined
				
				var h3 = window.screen.height;
				var h4 = window.screen.availHeight;
				var h5 = window.screenHeight; // undefined
				//alert( h3 + "-" + h4 + "-" + h5);
				
				//alert(navigator.userAgent);
				
				//alert(navigator.appVersion);
				
				/*var appName = navigator.appName;
				var appCodeName = navigator.appCodeName; // Mozilla
				var platform = navigator.platform; // Win32
				alert(appName + "\n" + appCodeName + "\n" + platform);*/
				
				//window.close();
				
				//alert(window.location.hash); // 路径中 "#"后面的内容，包括"#"
				fn1();
			});
			
			// 相同name的select
			$("#btn5").click(function() {
				alert($("select[name=slt1]").val());
			});
			
			// 重名的函数
			$("#btn6").click(function() {
				fn1();
			});
			
			$("#a1").click(function() {
				alert("I'm $('a').onclick!");
			});
			
		});
		
		function fn1() {
			alert("定义靠前面的函数fn1()！");
		}
		
		function a_fn1() {
			alert("I'm href!");
		}
		
		function a_fn2() {
			alert("I'm onclick!");
		}
		
	</script>
	
	<style type="text/css">
		
	</style>

  </head>
  
  <body>
    <input type="radio" name="r1" value="1" /> 1
    <input type="radio" name="r1" value="2" /> 2
    <input type="radio" name="r1" value="3" /> 3
    <input type="button" id="btn1" value="选中的radio" />
    <br/><br/>
    <input type="checkbox" name="cb1" value="1" /> 1
    <input type="checkbox" name="cb1" value="2"  /> 2
    <input type="checkbox" name="cb1" value="3" /> 3
    <input type="button" id="btn2" value="选中的checkbox" />
    
    <br/><br/>
    
    <input type="text" value="1" />
    
    <br/>
    
    <hr/>
    
    <input type="button" id="btn4" value="I'm Button!"/>
    
    <hr>
    name相同的select:<br/>
    <select name="slt1">
    	<option value="1">1</option>
    	<option value="2">2</option>
    </select>
    
    <select name="slt1">
    	<option value="a">a</option>
    	<option value="b">b</option>
    </select>
    
    <input type="button" id="btn5" value="BUTTON" />
    
    <hr/>
    
    <input type="button" id="btn6" value="重名的函数执行哪个？" />
    
    <hr/>
    
    <a href="javascript:a_fn1();" onclick="a_fn2();">href和onclick先执行哪个？</a>
    <br/>
    <a href="javascript:void(0);" onclick="a_fn2();">href为void(0)</a>
    <br/>
    <a href="javascript:void(0);" id="a1">href为void(0)</a>
  </body>
</html>
<script type="text/javascript">
<!--
function fn1() {
	alert("定义靠后面的函数fn1()！");
}
//-->
</script>
