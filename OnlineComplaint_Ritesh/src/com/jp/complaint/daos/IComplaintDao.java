package com.jp.complaint.daos;

import java.io.Serializable;
import java.util.List;

import com.jp.complaint.entities.Complaint;
import com.jp.complaint.exceptions.ComplaintException;

/*
 * Complaint DAO interface
 * 
 */

public interface IComplaintDao extends Serializable {
	public List<Complaint> getComplaintList() throws ComplaintException;

	public Complaint getComplaintDetails(Long complaintId) throws ComplaintException;

	public Long insertNewComplaint(Complaint emp) throws ComplaintException;
}
