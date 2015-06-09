package com.land.model.one2onepk;

public class Vo1 {
	private int id;
	private String name;
	private Vo2 vo2;
	private Vo3 vo3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vo2 getVo2() {
		return vo2;
	}
	public void setVo2(Vo2 vo2) {
		this.vo2 = vo2;
	}
	public Vo3 getVo3() {
		return vo3;
	}
	public void setVo3(Vo3 vo3) {
		this.vo3 = vo3;
	}
	
}
