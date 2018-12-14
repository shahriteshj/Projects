/**
 * 
 */
package com.jp.complaint.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Ritesh Complaint entity mapped to Complaint table in DB via JPA
 */

@Entity(name = "complRec")
@Table(name = "COMPLAINT")
public class Complaint implements Serializable {

	private static final long serialVersionUID = -941771316294778327L;

	private Long complaintId;
	private Long accountId;
	private String branchCode;
	private String emailId;
	private String Category;
	private String description;
	private String priority;
	private String status;

	@Id
	@SequenceGenerator(name = "COMPLAINTID", sequenceName = "hibernate_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPLAINTID")
	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	@Column(name = "ACCOUNTID")
	@NotNull
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "BRANCHCODE")
	@NotNull
	@NotBlank
	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "EMAILID")
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please enter valid Email Id")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "CATEGORY")
	@NotNull
	@NotBlank
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Column(name = "DESCRIPTION")
	@NotNull
	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRIORITY")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", accountId=" + accountId + ", branchCode=" + branchCode
				+ ", emailId=" + emailId + ", Category=" + Category + ", description=" + description + ", priority="
				+ priority + ", status=" + status + "]";
	}

}
