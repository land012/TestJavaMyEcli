package com.umbrella.java.lang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
/**
 * ����һ��ϵͳ����
 * @author asdf
 *
 */
public class ProcessDemo {
	
	private static Logger log = Logger.getLogger(ProcessDemo.class);
	
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe").directory(new File("D:\\"));
		try {
			Process p = pb.start();
			
			new Thread(new PrintWorker(p.getInputStream())).start();
			
			Thread.sleep(1 * 1000);
			log.info("======================================");
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write("echo %JAVA_HOME% >> aa.txt \r\n");
			bw.flush();
			
			Thread.sleep(1 * 1000);
			log.info("======================================");
			
			bw.write("chdir >> aa.txt \r\n");
			bw.write("exit \r\n"); // ��������
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// ִ�� ipconfig�����в��� /all
	@Test
	public void test1() {
		ProcessBuilder pb = new ProcessBuilder("ipconfig", "/all");
		try {
			Process p = pb.start();
			InputStream is = p.getInputStream();
			byte[] buf = new byte[1024];
			StringBuffer sb = new StringBuffer();
			int i = -1;
			while((i=is.read(buf)) != -1) {
				sb.append(new String(buf, 0, i));
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ִ��cmd����ʱ
	 * ������� Process.getInputStream()��JVM���̻߳�һֱ�������ȴ��������ֱ������ "exit \r\n"
	 */
	@Test
	public void test2() {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe").directory(new File("D:\\"));
		try {
			Process p = pb.start();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//			bw.write("chdir \r\n"); // ��ӡ��ǰĿ¼
//			bw.write("echo %JAVA_HOME% \r\n");
			// \r\n �ش�
			bw.write("echo %JAVA_HOME% >> aa.txt \r\n");
			bw.write("exit \r\n"); // ���û����䣬�ᵼ�²����߳�����
			// ����д���
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ִ����Ϻ��˳�
	 */
	@Test
	public void test3() {
		log.info("this is test3");
		ProcessBuilder pb = new ProcessBuilder("cmd.exe").directory(new File("D:\\"));
		try {
			Process p = pb.start();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write("echo %JAVA_HOME% >> aa.txt \r\n");
			bw.flush();
			
			// ȷ����д���ļ����ٹرղ����߳�
			Thread.sleep(2 * 1000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class PrintWorker implements Runnable {
		
		private InputStream is;
		
		public PrintWorker(InputStream is) {
			this.is = is;
		}

		@Override
		public void run() {
			byte[] buf = new byte[1024];
			int i = -1;
			try {
				while((i=this.is.read(buf)) != -1) {
					String temp = new String(buf, 0, i);
					log.info(temp);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
