package com.umbrella.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
	private static Map<String, Flyweight> pool = new ConcurrentHashMap<String, Flyweight>();
	
	private FlyweightFactory() { }
	
	public static FlyweightFactory getInstance() {
		return FlyweightFactoryHolder.INSTANCE;
	}
	
	private static class FlyweightFactoryHolder {
		private static final FlyweightFactory INSTANCE = new FlyweightFactory();
	}
	
	public Flyweight getFlyweight(String key) {
		Flyweight res = pool.get(key);
		if(res == null) {
			res = new ConcreteFlyweight(key);
			pool.put(key, res);
		}
		return res;
	}
}
