package test.com.my.action;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class UnicodeTest {
	
	@Test
	public void test1() {
		try {
			byte[] bytearr = "Œ“".getBytes("gb2312");
			for(byte b : bytearr) {
				System.out.println(Integer.toHexString(b & 0xff));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
