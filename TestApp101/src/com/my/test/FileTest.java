package com.my.test;

import java.io.File;
import java.io.IOException;

import com.my.base.BaseTest;

public class FileTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		File f = new File("temp/新建文本文档.txt");
//		info.info(f.getAbsolutePath());
//		info.info(f.getName());
//		try {
//			info.info(f.getCanonicalPath());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		File f = new File("D:\\temp1\\temp2\\temp3");
//		info.info(f.getParent());            // D:\temp1\temp2
//		info.info(f.getPath());              // D:\temp1\temp2\temp3
//		info.info(f.getAbsolutePath());      // D:\temp1\temp2\temp3
//		try {
//			info.info(f.getCanonicalPath()); // D:\temp1\temp2\temp3
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		File f2 = new File("..\\temp1\\temp2\\temp3");
//		if(!f2.exists()) {
//			info.info("路径不存在！");
//		}
//		info.info(f2.getParent());            // temp1\temp2
//		info.info(f2.getPath());              // temp1\temp2\temp3
//		info.info(f2.getAbsolutePath());      // D:\workspace\MyTest\temp1\temp2\temp3
//		try {
//			info.info(f2.getCanonicalPath()); // D:\workspace\MyTest\temp1\temp2\temp3
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/**
		 * 系统分隔符
		 */
		System.out.println("File.pathSeparator=" + File.pathSeparator); // ;
		System.out.println("File.separator=" + File.separator);         // \
	}

}
