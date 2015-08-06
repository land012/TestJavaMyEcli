package com.umbrella.vo;

public class CommonVo {
	private static int i = 0;
	private int j = 0;
	
	private static CommonVo vo;
	
	private int k = 0;
	
	public static CommonVo getInstance() {
		if(vo == null) vo = new CommonVo();
		return vo;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		CommonVo.i = i;
	}
	public static void increI() {
		i++;
	}
	public synchronized static void increISyn() {
		i++;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	public void increJ() {
		j++;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	public void increK() {
		k++;
	}
	public synchronized void increKSyn() {
		k++;
	}
}
