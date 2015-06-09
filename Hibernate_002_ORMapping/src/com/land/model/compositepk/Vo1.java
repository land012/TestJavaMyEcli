package com.land.model.compositepk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class Vo1 {
	private int id;
	private String f1;
	private Vo2 vo2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="v2_id1", referencedColumnName="id1"),
		@JoinColumn(name="v2_id2", referencedColumnName="id2")
	})
	public Vo2 getVo2() {
		return vo2;
	}
	public void setVo2(Vo2 vo2) {
		this.vo2 = vo2;
	}
	
}
