/*
 * ���ܺ�Ľ����������Ҫ�ļ��ܴ�������һ�����ڽ��ܵĶ��󣬼��ܴ�����������е�һ������
 * ȱ�㣺
 *     ֻ�õ����ܺ�Ĵ�����Կ �޷�����
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
