package com.umbrella.memcached.danga;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.umbrella.memcached.entity.User;

import com.umbrella.memcached.Constants;

/**
 * memcached-java-client 客户端
 * @author asdf
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String poolName = "aaa"; // poolName
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
		
		MemCachedClient mcc = new MemCachedClient(poolName);
		
		mcc.set(Constants.K1, "vvv1"); // 永不超时
		
//		Date now = new Date();
//		Date expireDate = new Date(now.getTime() + 10 * 1000); // 10秒后的时间点
//		System.out.println(expireDate.getTime());
//		mcc.set(K2, "haha", expireDate); // 10秒钟后超时
		
//		/*
//		 * 并发问题？？？？
//		 */
//		Object str4 = mcc.get(K4);
//		if(null == str4) {
//			mcc.set(K4, "1");
//		} else {
//			mcc.incr(K4);
//		}
		
		/*
		 * 获取
		 */
//		String str1 = (String)mcc.get(Constants.K1);
//		System.out.println(Constants.K1 + "=" + str1);
		
//		System.out.println(K3 + "=" + (String)mcc.get(K3));
//		
//		System.out.println(K4 + "=" + (String)mcc.get(K4));
		
		/*
		 * put一个对象
		 */
//		User u1 = new User();
//		u1.setName("tom");
//		u1.setAge(19);
//		mcc.set(K5, u1);
//		User u11 = (User)mcc.get(K5);
//		System.out.println(K5 + "=" + u11);
		
		/*
		 * put 一个List
		 */
		List<String> list1 = new ArrayList<String>();
		list1.add("a1");
		list1.add("a2");
		mcc.set(Constants.K6, list1);
		
	}

}
