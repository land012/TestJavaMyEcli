package test.com.umbrella.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.umbrella.util.CommonUtils;

public class CommonUtilsTest {
	
	private static final Logger log = Logger.getLogger(CommonUtilsTest.class);
	
	@Test
	public void testGetLocalIP() {
		log.info(CommonUtils.getLocalIP());
	}
}
