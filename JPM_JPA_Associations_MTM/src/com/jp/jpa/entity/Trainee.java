package com.jp.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINEE_MTM")
public class Trainee implements Serializable {

	private static final long serialVersionUID = -1167072267844239983L;

	@Id
	@Column(name = "TRAINEE_ID")
	private Long traineeId;

	@Column(name = "TRAINEE_NAME")
	private String traineeName;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="trainees")
	private Set<Course> courses = new HashSet<Course>();

	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + "]";
	}

}
