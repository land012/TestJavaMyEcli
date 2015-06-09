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
		 * 当前的ClassLoader
		 */
//		ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
//		System.out.println(cl.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
		/**
		 * 扩展类加载器
		 */
//		ClassLoader cl2 = cl.getParent();
//		System.out.println(cl2.getClass().getCanonicalName()); // sun.misc.Launcher.ExtClassLoader
		/**
		 * Bootstrap 加载器
		 */
//		ClassLoader cl3 = cl2.getParent();
//		if(cl3 == null) {
//			System.out.println("cl3 is null"); // cl3 is null
//		} else {
//			System.out.println(cl3.getClass().getCanonicalName());
//		}
		
		
		/**
		 * 获取当前的类加载器
		 */
//		ClassLoader cl4 = ClassLoader.getSystemClassLoader();
//		System.out.println(cl4.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
		
		/**
		 * 自定义类加载器 URLClassLoader
		 * ------------ begin --------------
		 */
		System.out.println("自定义加载器");
		URLClassLoader urlCL = new URLClassLoader(new URL[]{new URL("file:/D:/_java/")});
		ClassLoader cl1 = urlCL.getClass().getClassLoader();
		if(cl1==null) {
			System.out.println("自定义加载器的加载器是 BootstrapLoader"); // 执行这句
		} else {
			System.out.println("自定义加载器的加载器是 " + cl1.getClass().getCanonicalName());
		}
		
//		// 自定义类加载器的父类加载器 sun.misc.Launcher.AppClassLoader
//		System.out.println(urlCL.getParent().getClass().getCanonicalName());
		
		System.out.println("加载类 HelloWorld");
		Thread.sleep(1000);
		// 加载类时，不会执行类的静态区 static{}
		Class clazz = urlCL.loadClass("HelloWorld");
		Class clazz2 = urlCL.loadClass("com.umbrella.vo.User");
		
		/*
		 * HelloWorld 的加载器是 java.net.URLClassLoader
		 * 因为 HelloWorld 不在工程中
		 */
		System.out.println(clazz.getClassLoader().getClass().getCanonicalName());
		/*
		 * com.umbrella.vo.User 的加载器是 sun.misc.Launcher.AppClassLoader
		 * 因为 User 在工程中，由父类加载器加载
		 */
		System.out.println(clazz2.getClassLoader().getClass().getCanonicalName());

//		/**
//		 * true 加载静态区 static{}
//		 * Class.forName() 默认加载静态区
//		 */
//		Class clazz = Class.forName("HelloWorld", true, urlCL);

		
//		System.out.println("实例化 HelloWorld");
//		Thread.sleep(1000);
//		Object obj1 = clazz.newInstance();
//		
//		System.out.println("加载方法sayHello");
//		Thread.sleep(1000);
//		Method m1 = clazz.getMethod("sayHello");
//		
//		System.out.println("执行方法 sayHello");
//		Thread.sleep(1000);
//		m1.invoke(obj1);
//		urlCL.close();
		/**
		 * 自定义类加载器 URLClassLoader
		 * ------------ end --------------
		 */

		/**
		 * BootstrapLoadr 加载的类
		 */
//		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//		for(URL url : urls) {
//			System.out.println(url.toExternalForm());
//		}

		/*
		 * Launcher.class实例 的loader是 BootstrapLoader
		 */
//		ClassLoader cl1 = sun.misc.Launcher.getLauncher().getClass().getClassLoader();
//		if(null == cl1) {
//			System.out.println("cl1 is null"); // 执行这句，说明 Launcher.class 的加载器是 BootstrapLoader
//		} else {
//			System.out.println(cl1.getClass().getCanonicalName());
//		}

		/*
		 * Launcher 的 getClassLoader方法
		 * 系统类加载器
		 */
//		ClassLoader cl2 = sun.misc.Launcher.getLauncher().getClassLoader();
//		if(null == cl2) {
//			System.out.println("cl2 is null");
//		} else {
//			System.out.println(cl2.getClass().getCanonicalName()); // sun.misc.Launcher.AppClassLoader
//		}

		/**
		 * 线程上下文加载器
		 * sun.misc.Launcher.AppClassLoader
		 */
//		ClassLoader cl3 = Thread.currentThread().getContextClassLoader();
//		System.out.println(cl3.getClass().getCanonicalName());
		
		// 显示类物理路
//		// jar:file:/D:/ProgramDev/Java/jdk1.7.0_60/jre/lib/rt.jar!/java/lang/String.class
//		System.out.println(ClassLoader.getSystemResource("java/lang/String.class").toExternalForm());
//		// jar:file:/D:/_c_ecli_jee/TestApp/lib/log4j-1.2.17.jar!/org/apache/log4j/Logger.class
//		System.out.println(ClassLoader.getSystemResource("org/apache/log4j/Logger.class").toExternalForm());
//		// file:/D:/_c_ecli_jee/TestApp/bin/com/umbrella/java/lang/ClassLoaderDemo.class
//		System.out.println(ClassLoader.getSystemResource("com/umbrella/java/lang/ClassLoaderDemo.class").toExternalForm());
	}
	
}

/**
 * 会生成另外一个类文件
 * @author 大洲
 *
 */
class ClassLoaderDemo2 {
	
}
