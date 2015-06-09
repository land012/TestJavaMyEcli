package com.umbrella.java.lang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {
	
//	static {
//		System.out.println("this is ClassLoaderDemo static{}");
//	}

	public static void main(String[] args) throws Exception {
		/**
		 * ��ǰ��ClassLoader
		 */
//		ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
//		System.out.println(cl.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
		/**
		 * ��չ�������
		 */
//		ClassLoader cl2 = cl.getParent();
//		System.out.println(cl2.getClass().getCanonicalName()); // sun.misc.Launcher.ExtClassLoader
		/**
		 * Bootstrap ������
		 */
//		ClassLoader cl3 = cl2.getParent();
//		if(cl3 == null) {
//			System.out.println("cl3 is null"); // cl3 is null
//		} else {
//			System.out.println(cl3.getClass().getCanonicalName());
//		}
		
		
		/**
		 * ��ȡ��ǰ���������
		 */
//		ClassLoader cl4 = ClassLoader.getSystemClassLoader();
//		System.out.println(cl4.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
		
		/**
		 * �Զ���������� URLClassLoader
		 * ------------ begin --------------
		 */
		System.out.println("�Զ��������");
		URLClassLoader urlCL = new URLClassLoader(new URL[]{new URL("file:/D:/_java/")});
		ClassLoader cl1 = urlCL.getClass().getClassLoader();
		if(cl1==null) {
			System.out.println("�Զ���������ļ������� BootstrapLoader"); // ִ�����
		} else {
			System.out.println("�Զ���������ļ������� " + cl1.getClass().getCanonicalName());
		}
		
//		// �Զ�����������ĸ�������� sun.misc.Launcher.AppClassLoader
//		System.out.println(urlCL.getParent().getClass().getCanonicalName());
		
		System.out.println("������ HelloWorld");
		Thread.sleep(1000);
		// ������ʱ������ִ����ľ�̬�� static{}
		Class clazz = urlCL.loadClass("HelloWorld");
		Class clazz2 = urlCL.loadClass("com.umbrella.vo.User");
		
		/*
		 * HelloWorld �ļ������� java.net.URLClassLoader
		 * ��Ϊ HelloWorld ���ڹ�����
		 */
		System.out.println(clazz.getClassLoader().getClass().getCanonicalName());
		/*
		 * com.umbrella.vo.User �ļ������� sun.misc.Launcher.AppClassLoader
		 * ��Ϊ User �ڹ����У��ɸ������������
		 */
		System.out.println(clazz2.getClassLoader().getClass().getCanonicalName());

//		/**
//		 * true ���ؾ�̬�� static{}
//		 * Class.forName() Ĭ�ϼ��ؾ�̬��
//		 */
//		Class clazz = Class.forName("HelloWorld", true, urlCL);

		
//		System.out.println("ʵ���� HelloWorld");
//		Thread.sleep(1000);
//		Object obj1 = clazz.newInstance();
//		
//		System.out.println("���ط���sayHello");
//		Thread.sleep(1000);
//		Method m1 = clazz.getMethod("sayHello");
//		
//		System.out.println("ִ�з��� sayHello");
//		Thread.sleep(1000);
//		m1.invoke(obj1);
//		urlCL.close();
		/**
		 * �Զ���������� URLClassLoader
		 * ------------ end --------------
		 */

		/**
		 * BootstrapLoadr ���ص���
		 */
//		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//		for(URL url : urls) {
//			System.out.println(url.toExternalForm());
//		}

		/*
		 * Launcher.classʵ�� ��loader�� BootstrapLoader
		 */
//		ClassLoader cl1 = sun.misc.Launcher.getLauncher().getClass().getClassLoader();
//		if(null == cl1) {
//			System.out.println("cl1 is null"); // ִ����䣬˵�� Launcher.class �ļ������� BootstrapLoader
//		} else {
//			System.out.println(cl1.getClass().getCanonicalName());
//		}

		/*
		 * Launcher �� getClassLoader����
		 * ϵͳ�������
		 */
//		ClassLoader cl2 = sun.misc.Launcher.getLauncher().getClassLoader();
//		if(null == cl2) {
//			System.out.println("cl2 is null");
//		} else {
//			System.out.println(cl2.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
//		}

		/**
		 * �߳������ļ�����
		 * sun.misc.Launcher.AppClassLoader
		 */
//		ClassLoader cl3 = Thread.currentThread().getContextClassLoader();
//		System.out.println(cl3.getClass().getCanonicalName());
		
		// ��ʾ������·
//		// jar:file:/D:/ProgramDev/Java/jdk1.7.0_60/jre/lib/rt.jar!/java/lang/String.class
//		System.out.println(ClassLoader.getSystemResource("java/lang/String.class").toExternalForm());
//		// jar:file:/D:/_c_ecli_jee/TestApp/lib/log4j-1.2.17.jar!/org/apache/log4j/Logger.class
//		System.out.println(ClassLoader.getSystemResource("org/apache/log4j/Logger.class").toExternalForm());
//		// file:/D:/_c_ecli_jee/TestApp/bin/com/umbrella/java/lang/ClassLoaderDemo.class
//		System.out.println(ClassLoader.getSystemResource("com/umbrella/java/lang/ClassLoaderDemo.class").toExternalForm());
	}
	
}

/**
 * ����������һ�����ļ�
 * @author ����
 *
 */
class ClassLoaderDemo2 {
	
}
