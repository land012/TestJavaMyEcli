package com.umbrella.springdemo.util;

import com.umbrella.springdemo.controller.HelloWorldController;

/**
 * Instantiation 实例工厂方法
 * @author 大洲
 *
 */
public class HelloWorldFactory2 {
	public HelloWorldController createInstance() {
		return new HelloWorldController();
	}
}
