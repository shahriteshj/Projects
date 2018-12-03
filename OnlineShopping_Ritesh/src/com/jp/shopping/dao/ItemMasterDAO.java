package com.jp.shopping.dao;

import java.util.ArrayList;

import com.jp.shopping.entity.ItemMaster;
import com.jp.shopping.exceptions.ShoppingException;

public interface ItemMasterDAO {

	ArrayList<ItemMaster> getItemList() throws ShoppingException;
	
	public ItemMaster getItemDetails(String itemId) throws ShoppingException;

}
