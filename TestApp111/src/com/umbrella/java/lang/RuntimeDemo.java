package com.umbrella.java.lang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;
/**
 * 执行本地程序
 * @author 大洲
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Runtime.getRuntime().exec(String)
	 */
	@Test
	public void test1() {
		try {
			StringBuffer cmd = new StringBuffer("cmd /k");
			cmd.append(" ").append("chdir");
			
			
			Process p = Runtime.getRuntime().exec(cmd.toString());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行 cmd命令
	 * 切换目录并退出
	 */
	@Test
	public void test2() {
		try {
			
			String cmd = "cmd /k";
			
			Process p = Runtime.getRuntime().exec(cmd);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write("cd d:\\ \r\n");
			bw.write("chdir \r\n");
			bw.write("exit \r\n");
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test3() {
		try {
			
			String cmd = "cmd /k";
			
			Process p = Runtime.getRuntime().exec(cmd, null, new File("D:\\"));
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write("chdir >> aa.txt \r\n");
			bw.write("exit \r\n");
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
