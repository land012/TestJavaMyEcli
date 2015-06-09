package com.umbrella.designpattern.mediatar;

public class Designer extends Colleague {

	public Designer(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("���ʦ�����ɣ�");
		this.mediatar.change(this);
	}

}
