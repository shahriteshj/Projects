package com.jp.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_MTM")
public class Course implements Serializable {
	

	private static final long serialVersionUID = -4817524681378703533L;
	
	@Id
	@Column(name="COURSE_ID")
	private Long courseId;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "COURSE_TRAINEE_MTM", 
	joinColumns = { @JoinColumn(name = "COURSE_ID") }, 
	inverseJoinColumns = {
			@JoinColumn(name = "TRAINEE_ID") })
	private Set<Trainee> trainees = new HashSet<Trainee>();
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Set<Trainee> getTrainees() {
		return trainees;
	}


	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", trainees=" + trainees + "]";
	}
	
	

}
