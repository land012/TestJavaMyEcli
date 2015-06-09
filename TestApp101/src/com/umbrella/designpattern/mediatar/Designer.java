package com.umbrella.designpattern.mediatar;

public class Designer extends Colleague {

	public Designer(Mediatar mediatar) {
		super(mediatar);
	}

	@Override
	public void process() {
		System.out.println("设计师设计完成！");
		this.mediatar.change(this);
	}

}
