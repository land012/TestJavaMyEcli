<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JS正则表达式</title>
    
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
			var re1 = /^c\w{4}|23\d{4}$/;
			var re2 = /^(c\w{4}|23\d{4})$/;
			var s = "c234534d"; // 希望得到的结果为 false
			//alert(re1.test(s) + "-" + re2.test(s));
			//alert(s.match(re));
			
			var re3 = /^[0-9]$/; // 纯数字
			//alert(re3.test("0"));
			//alert(re3.test("1b2")); // false
			
			var re4 = /[^A-Za-z0-9]/;
			//alert(re4.test("")); // false ????????????
			//alert(re4.test("ya")); // true
			
			var re5 = /[A-Za-z0-9]/;
			//alert(re5.test("")); // false
			//alert(re5.test("ab32"));
			
			var re6 = /[A-Za-z0-9]*/;
			//alert(re6.test("")); // true
			
			alert(isLetterDigit("123")
					+ "-" + isLetterDigit("abc")
					+ "-" + isLetterDigit("AB")
					+ "-" + isLetterDigit("Aa")
					+ "-" + isLetterDigit("_")
					+ "-" + isLetterDigit("_A8")
					+ "-" + isLetterDigit("a9"));
			
			//alert(/^[0-9]+$/.test("112"));
		});
		
		/**
		 * 是否是英文和数字的组合
		 */
		function isLetterDigit(value) {
			if(/^[0-9]+$/.test(value)) {
				//alert("1");
				return false;
			}
			if(/^[A-Za-z]+$/.test(value)) {
				//alert("2");
				return false;
			}
			if(/^[A-Za-z0-9]+$/.test(value)) {
				//alert("3");
				return true;
			}
			//alert("4");
			return false;
		}
	
	</script>
  </head>
  
  <body>
    
  </body>
</html>
