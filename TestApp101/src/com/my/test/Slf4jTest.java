package com.my.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.base.BaseTest;

public class Slf4jTest extends BaseTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// ∑¥…‰
//		info.info(Slf4jTest.class.getCanonicalName());
//		Slf4jTest slf4j = new Slf4jTest();
//		slf4j.fn1();
		
		/*
		try {
			Class<Slf4jTest> c = (Class<Slf4jTest>)Class.forName(Slf4jTest.class.getClass().getName());
			Slf4jTest slf4j = (Slf4jTest)c.newInstance();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		Logger log = LoggerFactory.getLogger(Slf4jTest.class);
		log.info("Hello World!");      // Hello World!
		log.debug("Hello,{}!", "Tom"); //
		log.info("Hello,{}!", "Jim");  // Hello,Jim!
	}
	
	public void fn1() {
		info.info("This is fn1() !");
	}

}
