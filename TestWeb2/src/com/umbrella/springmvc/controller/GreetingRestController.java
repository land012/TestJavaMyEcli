package com.umbrella.springmvc.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umbrella.springmvc.pojo.Greeting;
/**
 * RESTful Web Service
 * @author asdf
 * 每次访问都是同一个实例
 *
 */
@RestController
public class GreetingRestController {
	// 字符串池
	private static final String template = "Hello %s";
	// 对象第一次实例化时赋值
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting2")
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
