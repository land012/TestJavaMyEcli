package com.umbrella.vo;

import org.apache.log4j.Logger;

public class User {
	
	private static Logger log = Logger.getLogger(User.class);
	
	private int id;
	private String name;
	
	public int getId() {
		log.info("id=" + this.id);
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		log.info("GC 前执行");
		StackTraceElement ste = new Throwable().getStackTrace()[0];
		System.out.println(ste.getClassName() + "." + ste.getMethodName() + " - GC 前执行");
	}
}
