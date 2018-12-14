package com.jp.complaint.services;

import java.util.List;

import com.jp.complaint.entities.Complaint;
import com.jp.complaint.exceptions.ComplaintException;

public interface IComplaintService {

	public List<Complaint> getComplaintList() throws ComplaintException;

	public Complaint getComplaintDetails(Long complaintId) throws ComplaintException;

	public Long addNewComplaint(Complaint complaint) throws ComplaintException;

}
