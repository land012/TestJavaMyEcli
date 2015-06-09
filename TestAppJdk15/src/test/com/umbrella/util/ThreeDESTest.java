package test.com.umbrella.util;

import org.junit.Test;

import com.umbrella.util.ThreeDES;

public class ThreeDESTest {
	@Test
	public void test1() {
		String value = "12345675";
		String key = "123456789012345678901234";
		ThreeDES.encode(value, key);
	}
}
