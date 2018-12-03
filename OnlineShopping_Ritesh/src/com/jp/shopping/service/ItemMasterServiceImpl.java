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
		ArrayList<ItemMaster> itemList = new ArrayList<ItemMaster>();
		itemList = itemMasterDAO.getItemList();
		return itemList;
	}
	
	@Override
	public ItemMaster getItemDetails(String itemId) throws ShoppingException{
		return itemMasterDAO.getItemDetails(itemId);
		
	}
	
}
