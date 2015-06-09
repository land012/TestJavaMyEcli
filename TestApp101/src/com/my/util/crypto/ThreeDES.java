package com.my.util.crypto;

/*�ַ��� DESede(3DES) ����*/
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDES {

	// ���� �����㷨,���� DES,DESede,Blowfish DESede/ECB/PKCS7Padding
	private static final String Algorithm = "DESede/ECB/PKCS7Padding";

	// keybyteΪ������Կ������Ϊ24�ֽ�
	// srcΪ�����ܵ����ݻ�������Դ��
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try { // ������Կ
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// ����
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

	// ת����ʮ�������ַ���
	public static String byte2hex(byte[] arrB) {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString().toUpperCase();
	}

	public static String threeDESencode(String value, String key) {
		/*
		 * ���ã� �� http://www.bouncycastle.org/latest_releases.html
		 * �����ض�ӦJDK�ġ�Provider��, ��JDK1.6��Ӧbcprov-jdk16-137.jar, ����CLASSPATH����.
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
