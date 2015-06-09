package com.umbrella.threadlocal;

/**
 * ThreadLocal
 * @author asdf
 *
 */
public class UserUtil {
	private static ThreadLocal<User> threadLocal = new ThreadLocal<User>() {
			// �������߳�û�� set ʱ�����ص�Ĭ��ֵ
			@Override
			protected User initialValue() {
				return new User("default");
			}
		};
	
	public static User getUser() {
		return threadLocal.get();
	}
	
	public static void setUser(User u) {
		threadLocal.set(u);
	}
}
