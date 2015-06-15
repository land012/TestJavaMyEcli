package com.umbrella.deadlock;

//import org.apache.log4j.Logger;

/**
 * ����
 * @author asdf
 * ��νͬ�������ڲ�ͬ�̷߳��ʶ�һ����������
 * ��ν������ָ����ĳһ����������������ͬһʱ��ֻ�ܱ�һ���߳��õ�
 *
 */
public class DeadLockDemo2 {
	
//	private static Logger log = Logger.getLogger(DeadLockDemo2.class);

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend edward = new Friend("Edward");
		
		/**
		 * ��ν ͬ�����ǶԲ�ͬ�߳��е�ͬһ��������Ե�
		 * ��ͬ���󣬲����ڻ�����ʷ���������
		 * ���ԣ����������̶߳������ bow()����
		 * 
		 * �������߳�A �õ��� alphonse���ڲ������߳�B�õ��� edward ���ڲ���
		 * ���߳�A �� bow() ��ִ�� edward.bowBack() ����ʱ����Ҫ��ȡedward���ڲ�����
		 * ��ʱ�߳�A��Ȼ�ò���edward����
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				alphonse.bow(edward);
			}
		}).start();
		
		Thread.sleep(500);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				edward.bow(alphonse);
			}
		}).start();
	}
	
	static class Friend {
		private String name;
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		/**
		 * bower�Ϲ�
		 * @param bower
		 * 
		 */
		public synchronized void bow(Friend bower) {
			System.out.format("%s : %s has bowed to me%n", this.name, bower.getName());
//			log.info(this.name + " : " + bower.getName() + " has bowed to me");
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			bower.bowBack(this);
		}
		
		/**
		 * bower�ϻ���
		 * @param bower
		 */
		private synchronized void bowBack(Friend bower) {
			System.out.format("%s : %s has bowed back to me%n", this.name, bower.getName());
//			log.info(this.name + " : " + bower.getName() + " has bowed back to me");
		}
	}

}
