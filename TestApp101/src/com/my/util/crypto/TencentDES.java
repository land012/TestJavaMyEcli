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
 * 腾讯QQ移动支付专用
 * DES加密的，文件中共有两个方法,加密、解密
 */
public class TencentDES {
  private String Algorithm = "DES";
  private KeyGenerator keygen;
  private SecretKey deskey;
  private Cipher c;
  private byte[] cipherByte;


  /**
   * 初始化 DES 实例
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
   * 对 String 进行加密
   * @param str 要加密的数据
   * @return 返回加密后的 byte 数组
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
   * 对 Byte 数组进行解密
   * @param buff 要解密的数据
   * @return 返回加密后的 String
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
   * 已知密钥的情况下加密
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
   * 已知密钥的情况下解密
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
