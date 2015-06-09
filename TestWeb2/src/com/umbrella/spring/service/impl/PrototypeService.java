package com.umbrella.spring.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeService {
	public String fn1() {
		return "this is fn1";
	}
}
