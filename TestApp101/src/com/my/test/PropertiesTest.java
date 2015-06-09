package com.my.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import com.my.base.BaseTest;
/**
 * 
 * @author asdf
 * �ײ��� hashTableʵ�֣�ֵ����Ϊnull
 *
 */
public class PropertiesTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties defaultp = new Properties();
//		defaultp.setProperty("p1", "v1");
//		defaultp.setProperty("p2", "v2");
//		defaultp.setProperty("p3", "v1");
//		defaultp.setProperty("p4", "v1");
//		// java.lang.NullPointerException
//		defaultp.put("k1", null);
		defaultp.put("k1", "");
//		// java.lang.NullPointerException
//		defaultp.setProperty("k2", null);
		
//		Properties p = new Properties(defaultp);
//		p.setProperty("k1", "v1");
//		p.put("k2", "v2");
//		info.info(p.getProperty("k1"));
//		info.info(p.get("k2"));
//		info.info(p.getProperty("k2"));
//		info.info(p.getProperty("p1")); // v1��ȡ��Ĭ���б��ֵ
//		p.setProperty("p1", "v11"); // �����޸�Ĭ��key��ֵ���������޸� ԭĬ���б��Ӧkey��ֵ
//		info.info(p.getProperty("p1")); // v11
//		info.info(defaultp.getProperty("p1")); // v1
		
		Properties p = new Properties();
		try {
			// ------------ ���� properties �ļ� begin ---------------
//			p.setProperty("sk1", "sv1");
//			p.setProperty("sk2", "sv2");
			
//			PrintWriter pw = new PrintWriter("ini/test.properties");
//			p.list(pw);
//			pw.flush(); // ����ʹ�� flush()
//			pw.close();
			
//			FileOutputStream fos = new FileOutputStream("ini/test.properties", true);
//			p.store(fos, "Here is Comments!(������ע��)");
//			fos.flush(); // ����ʹ�� flush()
//			fos.close();
			// ------------ ���� properties �ļ� end ---------------
			
			p.load(new FileInputStream("ini/test.properties"));
			info.info("k1:" + p.getProperty("k1"));
			info.info("k2:" + p.getProperty("k2"));
			info.info("k3:" + p.getProperty("k3"));
			info.info("k4:" + p.getProperty("k4"));
			info.info("sk1:" + p.getProperty("sk1"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
