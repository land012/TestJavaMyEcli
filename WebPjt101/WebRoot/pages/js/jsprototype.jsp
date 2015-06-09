<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jsprototype</title>
    
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
		function People(name) {
			this.name = name;
			// 对象方法，用实例调用
			this.fn1 = function() {
				alert("I am " + name);
			}
		}
		
		// 类方法/静态方法 用类用调用 ，不能用实例调用
		People.fn2 = function() {
			alert("I am fn2");
		}
		
		// 原型方法，用实例调用
		People.prototype.fn3 = function() {
			alert("I am prototype fn3");
		}
		
		jQuery(function() {
			$("#btn1").click(function() {
				var p = new People("小王");
				p.fn1();
				People.fn2();
				p.fn3();
			});
			
			$("#btn2").click(function() {
				A2.prototype = new A1();
				var ia2 = new A2();
				ia2.fn1(); // A2::fn1重写了 A2::fn1
				ia2.fn2();
				
				var ia1 = new A1();
				ia1.fn1.call(ia2); // 调用 A1::fn1
				ia1.fn1(); // A1::fn1
			});
			
			$("#btn3").click(function() {
				var p = new People("tom");
				delete p.name;
				alert(p.name);
			});
		});
		
		function A1() {
			this.fn1 = function() {
				alert("A1::fn1");
			}
		}
		
		function A2() {
			/*
			 * 重写
			 * 没有这个函数，会调用A1的fn1()
			 */
			this.fn1 = function() {
				alert("A2::fn1");
			}
			
			this.fn2 = function() {
				alert("A2::fn2");
			}
		}
		
		
		
	</script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="JS面向对象" />
    <br><br>
    <input type="button" id="btn2" value="prototype" />
    <br><br>
    <input type="button" id="btn3" value="delete" />
  </body>
</html>
