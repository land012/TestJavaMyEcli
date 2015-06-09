package com.umbrella.designpattern.prototype;

import org.apache.log4j.Logger;


/**
 * 原型模式
 * @author asdf
 *
 */
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TeacherL t1 = new TeacherL();
			t1.setName("李老师");
			Student s1 = new Student();
			s1.setName("李同学");
			t1.setStudent(s1);
		
			TeacherL t2 = (TeacherL)t1.clone();
			log.info("浅拷贝：");
			log.info("是否拷贝了简单属性值：" +t1.getName().equals(t2.getName()));
			log.info("是否是同一类：" + (t1.getClass() == t2.getClass()));
			log.info("是否是同一对象：" + (t1 == t2));
			log.info("是否引用了同一Student:" + (t1.getStudent() == t2.getStudent())); // true
			log.info(t1.getStudent());
			log.info(t2.getStudent());
			
			
			TeacherD t3 = new TeacherD();
			t3.setName("王老师");
			Student s2 = new Student();
			s2.setName("王同学");
			t3.setStudent(s2);
			TeacherD t4 = (TeacherD)t3.clone();
			log.info("深拷贝：");
			log.info("是否拷贝了简单属性值：" +t3.getName().equals(t4.getName()));
			log.info("是否是同一类：" + (t3.getClass() == t4.getClass()));
			log.info("是否是同一对象：" + (t3 == t4));
			log.info("是否引用了同一Student:" + (t3.getStudent() == t4.getStudent()));      // false
			log.info("是否引用了同一Student:" + (t3.getStudent().equals(t4.getStudent()))); // false
//			log.info("是否引用了同一Student:" + (t3.getStudent().toString().equals(t4.getStudent().toString()))); // true
			log.info(t3.getStudent());
			log.info(t4.getStudent());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
