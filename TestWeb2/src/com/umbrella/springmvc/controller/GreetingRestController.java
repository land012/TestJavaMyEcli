package com.umbrella.springmvc.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umbrella.springmvc.pojo.Greeting;
/**
 * RESTful Web Service
 * @author asdf
 * ÿ�η��ʶ���ͬһ��ʵ��
 *
 */
@RestController
public class GreetingRestController {
	// �ַ�����
	private static final String template = "Hello %s";
	// �����һ��ʵ����ʱ��ֵ
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting2")
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
