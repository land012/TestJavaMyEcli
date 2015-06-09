<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>DES/ECB加解密正确用法</title>
    
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
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/mode-ecb-min.js"></script>
	
	<!--  IE10 不再兼容 Uint8ClampedArray 
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/lib-typedarrays.js"></script>
	-->
	<!--
	<script type="text/javascript" src="js/cryptojs-3.1.2/components/format-hex.js"></script>
	-->

	<script type="text/javascript">
		var myDES = function() {
			
		};
	
		myDES.encrypt = function(msg, key) {
			var keyHex = CryptoJS.enc.Utf8.parse(key); // wordArray
			//alert(keyHex);
			// keyHex原文
			//var key_p = CryptoJS.enc.Utf8.stringify(keyHex);
			//alert(key_p);
			var enres = CryptoJS.DES.encrypt(msg, keyHex, {
				mode : CryptoJS.mode.ECB,
				padding : CryptoJS.pad.Pkcs7
			});
			// 此处的 key 就是上面的 keyHex
			//alert(enres.key);
			
			// 下面两种写法一样
			//return enres.ciphertext.toString();
			return CryptoJS.enc.Base64.parse(enres.toString()).toString();
		};
		
		myDES.decrypt = function(ciphertext, key) {
			var keyHex = CryptoJS.enc.Utf8.parse(key);
			
			var words = CryptoJS.enc.Hex.parse(ciphertext);
			//var base64String = CryptoJS.enc.Base64.stringify(words);
			
			var deres = CryptoJS.DES.decrypt(
				{ ciphertext : words },
				//base64String,
				keyHex,
				{
					mode: CryptoJS.mode.ECB,
					padding: CryptoJS.pad.Pkcs7
				});
			
			return deres.toString(CryptoJS.enc.Utf8);
		};
		
		jQuery(function() {
			$("#btn1").click(function() {
				var key = $(":text[name=key]").val();
				var message = $(":text[name=message]").val();
				
				var enres = myDES.encrypt(message, key);
				
				$("#span_enres").html(enres);
				
				//var ciphertext = enres.ciphertext.toString();
				//$("#span_enres").html(ciphertext);
				
				//var enrestext = enres.toString();
				//$("#span_enres_text").html(enrestext);
				
				//var txt1 = CryptoJS.enc.Base64.parse(enrestext).toString(); // ciphertext
				//$("#span_txt1").html(txt1);
				
				// 解密
				var deres = myDES.decrypt(enres, key);
				$("#span_deres").html(deres);
				
				//var words = CryptoJS.enc.Hex.parse(ciphertext);
				//var base64 = CryptoJS.enc.Base64.stringify(words)
				//alert(words);
				//alert(base64);
				//var words  = CryptoJS.enc.Base64.parse(enrestext); // 密文WordArray
				//var base64 = CryptoJS.enc.Base64.stringify(words);
				//alert(words + "-" + base64);
			});
		});
	</script>
  </head>
  
  <body>
    <table>
    	<tr><td colspan="2">DES/ECB加解密正确用法</td></tr>
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
    		<td>cihpertext</td>
    		<td><span id="span_enres"></span></td>
    	</tr>
    	<tr>
    		<td>encrypt_text</td>
    		<td><span id="span_enres_text"></span></td>
    	</tr>
    	<tr>
    		<td>CryptoJS.enc.Base64.parse</td>
    		<td><span id="span_txt1"></span></td>
    	</tr>
    	<tr>
    		<td>encrypt_text</td>
    		<td><span id="span_deres"></span></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="button" id="btn1" value="生成" /></td>
    	</tr>
    </table>
  </body>
</html>
