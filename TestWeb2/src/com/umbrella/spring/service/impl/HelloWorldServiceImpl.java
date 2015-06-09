package com.umbrella.spring.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.umbrella.spring.service.HelloWorldService;

@Service("helloWorldService")
@Lazy
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello() {
		return "Hello World";
	}

}
