package com.land.model.scs;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ScorePK.class)
public class Score {
	private Student student;
	private Course course;
	private int score;
	
	@Id
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="sid")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Id
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="cid")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
