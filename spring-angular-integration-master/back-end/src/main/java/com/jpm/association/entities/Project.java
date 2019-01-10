package com.jpm.association.entities;

import java.util.List;

public class Project {
	private int projectId;
	private String projectTitle;
	
	// Association
	private List<Employee> empList;
	
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public Project(int projectId, String projectTitle) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + "]";
	}
}
