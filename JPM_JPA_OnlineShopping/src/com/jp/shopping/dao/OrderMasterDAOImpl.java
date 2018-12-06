package com.jp.shopping.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;
import com.jp.shopping.utilities.JPAUtil;

public class OrderMasterDAOImpl implements OrderMasterDAO {

	private EntityManager entityManager;

	public OrderMasterDAOImpl() throws ShoppingException {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public ArrayList<OrderMaster> getOrderList() throws ShoppingException {
		TypedQuery<OrderMaster> q =entityManager.createQuery("from ORDERMASTER", OrderMaster.class);
		return (ArrayList<OrderMaster>)q.getResultList();
	}

	@Override
	public boolean insertOrderDetails(ArrayList<OrderMaster> orderList) throws ShoppingException {
			for (OrderMaster orderMaster : orderList) {
				entityManager.persist(orderMaster);
			}
			return true;
	}

	
	
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
}
