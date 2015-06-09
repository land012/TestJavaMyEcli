package com.land.model.many2onebi;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Ò»¶Ô¶à
 * @author asdf
 *
 */
@Entity
@Table(name="t_grade")
public class Grade {
	private int id;
	private String name;
	private Map<Integer, Student> students;
	
	@Id
	@GeneratedValue
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
	
	@OneToMany(mappedBy="grade", cascade={CascadeType.ALL})
	@MapKey(name="id")
	public Map<Integer, Student> getStudents() {
		return students;
	}
	public void setStudents(Map<Integer, Student> students) {
		this.students = students;
	}
	
}
