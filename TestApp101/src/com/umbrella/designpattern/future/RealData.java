package com.umbrella.designpattern.future;

public class RealData implements Data {
	
	private Object result;
	
	public RealData() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.result = "真实数据";
	}

	@Override
	public Object getData() {
		return this.result;
	}

}
