package com.my.util.crypto;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

/**
 * DES����
 * 8���ֽ���Կ
 * @author gan
 * 
 */
public class CipherUtil {
	
	public static void main(String [] args) throws Exception{

//		System.out.println(cipherUtil.decryptData("D94e1496f7d09ba02d28f7cead107e796a00ce99892ce2cb", "123456789"));
//		System.out.println(cipherUtil.decryptData("d94e1496f7d09ba02d28f7cead107e796a00ce99892ce2cb", "123456789"));
		//System.out.println(SHA.getKeyedDigest(cipherUtil.decryptData("e8608907451947f29b53bf1ca12021e8c3004ddb5de9cf57", "123456789")));
		String enres = CipherUtil.encryptData("abc", "12345678");
		System.out.println(enres);
		System.out.println(CipherUtil.decryptData(enres, "12345678"));
		
////		System.out.println(cipherUtil.encryptData("01234567890123456789", "12345678"));
//		System.out.println(cipherUtil.encryptData("123456", "12345678"));
////		System.out.println(cipherUtil.decryptData("5e995a81ade432bd", "12345678"));
		
	}

	/**
	 * ����
	 * @param encryptdata Ҫ���ܵ�����
	 * @param encryptkey  ���ܵ���Կ
	 * @return            ���ܺ�İ���
	 * @throws Exception
	 */
	public static String encryptData(String encryptdata, String encryptkey){
		try{
			DESPlus desPlus = new DESPlus(encryptkey);
			return desPlus.encrypt(encryptdata);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * ����
	 * @param decryptdata
	 *            Ҫ���ܵİ���
	 * @param decryptkey
	 *            ���ܵ���Կ
	 * @return ���ܺ������
	 * @throws Exception
	 */
	public static String decryptData(String decryptdata, String decryptkey)
			throws Exception {
		DESPlus desPlus = new DESPlus(decryptkey);
		return desPlus.decrypt(decryptdata);
	}

}
/*
 * DES ������
 */

class DESPlus {
//	private final String strDefaultKey = "speed";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;
	
	/**
	 * ָ����Կ���췽��
	 * 
	 * @param strKey
	 *            ָ������Կ
	 * @throws Exception
	 */
	public DESPlus(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strKey.getBytes());

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**
	 * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
	 * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
	 * 
	 * @param arrB
	 *            ��Ҫת����byte����
	 * @return ת������ַ���
	 * @throws Exception
	 *             �������������κ��쳣�������쳣ȫ���׳�
	 */
	public String byteArr2HexStr(byte[] arrB) throws Exception {
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
		return sb.toString();
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
	 * ��Ϊ�����ת������
	 * 
	 * @param strIn
	 *            ��Ҫת�����ַ���
	 * @return ת�����byte����
	 * @throws Exception
	 *             �������������κ��쳣�������쳣ȫ���׳�
	 * @author LiGuoQing
	 */
	public byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * �����ֽ�����
	 * 
	 * @param arrB
	 *            ����ܵ��ֽ�����
	 * @return ���ܺ���ֽ�����
	 * @throws Exception
	 */
//	public byte[] encrypt(byte[] arrB) throws Exception {
//		return encryptCipher.doFinal(arrB);
//	}

	/**
	 * �����ַ���
	 * 
	 * @param strIn
	 *            ����ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws Exception
	 */
	public String encrypt(String strIn) throws Exception {
		byte[] bytes = this.encryptCipher.doFinal(strIn.getBytes());
		return byteArr2HexStr(bytes);
//		return byteArr2HexStr(encrypt(strIn.getBytes()));
	}

	/**
	 * �����ֽ�����
	 * 
	 * @param arrB
	 *            ����ܵ��ֽ�����
	 * @return ���ܺ���ֽ�����
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * �����ַ���
	 * 
	 * @param strIn
	 *            ����ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws Exception
	 */
	public String decrypt(String strIn) throws Exception {
		byte[] bytes = hexStr2ByteArr(strIn);
		return new String(this.decryptCipher.doFinal(bytes));
	}

	/**
	 * ��ָ���ַ���������Կ����Կ������ֽ����鳤��Ϊ8λ ����8λʱ���油0������8λֻȡǰ8λ
	 * 
	 * @param arrBTmp
	 *            ���ɸ��ַ������ֽ�����
	 * @return ���ɵ���Կ
	 * @throws java.lang.Exception
	 */
	private Key getKey(byte[] arrBTmp) throws Exception {
		// ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
		byte[] arrB = new byte[8];

		// ��ԭʼ�ֽ�����ת��Ϊ8λ
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// ������Կ
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}
}
