package com.umbrella.designpattern.mediatar;

public class Tester extends Colleague {

	public Tester(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("测试人员测完了！");
		this.mediatar.change(this);
	}

}
