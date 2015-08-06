package com.umbrella.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.my.base.BaseTest;
import com.umbrella.vo.User;
/**
 * 反射
 * @author asdf
 *
 */
public class ReflectTest extends BaseTest {
	
	class Cat {
		private long id;
		private Long id2;
		private String name;
		private boolean gender;
		private Boolean gender2;
	}

	@Test
	public void test1() {
//		info.info(ReflectTest.class.getName());
		
//		// Modified 修改符
//		System.out.println("Modifier.ABSTRACT:" + Modifier.ABSTRACT);
//		System.out.println("Modifier.PUBLIC:" + Modifier.PUBLIC);
//		System.out.println("Modifier.PRIVATE:" + Modifier.PRIVATE);
//		System.out.println("Modifier.PROTECTED:" + Modifier.PROTECTED);
//		System.out.println("Modifier.FINAL:" + Modifier.FINAL);
//		System.out.println("Modifier.STATIC:" + Modifier.STATIC);
//		
//		System.out.println(Modifier.isFinal(16));
//		System.out.println(Modifier.isFinal(17)); // 包含 final 就会返回 true
//		System.out.println(Modifier.isFinal(40));
		
		// Fields
//		/**
//		 * 显示当前类声明的所有字段(不区分是 public 还是 prirvate)
//		 * 不包括父类字段
//		 */
//		System.out.println("getDeclaredFields:");
//		Field[] fs1 = User.class.getDeclaredFields();
//		System.out.println(fs1.length);
//		for(Field f : fs1) {
//			System.out.println("    " + f.getName() + "    " + f.getModifiers());
//		}
//		/**
//		 * 仅显示 当前类声明的  public 类型的字段
//		 * 包括父类的 public 字段
//		 */
//		System.out.println("getFileds:");
//		Field[] fs2 = User.class.getFields();
//		System.out.println(fs2.length);
//		for(Field f : fs2) {
//			System.out.println("    " + f.getName());
//		}
		
		// Method
//		/**
//		 * 仅显示当前类中声明的方法(不区分是 public 还是 private)
//		 * 不包括父类的方法
//		 */
//		System.out.println("getDeclaredMethods:");
//		Method[] ms1 = User.class.getDeclaredMethods();
//		System.out.println(ms1.length);
//		for(Method m : ms1) {
//			System.out.println("    " + m.getName());
//		}
//		
//		/**
//		 * 获取方法(不获取私有方法)
//		 * 包括父类的方法(当然也包括 Object的方法)
//		 */
//		System.out.println("getMethods:");
//		Method[] ms2 = User.class.getMethods();
//		System.out.println(ms2.length);
//		for(Method m : ms2) {
//			System.out.println("    " + m.getName());
//		}
	}
	
	/**
	 * 成员变量类型
	 */
	@Test
	public void test2() {
		Field[] fields = Cat.class.getDeclaredFields();
		for(Field f : fields) {
			if("boolean".equals(f.getType().getCanonicalName()) || "java.lang.Boolean".equals(f.getType().getCanonicalName())) {
				System.out.println(f.getType().toString() + " - " + f.getType().getCanonicalName());
			} else {
				System.out.println(f.getType().toString() + " , " + f.getGenericType());
			}
			
		}
	}

}
