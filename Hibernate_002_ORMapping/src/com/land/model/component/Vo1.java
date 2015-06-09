package com.land.model.component;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Vo1 {
	private int id;
	private Vo2 vo2;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="v2_f1", column=@Column(name="v2f1")),
		@AttributeOverride(name="v2_f2", column=@Column(name="v2f2"))
	})
	public Vo2 getVo2() {
		return vo2;
	}
	public void setVo2(Vo2 vo2) {
		this.vo2 = vo2;
	}
	
}
