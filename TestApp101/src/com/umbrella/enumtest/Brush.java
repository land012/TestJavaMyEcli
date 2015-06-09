package com.umbrella.enumtest;

import org.apache.log4j.Logger;

public class Brush {
	
	private static Logger log = Logger.getLogger(Brush.class);
	
	// ������ɫ
	ColorDemo color;
	
	public Brush(ColorDemo color) {
		this.color = color;
	}
	
	/**
	 * ����
	 */
	public void line() {
		log.info("a " + color.name() + " line");
	}
}
