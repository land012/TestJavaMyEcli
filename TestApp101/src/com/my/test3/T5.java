package com.my.test3;
import java.util.Calendar;


public class T5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// ֵ ���� ���ڻᱻ�ı�
//		Calendar cal = Calendar.getInstance();
//		//System.out.println(cal.DAY_OF_MONTH); // 5 �ó����������ֵ
//		//System.out.println(Calendar.DAY_OF_MONTH); // 5
//		addCal(cal);
//		System.out.println(cal.getTime().toString()); // ֵ���ı���
//		
//		String str1 = new String("abc");
//		modifyStr(str1);
//		System.out.println(str1); //ֵû�б�
//		
//		Dog d = new Dog("dog1");
//		modifyDog(d);
//		System.out.println(d.name);
		
		System.out.println(System.currentTimeMillis()%10);
	}
	
	/**
	 * ֵ ��������
	 * @param cal
	 */
	public static void addCal(Calendar cal) {
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)+1);
		
		System.out.println(cal.getTime().toString());
	}
	private static void modifyStr(String str) {
		System.out.println("���������ǣ�" + str);
		str = new String("def");
		System.out.println(str);
	}
	private static void modifyDog(Dog d) {
		System.out.println("���������ǣ�" + d.name);
		// d.name = "dog3"; //�����ͻ�ı䴫������ Dog
		d = new Dog("dog2");
		System.out.println(d.name);
	}
}

class Dog{
	public String name;
	public Dog(String name) {
		this.name = name;
	}
	public Dog(Dog d) {
		this.name = d.name;
	}
}













