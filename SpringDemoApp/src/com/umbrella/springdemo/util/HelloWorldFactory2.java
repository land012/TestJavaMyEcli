package com.umbrella.springdemo.util;

import com.umbrella.springdemo.controller.HelloWorldController;

/**
 * Instantiation ʵ����������
 * @author ����
 *
 */
public class HelloWorldFactory2 {
	public HelloWorldController createInstance() {
		return new HelloWorldController();
	}
}
