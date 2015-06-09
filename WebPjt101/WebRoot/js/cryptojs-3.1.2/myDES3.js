/*
 * 加密后的结果，不是想要的加密串，而是一个用于解密的对象，加密串是这个对象中的一个属性
 * 缺点：
 *     只拿到加密后的串和密钥 无法解密
 * 
 */
var myDES1 = function() {
	
	this.encrypt = function(msg, key) {
		var keyHex = CryptoJS.enc.Utf8.parse(key);
		
		var enres = CryptoJS.DES.encrypt(msg, keyHex, {
			mode : CryptoJS.mode.ECB,
			padding : CryptoJS.pad.Pkcs7
		});
		return enres;
	};

	this.decrypt = function(ciphertext, key) {
		var keyHex = CryptoJS.enc.Utf8.parse(key);
		
		var deres = CryptoJS.DES.decrypt(
			{ ciphertext : CryptoJS.enc.Base64.parse(ciphertext) },
			keyHex,
			{
				mode: CryptoJS.mode.ECB,
				padding: CryptoJS.pad.Pkcs7
			});
		
		return deres.toString(CryptoJS.enc.Utf8);
	};
};
