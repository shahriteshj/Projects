package com.jp.shopping.service;

import java.util.ArrayList;
import com.jp.shopping.dao.ItemMasterDAO;
import com.jp.shopping.dao.ItemMasterDAOImpl;
import com.jp.shopping.entity.ItemMaster;
import com.jp.shopping.exceptions.ShoppingException;

public class ItemMasterServiceImpl implements ItemMasterService {
	private ItemMasterDAO itemMasterDAO ;
	
	public ItemMasterServiceImpl() throws ShoppingException{
		itemMasterDAO = new ItemMasterDAOImpl();
	}
	
	@Override
	public ArrayList<ItemMaster> getItemList() throws ShoppingException {
		itemMasterDAO.beginTransaction();
		ArrayList<ItemMaster> items = itemMasterDAO.getItemList();
		itemMasterDAO.commitTransaction();
		return items;
	}
	
	@Override
	public ItemMaster getItemDetails(String itemId) throws ShoppingException{
		itemMasterDAO.beginTransaction();
		ItemMaster itemMaster =  itemMasterDAO.getItemDetails(itemId);
		itemMasterDAO.commitTransaction();
		return itemMaster;
		
	}
	
}
