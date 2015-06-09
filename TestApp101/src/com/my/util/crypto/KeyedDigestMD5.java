package com.my.util.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyedDigestMD5 {
    
	/**
	 * 
	 * @param buffer
	 * @param key
	 * @return
	 */
	public static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            return md5.digest(key);
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 
	 * @param strSrc
	 * @param key
	 * @return
	 */
	public static String getKeyedDigest(String strSrc, String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes("UTF8"));
            
            String result="";
            byte[] temp;
            temp = md5.digest(key.getBytes("UTF8"));
    		for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
    		return result;
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 
	 * @param strSrc
	 * @param key
	 * @param charSet
	 * @return
	 */
	public static String getKeyedDigest(String strSrc, String key,String charSet) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes(charSet));
            
            String result="";
            byte[] temp;
            temp=md5.digest(key.getBytes(charSet));
    		for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
    		return result;
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String src = "123";
        String key = "12345678";
		String sign1 = KeyedDigestMD5.getKeyedDigest(src + key, "");
		String sign2 = KeyedDigestMD5.getKeyedDigest(src, key);
		
		System.out.println(sign1);
		System.out.println(sign2);
	}

}

