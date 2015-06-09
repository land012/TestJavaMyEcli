package com.umbrella.memcached.spy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.umbrella.memcached.entity.User;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionObserver;
import net.spy.memcached.MemcachedClient;
/**
 * spymemcached客户端
 * @author asdf
 *
 */
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	private static final String K1 = "k1";
	private static final String K2 = "k2";
	private static final String K3 = "k3";
	private static final String K4 = "k4";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MemcachedClient client = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			
			// k1
			client.set(K1, 0, "v1");
			System.out.println(client.get(K1));
			
			// k2
			User u1 = new User();
			u1.setName("tom");
			u1.setAge(18);
			client.set(K2, 0, u1);
			User u1b = (User)client.get(K2);
			System.out.println(u1b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		// memcached结点地址，多个以空格隔开
		String hosts = "127.0.0.1:11211 127.0.0.1:11212";
		try {
			MemcachedClient client = new MemcachedClient(AddrUtil.getAddresses(hosts));
			client.addObserver(new ConnectionObserver() {
					@Override
					public void connectionEstablished(SocketAddress arg0, int arg1) {
						log.info("established:" + arg0);
					}
	
					@Override
					public void connectionLost(SocketAddress arg0) {
						log.info("lost:" + arg0);
					}
				});
			// k1
			client.set(K1, 0, "v11");
			log.info(K1 + "=" + client.get(K1));
			
			// k3
			Future<Object> f1 = client.asyncGet(K3);
			try {
				log.info(K3 + "=" + f1.get(3, TimeUnit.SECONDS));
			} catch(Exception e) {
				f1.cancel(false);
				log.info(K3 + " is null");
			}
			
			// k4
			client.set(K4, 0, "v4");
			log.info(K4 + "=" + client.get(K4));
//			client.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
