package com.umbrella.test.objref;

import org.apache.log4j.Logger;

public class User {
	
	private static Logger log = Logger.getLogger(User.class);
	
	private int id;

	public int getId() {
		log.info("id=" + this.id);
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
