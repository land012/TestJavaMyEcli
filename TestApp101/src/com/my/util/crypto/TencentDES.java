package com.my.util.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.SecureRandom;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;


/**
 * ��ѶQQ�ƶ�֧��ר��
 * DES���ܵģ��ļ��й�����������,���ܡ�����
 */
public class TencentDES {
  private String Algorithm = "DES";
  private KeyGenerator keygen;
  private SecretKey deskey;
  private Cipher c;
  private byte[] cipherByte;


  /**
   * ��ʼ�� DES ʵ��
   */
  public TencentDES() {
    init();
  }

  public void init() {
    Security.addProvider(new com.sun.crypto.provider.SunJCE());
    try {
      keygen = KeyGenerator.getInstance(Algorithm);
      deskey = keygen.generateKey();
      c = Cipher.getInstance(Algorithm);
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace();
    } catch (NoSuchPaddingException ex) {
      ex.printStackTrace();
    }
  }


  /**
   * �� String ���м���
   * @param str Ҫ���ܵ�����
   * @return ���ؼ��ܺ�� byte ����
   */
  public byte[] createEncryptor(String str) {
    try {
      c.init(Cipher.ENCRYPT_MODE, deskey);
      cipherByte = c.doFinal(str.getBytes());
    } catch (java.security.InvalidKeyException ex) {
      ex.printStackTrace();
    } catch (javax.crypto.BadPaddingException ex) {
      ex.printStackTrace();
    } catch (javax.crypto.IllegalBlockSizeException ex) {
      ex.printStackTrace();
    }
    return cipherByte;
  }


  /**
   * �� Byte ������н���
   * @param buff Ҫ���ܵ�����
   * @return ���ؼ��ܺ�� String
   */
  public String createDecryptor(byte[] buff) {
    try {
      c.init(Cipher.DECRYPT_MODE, deskey);
      cipherByte = c.doFinal(buff);
    } catch (java.security.InvalidKeyException ex) {
      ex.printStackTrace();
    } catch (javax.crypto.BadPaddingException ex) {
      ex.printStackTrace();
    } catch (javax.crypto.IllegalBlockSizeException ex) {
      ex.printStackTrace();
    }
    return (new String(cipherByte));
  }


  /**
   * ��֪��Կ������¼���
   */
  public static String encode(String str, String key) throws Exception {

	SecureRandom sr = new SecureRandom();
//    byte[] rawKey = (new sun.misc.BASE64Decoder()).decodeBuffer(key);//Base64.decode(key);
//    DESKeySpec dks = new DESKeySpec(rawKey);
	 DESKeySpec dks = new DESKeySpec(key.getBytes());
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(dks);

    javax.crypto.Cipher cipher = Cipher.getInstance("DES");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);

    byte data[] = str.getBytes("UTF8");
    byte encryptedData[] = cipher.doFinal(data);
	return ((new sun.misc.BASE64Encoder()).encodeBuffer(encryptedData)).replaceAll("\r\n","");

  }


  /**
   * ��֪��Կ������½���
   */
  public static String decode(String str, String key) throws Exception {
    SecureRandom sr = new SecureRandom();
     //  byte[] rawKey = (new sun.misc.BASE64Decoder()).decodeBuffer(key);//Base64.decode(key);
    //DESKeySpec dks = new DESKeySpec(rawKey);
    DESKeySpec dks = new DESKeySpec(key.getBytes());
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(dks);
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
    byte encryptedData[] = (new sun.misc.BASE64Decoder()).decodeBuffer(str);//Base64.decode(str);
   
    byte decryptedData[] = cipher.doFinal(encryptedData);
    return new String(decryptedData, "UTF8");
  }

}
