package com.umbrella.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		log.info("this is index");
		return "index";
	}
}
