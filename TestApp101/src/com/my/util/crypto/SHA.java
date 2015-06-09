package com.my.util.crypto;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    public static String getKeyedDigest(String src){
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
	        md.update(src.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
    }

    public static void main(String[] a) throws Exception{
    	System.out.println(SHA.getKeyedDigest("5b29c1af4c8f030c"));;
    }
}

