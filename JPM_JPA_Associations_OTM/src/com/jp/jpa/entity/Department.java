package com.jp.jpa.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT_OTM")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6436221678872466844L;

	@Id
	@Column(name = "DEPT_ID")
	private Long deptId;

	@Column(name = "DEPT_NAME")
	private String deptName;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "department")
	private Set<Employee> employeeSet;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
