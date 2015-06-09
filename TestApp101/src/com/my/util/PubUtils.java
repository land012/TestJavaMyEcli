package com.my.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.my.vo.Human;
import com.my.vo.Student;

public class PubUtils {
	
	/**
	 * 获取当前类及其所有父类
	 * @param <T1>
	 * @param <T1>
	 * @param t
	 * @return
	 */
	public static List<Class> getClasses(Class t) {
		List<Class> list = new ArrayList<Class>();
		list.add(t);
		Class clazz = t.getSuperclass();
		while(!clazz.equals(Object.class)) {
			list.add(clazz);
			clazz = clazz.getSuperclass();
		}
		return list;
	}
	
//	public static <T> void printFieldValues(T t) {
//		List<Class> list = getClasses(t.getClass());
//		for(Class clazz : list) {
//			Field[] fields = clazz.getDeclaredFields();
//		}
//	}
	
	public static <T> void printObj(T t) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<Class> list = getClasses(t.getClass());
		StringBuffer sb = new StringBuffer();
		for(Class clazz : list) {
			Field[] fieldArr = clazz.getDeclaredFields();
			for(Field f : fieldArr) {
				sb.append(f.getName() + "=" + BeanUtils.getProperty(t, f.getName()) + "&");
			}
		}
		String rs = sb.toString();
		if(StringUtils.isNotEmpty(rs)) {
			System.out.println(StringUtils.substring(rs, 0, rs.length()-1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("tom");
		s1.setClasses(1);
		s1.setCourse("Chinese");
		
//		List<Class> list = getClasses(s1.getClass());
//		for(Class s : list) {
//			System.out.println(s.getCanonicalName());
//		}
		
		try {
			printObj(s1);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
