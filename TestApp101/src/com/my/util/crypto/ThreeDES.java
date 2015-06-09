package com.my.util.crypto;

/*字符串 DESede(3DES) 加密*/
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDES {

	// 定义 加密算法,可用 DES,DESede,Blowfish DESede/ECB/PKCS7Padding
	private static final String Algorithm = "DESede/ECB/PKCS7Padding";

	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try { // 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// 转换成十六进制字符串
	public static String byte2hex(byte[] arrB) {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString().toUpperCase();
	}

	public static String threeDESencode(String value, String key) {
		/*
		 * 配置： 从 http://www.bouncycastle.org/latest_releases.html
		 * 上下载对应JDK的“Provider”, 如JDK1.6对应bcprov-jdk16-137.jar, 放入CLASSPATH即可.
		 */
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		try {
			byte[] encoded = encryptMode(key.getBytes(), value.getBytes());
			return byte2hex(encoded);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
