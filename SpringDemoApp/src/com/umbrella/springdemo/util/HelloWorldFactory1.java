package com.umbrella.springdemo.util;

import com.umbrella.springdemo.controller.HelloWorldController;

/**
 * Instantiation 静态工厂方法
 * @author 大洲
 *
 */
public class HelloWorldFactory1 {
	public static HelloWorldController createInstance() {
		return new HelloWorldController();
	}
}
