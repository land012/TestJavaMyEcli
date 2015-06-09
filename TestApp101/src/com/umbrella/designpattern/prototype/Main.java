package com.umbrella.designpattern.prototype;

import org.apache.log4j.Logger;


/**
 * ԭ��ģʽ
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
			t1.setName("����ʦ");
			Student s1 = new Student();
			s1.setName("��ͬѧ");
			t1.setStudent(s1);
		
			TeacherL t2 = (TeacherL)t1.clone();
			log.info("ǳ������");
			log.info("�Ƿ񿽱��˼�����ֵ��" +t1.getName().equals(t2.getName()));
			log.info("�Ƿ���ͬһ�ࣺ" + (t1.getClass() == t2.getClass()));
			log.info("�Ƿ���ͬһ����" + (t1 == t2));
			log.info("�Ƿ�������ͬһStudent:" + (t1.getStudent() == t2.getStudent())); // true
			log.info(t1.getStudent());
			log.info(t2.getStudent());
			
			
			TeacherD t3 = new TeacherD();
			t3.setName("����ʦ");
			Student s2 = new Student();
			s2.setName("��ͬѧ");
			t3.setStudent(s2);
			TeacherD t4 = (TeacherD)t3.clone();
			log.info("�����");
			log.info("�Ƿ񿽱��˼�����ֵ��" +t3.getName().equals(t4.getName()));
			log.info("�Ƿ���ͬһ�ࣺ" + (t3.getClass() == t4.getClass()));
			log.info("�Ƿ���ͬһ����" + (t3 == t4));
			log.info("�Ƿ�������ͬһStudent:" + (t3.getStudent() == t4.getStudent()));      // false
			log.info("�Ƿ�������ͬһStudent:" + (t3.getStudent().equals(t4.getStudent()))); // false
//			log.info("�Ƿ�������ͬһStudent:" + (t3.getStudent().toString().equals(t4.getStudent().toString()))); // true
			log.info(t3.getStudent());
			log.info(t4.getStudent());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
