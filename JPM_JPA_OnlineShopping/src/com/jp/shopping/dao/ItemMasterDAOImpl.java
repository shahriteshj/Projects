package com.jp.shopping.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jp.shopping.entity.ItemMaster;
import com.jp.shopping.exceptions.ShoppingException;
import com.jp.shopping.utilities.JPAUtil;

public class ItemMasterDAOImpl implements ItemMasterDAO {

	private EntityManager entityManager;

	public ItemMasterDAOImpl() throws ShoppingException {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public ArrayList<ItemMaster> getItemList() throws ShoppingException {
		TypedQuery<ItemMaster> q = entityManager.createQuery("from ITEMMASTER",ItemMaster.class);
		return (ArrayList<ItemMaster>)q.getResultList();
	}
	
	@Override
	public ItemMaster getItemDetails(String itemId) throws ShoppingException {
		return entityManager.find(ItemMaster.class, itemId);
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
