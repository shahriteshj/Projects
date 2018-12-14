package com.jp.complaint.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jp.complaint.entities.Complaint;
import com.jp.complaint.exceptions.ComplaintException;

/*
 * Complaint DAO implementation
 * 
 */

@Repository("daoDS")
public class ComplaintDaoImpl implements IComplaintDao {

	private static final long serialVersionUID = -9033895157218277382L;

	// Injecting Entity Manager for handing DB operations via JPA
	@PersistenceContext
	private EntityManager entityManager;

	// Method to get all the complaints from DB
	@Override
	public List<Complaint> getComplaintList() throws ComplaintException {
		String sql = "SELECT c FROM complRec c";
		TypedQuery<Complaint> qry = entityManager.createQuery(sql, Complaint.class);
		List<Complaint> complaintList = qry.getResultList();
		return complaintList;
	}

	// Method to get Complaint details based on complaint Id
	// @input complaintId
	@Override
	public Complaint getComplaintDetails(Long complaintId) throws ComplaintException {
		return entityManager.find(Complaint.class, complaintId);

	}

	/*
	 * Method to insert a new Complaint
	 * 
	 * @input complaint object
	 */
	@Override
	public Long insertNewComplaint(Complaint complaint) throws ComplaintException {
		entityManager.persist(complaint);
		Complaint complaintNew = entityManager.find(Complaint.class, complaint.getComplaintId());
		return complaintNew.getComplaintId();
	}

}
