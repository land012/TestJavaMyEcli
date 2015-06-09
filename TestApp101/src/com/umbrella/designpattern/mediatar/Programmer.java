package com.umbrella.designpattern.mediatar;

public class Programmer extends Colleague {

	public Programmer(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("程序员完成了！");
		this.mediatar.change(this);
	}
	
}
