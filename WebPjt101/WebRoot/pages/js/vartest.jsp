<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>vartest</title>
    
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
		function fn1() {
			var a = a || "1";
			var b = "3";
			b = b || "2";
			alert("a=" + a + ",b=" + b);
		}
		
		function fn2() {
			var res = "";
			var a = "5";
			var b = "";
			var c;
			var d = null;
			
			if(a) {
				res = "a=true";
			} else {
				res = "a=false";
			}
			
			if(b) {
				res += ",b=true";
			} else {
				res += ",b=false";
			}
			
			if(c) {
				res += ",c=true";
			} else {
				res += ",c=false";
			}
			
			if(d) {
				res += ",d=true";
			} else {
				res += ",d=false";
			}
			
			alert(res);
		}
		
		jQuery(function() {
			//var n1 = Number(""); // 0
			////var n1 = Number(); // 0
			//var n1 = Number(null); // 0
			//alert(n1);
		});
	</script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="||使用方法" onclick="fn1();" />
    <br/>
    <input type="button" id="btn2" value="if(var)" onclick="fn2();" />
  </body>
</html>
