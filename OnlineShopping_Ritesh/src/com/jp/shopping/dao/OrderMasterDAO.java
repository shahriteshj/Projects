package com.jp.shopping.dao;

import java.util.ArrayList;
import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;

public interface OrderMasterDAO {

	public ArrayList<OrderMaster> getOrderList() throws ShoppingException;
	
	public boolean insertOrderDetails(ArrayList<OrderMaster> orderList) throws ShoppingException;

}
