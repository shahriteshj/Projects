package com.jp.shopping.service;

import java.util.ArrayList;

import com.jp.shopping.entity.ItemMaster;
import com.jp.shopping.exceptions.ShoppingException;

public interface ItemMasterService {

	ArrayList<ItemMaster> getItemList() throws ShoppingException;
	
	public ItemMaster getItemDetails(String itemId) throws ShoppingException;
}
