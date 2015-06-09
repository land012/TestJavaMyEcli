package com.umbrella.designpattern.future;

public class FutureData implements Data {
	
	private Data realData;
	private boolean isReady;
	
	public synchronized void setRealData(Data realData) {
		if(isReady) return;
		this.realData = realData;
		this.isReady = true;
		notifyAll();
	}

	@Override
	public synchronized Object getData() {
		if(!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getData();
	}

}
