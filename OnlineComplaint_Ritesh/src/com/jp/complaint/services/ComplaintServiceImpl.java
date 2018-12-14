package com.jp.complaint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.complaint.daos.IComplaintDao;
import com.jp.complaint.entities.Complaint;
import com.jp.complaint.exceptions.ComplaintException;

/*
 * Service interface for Complaint operations
 */

@Service("service")
public class ComplaintServiceImpl implements IComplaintService {

	private IComplaintDao companyDao;

	// Inject DAO for DB operations
	@Autowired
	public ComplaintServiceImpl(@Qualifier("daoDS") IComplaintDao companyDao) throws ComplaintException {
		this.companyDao = companyDao;
	}

	// Service to get List of all Complaints
	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.jp.complaint.services.IComplaintService#getComplaintList()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintList() throws ComplaintException {
		return companyDao.getComplaintList();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jp.complaint.services.IComplaintService#getComplaintDetails(java.lang
	 * .Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Complaint getComplaintDetails(Long complaintId) throws ComplaintException {
		return companyDao.getComplaintDetails(complaintId);
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.jp.complaint.services.IComplaintService#addNewComplaint(com.jp.
	 * complaint.entities.Complaint)
	 */
	@Override
	@Transactional
	public Long addNewComplaint(Complaint complaint) throws ComplaintException {
		return companyDao.insertNewComplaint(complaint);
	}

}
