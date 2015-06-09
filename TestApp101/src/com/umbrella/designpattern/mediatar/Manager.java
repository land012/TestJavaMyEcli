package com.umbrella.designpattern.mediatar;

public class Manager implements Mediatar {
	
	private Programmer programmer;
	private Tester tester;
	
	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}
	
	public void setTester(Tester tester) {
		this.tester = tester;
	}

	@Override
	public void change(Colleague colleague) {
		if(colleague instanceof Designer) {
			this.programmer.process();
		} else if (colleague instanceof Programmer) {
			this.tester.process();
		} else if (colleague instanceof Tester) {
			System.out.println("项目完成了，交给验收方!");
		}
	}

}
