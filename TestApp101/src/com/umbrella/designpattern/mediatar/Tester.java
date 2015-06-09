package com.umbrella.designpattern.mediatar;

public class Tester extends Colleague {

	public Tester(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("������Ա�����ˣ�");
		this.mediatar.change(this);
	}

}
