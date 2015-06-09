package com.umbrella.spring.controller;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umbrella.spring.service.impl.PrototypeService;
/**
 * 不能被实例化
 * @author asdf
 *
 */
@Controller("abstractHelloWorldController")
public abstract class AbstractHelloWorldController {
	
	@RequestMapping("/prototype")
	public String prototype(Model model) {
		PrototypeService service = getPrototypeService();
		System.out.println(service.fn1());
		model.addAttribute("helloworld", "Prototype");
		return "hello";
	}
	
	/**
	 * Singleton 依赖 Prototype
	 * @return
	 */
	@Lookup("prototypeService")
	public abstract PrototypeService getPrototypeService();
}
