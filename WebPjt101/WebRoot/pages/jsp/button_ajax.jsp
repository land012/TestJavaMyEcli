<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>button_ajax</title>
    
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
			$("#btn1").click(function() {
				ajatx1();
			});
			$("#btn2").click(function() {
				ajatx1();
			});
			
			$("#form1").submit(function() {
				if(confirm("确定要提交么")) {
					//alert("函数名写错了");
					return true;
				}
				return false;
			});
		});
		
		function ajatx1() {
			$.ajax({
				type : "POST",
				cache : false,
				dataType : "html",
				url : "test1_test2.do",
				data : { "k1" : "v1" },
				success : function(data) {
					$("#txt1").val(data);
				}
			});
		}
		
		function chkform() {
			return true;
			if(confirm('确定要提交么？')) {
				return true;
			}
			return false;
		}
	</script>
  </head>
  
  <body>
  	<input type="text" id="txt1" />
  	<br/>
    <input type="button" id="btn1" value="I am input:button" />
    <br/>
    <button id="btn2">I am &lt;button&gt;</button>
    <hr />
    <div>
    	标签 &lt;button&gt; 相当于 input:submit，按下时，会提交 form，该提交操作会被 $(form).sumbit() 和 onsubmit 拦截到
    </div>
    <form id="form1" action="" method="post">
    	<button>I am &lt;button&gt;</button>
    </form>
    
  </body>
</html>
