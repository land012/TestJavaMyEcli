package com.umbrella.threadlocal;

/**
 * ThreadLocal
 * @author asdf
 *
 */
public class UserUtil {
	private static ThreadLocal<User> threadLocal = new ThreadLocal<User>() {
			// 当所在线程没有 set 时，返回的默认值
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
