package com.my.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.my.base.BaseTest;
import com.my.vo.User;
/**
 * ����
 * @author asdf
 *
 */
public class ReflectTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		info.info(ReflectTest.class.getName());
		
//		// Modified �޸ķ�
//		System.out.println("Modifier.ABSTRACT:" + Modifier.ABSTRACT);
//		System.out.println("Modifier.PUBLIC:" + Modifier.PUBLIC);
//		System.out.println("Modifier.PRIVATE:" + Modifier.PRIVATE);
//		System.out.println("Modifier.PROTECTED:" + Modifier.PROTECTED);
//		System.out.println("Modifier.FINAL:" + Modifier.FINAL);
//		System.out.println("Modifier.STATIC:" + Modifier.STATIC);
//		
//		System.out.println(Modifier.isFinal(16));
//		System.out.println(Modifier.isFinal(17)); // ���� final �ͻ᷵�� true
//		System.out.println(Modifier.isFinal(40));
		
		// Fields
//		/**
//		 * ��ʾ��ǰ�������������ֶ�(�������� public ���� prirvate)
//		 * �����������ֶ�
//		 */
//		System.out.println("getDeclaredFields:");
//		Field[] fs1 = User.class.getDeclaredFields();
//		System.out.println(fs1.length);
//		for(Field f : fs1) {
//			System.out.println("    " + f.getName() + "    " + f.getModifiers());
//		}
//		/**
//		 * ����ʾ ��ǰ��������  public ���͵��ֶ�
//		 * ��������� public �ֶ�
//		 */
//		System.out.println("getFileds:");
//		Field[] fs2 = User.class.getFields();
//		System.out.println(fs2.length);
//		for(Field f : fs2) {
//			System.out.println("    " + f.getName());
//		}
		
		// Method
//		/**
//		 * ����ʾ��ǰ���������ķ���(�������� public ���� private)
//		 * ����������ķ���
//		 */
//		System.out.println("getDeclaredMethods:");
//		Method[] ms1 = User.class.getDeclaredMethods();
//		System.out.println(ms1.length);
//		for(Method m : ms1) {
//			System.out.println("    " + m.getName());
//		}
//		
//		/**
//		 * ��ȡ����(����ȡ˽�з���)
//		 * ��������ķ���(��ȻҲ���� Object�ķ���)
//		 */
//		System.out.println("getMethods:");
//		Method[] ms2 = User.class.getMethods();
//		System.out.println(ms2.length);
//		for(Method m : ms2) {
//			System.out.println("    " + m.getName());
//		}
	}

}
