<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${cp }">
    
    <title>JS DES/CBC加密</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	
	
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/core.js"></script>
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/enc-base64.js"></script>
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/cipher-core.js"></script>
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/tripledes.js"></script>
	
	<script type="text/javascript">
		var myDES2 = function() { }; // 对象
	
		myDES2.encrypt = function(msg, key) {
			var keyHex = CryptoJS.enc.Utf8.parse(key);
			//var msgHex = CryptoJS.enc.Utf8.parse(msg);
			//alert(msgHex + "-" + keyHex);
			
			//var iv = CryptoJS.enc.Hex.parse(key);
			//alert(keyHex + "-" + iv);
			
			var enres = CryptoJS.DES.encrypt(msg, keyHex, {
				//mode : CryptoJS.mode.CBC,     // 默认mode: CBC
				//padding : CryptoJS.pad.Pkcs7, // 默认 pad: Pkcs7
				iv : keyHex
			});
			
			return enres.ciphertext.toString();
		};
	
		jQuery(function() {
			$("#btn1").click(function() {
				var key = $(":text[name=key]").val();
				var message = $(":text[name=message]").val();
				
				var enres = myDES2.encrypt(message, key);
				//var deres = des.decrypt(enres, key);
				//alert(deres);
				$("#span_enres").html(enres);
				//$("#span_deres").html(deres);
			});
		});
	</script>
  </head>
  
  <body>
    <table>
    	<tr><td>加密类型</td><td>DES/CBC</td></tr>
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
