package com.umbrella.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * SpringMVC »Î√≈
 * @author asdf
 *
 */
@Controller
public class GreetingController {
	
	private Logger log = Logger.getLogger(GreetingController.class);
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
			Model model) {
		log.info("this is greeting");
		model.addAttribute("name", name);
		return "greeting/greeting";
	}
}
