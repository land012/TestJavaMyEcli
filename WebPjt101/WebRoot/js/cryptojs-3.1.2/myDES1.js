var myDES1 = function() {
	/*
	 * 把解密用到的加密结果对象 放到中间变量中
	 * 这样，加密和解密方法得到的 就是想要的结果
	 * 缺点：
	 *     加密和解密都必须在客户端
	 *     如果只拿到加密后的串和密钥，无法解密
	 */
	this.arr = new Array();
	
	this.put = function(key, obj) {
		this.arr[key] = obj;
	};
	
	this.get = function(key, obj) {
		return this.arr[key];
	};
	
	// 加密
	this.encrypt = function(msg, key) {
		var keyHex = CryptoJS.enc.Utf8.parse(key);
		
		var enres = CryptoJS.DES.encrypt(msg, keyHex, {
			mode : CryptoJS.mode.ECB,
			padding : CryptoJS.pad.Pkcs7
		});
		//alert(enres.key);
		//alert(enres.ciphertext.toString() + "-" + enres);
		this.put(enres.ciphertext.toString(), enres.toString());
		return enres.ciphertext.toString();
	};
	
	// 解密
	this.decrypt = function(ciphertext, key) {
		var keyHex = CryptoJS.enc.Utf8.parse(key);
		//alert(ciphertext);
		var c = this.get(ciphertext);
		//alert(c);
		/*var l_ciphertext = ciphertext;
		ciphertext = new Object();
		ciphertext.ciphertext = l_ciphertext;*/
		
		var deres = CryptoJS.DES.decrypt(
			{ ciphertext : CryptoJS.enc.Base64.parse(c) },
			keyHex,
			{
				mode: CryptoJS.mode.ECB,
				padding: CryptoJS.pad.Pkcs7
			});
		
		return deres.toString(CryptoJS.enc.Utf8);
	};
};
