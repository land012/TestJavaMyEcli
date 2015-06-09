<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>JS DES加密3</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	
	<script type="text/javascript" src="js/cryptojs-3.1.2/tripledes.js"></script>
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/mode-ecb-min.js"></script>
	<script type="text/javascript" src="js/cryptojs-3.1.2/myDES3.js"></script>
	<script type="text/javascript">
		jQuery(function() {
			$("#btn1").click(function() {
				var key = $(":text[name=key]").val();
				var message = $(":text[name=message]").val();
				
				var des = new myDES1();
				var enres = des.encrypt(message, key);
				var deres = des.decrypt(enres.toString(), key);
				
				var ciphertext = enres.ciphertext.toString();
				
				$("#span_enres").html(ciphertext);
				$("#span_deres").html(deres);
			});
			
			$("#btn2").click(function() {
				alert(myDES2.encrypt("abc", "12345678"));
			});
		});
	</script>
  </head>
  
  <body>
    <table>
    	<tr><td>DES 正确的用法 1</td></tr>
    	<tr><td>加密类型</td><td>DES/ECB</td></tr>
    	<tr>
    		<td>密钥</td>
    		<td><input type="text" name="key" value="12345678" /></td>
    	</tr>
    	<tr>
    		<td>源信息</td>
    		<td><input type="text" name="message" value="abc" /></td>
    	</tr>
    	<tr>
    		<td>加密结果</td>
    		<td><span id="span_enres"></span></td>
    	</tr>
    	<tr>
    		<td>解密结果</td>
    		<td><span id="span_deres"></span></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="button" id="btn1" value="生成" /></td>
    	</tr>
    </table>
  </body>
</html>
