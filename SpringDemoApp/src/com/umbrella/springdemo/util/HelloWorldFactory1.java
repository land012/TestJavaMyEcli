package com.umbrella.springdemo.util;

import com.umbrella.springdemo.controller.HelloWorldController;

/**
 * Instantiation ��̬��������
 * @author ����
 *
 */
public class HelloWorldFactory1 {
	public static HelloWorldController createInstance() {
		return new HelloWorldController();
	}
}
