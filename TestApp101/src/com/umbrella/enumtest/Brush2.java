package com.umbrella.enumtest;

import org.apache.log4j.Logger;

public class Brush2 {
	
	private static Logger log = Logger.getLogger(Brush2.class);
	
	// ������ɫ
	ColorDemo2 color;
	
	public Brush2(ColorDemo2 color) {
		this.color = color;
	}
	
	/**
	 * ����
	 */
	public void line() {
		log.info("a " + color.getValue() + " line");
	}
}
