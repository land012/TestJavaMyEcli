package com.land.model.scs;

import java.io.Serializable;

public class ScorePK implements Serializable {
	private Student student;
	private Course course;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public int hashCode() {
		return student.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null) {
			ScorePK pk = (ScorePK)obj;
			if(this.getStudent().getId()==pk.getStudent().getId() && this.getCourse().getId() == pk.getCourse().getId()) {
				return true;
			}
		}
		return false;
	}
	
}
