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
		jQuery(function() {
			/*var str1 = "込込";
			alert(escape(str1));
			alert(encodeURI(str1));
			alert(encodeURIComponent(str1));*/
			
			$("#txt1").blur(function() {
				var str1 = $(this).val();
				$("#lbl1").text(escape(str1));
				$("#lbl2").text(encodeURI(str1));
				$("#lbl3").text(encodeURIComponent(str1));
			});
		});
	</script>
  </head>
  
  <body>
  	<input type="text" id="txt1" /> <br/>
  	escape():<label id="lbl1"></label> <br/>
  	encodeURI():<label id="lbl2"></label> <br/>
  	encodeURIComponent():<label id="lbl3"></label> <br/>
  	
  	<hr/>
  	
  	aa<br/>
  	escape():<script type="text/javascript">document.write(escape("aa"));</script> <br />
  	encodeURI():<script type="text/javascript">document.write(encodeURI("aa"));</script> <br />
  	encodeURIComponent():<script type="text/javascript">document.write(encodeURIComponent("aa"));</script> <br />
  	
  	<br />
  	
  	込込<br/>
  	escape():<script type="text/javascript">document.write(escape("込込"));</script> <br />
  	encodeURI():<script type="text/javascript">document.write(encodeURI("込込"));</script> <br />
  	encodeURIComponent():<script type="text/javascript">document.write(encodeURIComponent("込込"));</script> <br />
  	
  	<br />
  	
  	込込/細細<br/>
  	escape():<script type="text/javascript">document.write(escape("込込/細細"));</script> <br />
  	encodeURI():<script type="text/javascript">document.write(encodeURI("込込/細細"));</script> <br />
  	encodeURIComponent():<script type="text/javascript">document.write(encodeURIComponent("込込/細細"));</script> <br />
  </body>
</html>
