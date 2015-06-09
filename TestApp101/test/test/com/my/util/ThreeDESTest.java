package test.com.my.util;

import org.junit.Test;

import com.my.util.crypto.ThreeDES;

public class ThreeDESTest {
	@Test
	public void test1() {
		String value = "1245674878";
		String key = "12345678901234567890";
		System.out.println(ThreeDES.threeDESencode(value, key));
	}
}
