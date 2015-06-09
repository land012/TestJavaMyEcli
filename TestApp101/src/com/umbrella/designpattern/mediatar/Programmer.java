package com.umbrella.designpattern.mediatar;

public class Programmer extends Colleague {

	public Programmer(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("����Ա����ˣ�");
		this.mediatar.change(this);
	}
	
}
