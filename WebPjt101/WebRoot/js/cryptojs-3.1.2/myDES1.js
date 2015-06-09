var myDES1 = function() {
	/*
	 * �ѽ����õ��ļ��ܽ������ �ŵ��м������
	 * ���������ܺͽ��ܷ����õ��� ������Ҫ�Ľ��
	 * ȱ�㣺
	 *     ���ܺͽ��ܶ������ڿͻ���
	 *     ���ֻ�õ����ܺ�Ĵ�����Կ���޷�����
	 */
	this.arr = new Array();
	
	this.put = function(key, obj) {
		this.arr[key] = obj;
	};
	
	this.get = function(key, obj) {
		return this.arr[key];
	};
	
	// ����
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
	
	// ����
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
