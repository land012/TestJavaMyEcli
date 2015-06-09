package com.umbrella.memcached.danga;

import java.util.List;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.umbrella.memcached.Constants;
/**
 * 读取 memcached 的数据
 * @author asdf
 *
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String poolName = "bbb";
		
		String[] addrs = { "127.0.0.1:11211" };
		Integer[] weights = { 3 };
		SockIOPool pool = SockIOPool.getInstance(poolName);
		pool.setServers(addrs);
		pool.setWeights(weights);
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(200);
		pool.setMaxIdle(1000*30*30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.setSocketConnectTO(0);
		pool.initialize();
		
		/**
		 * set时的poolName=p1
		 * get时的 poolName=p2
		 * 对于同一key，一样可以取得到 value
		 */
		MemCachedClient mcc = new MemCachedClient(poolName);
		
		String str1 = (String)mcc.get(Constants.K1);
		System.out.println(Constants.K1 + "=" + str1);
		
//		Object o2 = mcc.get("test2");
//		if(o2==null) {
//			System.out.println("test2 is null!");
//		} else {
//			System.out.println("test2=" + o2);
//		}
//		
//		System.out.println("test3=" + (String)mcc.get("test3"));
//		System.out.println("test4=" + (String)mcc.get("test4"));
		
		List<String> list1 = (List<String>)mcc.get(Constants.K6);
		System.out.println(list1.size());
		for(String s : list1) {
			System.out.println(s);
		}
		
		synchronized(Main2.class) {
			try {
				Main2.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
