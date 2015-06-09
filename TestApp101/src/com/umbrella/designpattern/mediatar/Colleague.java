package com.umbrella.designpattern.mediatar;
/**
 * ͬ��
 * @author asdf
 *
 */
public abstract class Colleague {
	protected Mediatar mediatar;
	
	public Colleague(Mediatar mediatar) {
		this.mediatar = mediatar;
	}
	
	public abstract void process();
}
