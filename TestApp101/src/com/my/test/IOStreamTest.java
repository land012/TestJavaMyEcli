package com.my.test;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.my.base.BaseTest;

public class IOStreamTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
//			FileInputStream fis = new FileInputStream(new File("files/file1.txt"));
//			byte[] buf = new byte[1024];
//			StringBuffer sb = new StringBuffer(); 
//			int i;
//			while((i = fis.read(buf)) != -1) {
//				System.out.println(buf);
//				sb.append(new String(buf, 0, i, "gbk"));
//			}
////			System.out.println(sb.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		String str1 = "ÄãºÃ";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));
		try {
			bw.write(str1);
			bw.flush();
			System.out.println(baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
