package test.com.umbrella.zk;

import com.umbrella.util.CommonUtils;

/**
 * ≤‚ ‘”√¥˙¬Î
 * @author asdf
 *
 */
public class TestUtils {
	
	/**
	 * 
	 * @return
	 */
	public static String getZkHost() {
		StringBuffer sb = new StringBuffer();
		sb.append(CommonUtils.getLocalIP()).append(":2181,")
			.append(CommonUtils.getLocalIP()).append(":2182");
		return sb.toString();
	}
}
