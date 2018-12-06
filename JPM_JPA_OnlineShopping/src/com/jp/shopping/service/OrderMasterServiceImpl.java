package com.jp.shopping.service;

import java.util.ArrayList;

import com.jp.shopping.dao.OrderMasterDAO;
import com.jp.shopping.dao.OrderMasterDAOImpl;
import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;

public class OrderMasterServiceImpl implements OrderMasterService {
	private OrderMasterDAO orderMasterDAO ;
	
	public OrderMasterServiceImpl() throws ShoppingException{
		orderMasterDAO = new OrderMasterDAOImpl();
	}
	
	@Override
	public boolean placeOrder(ArrayList<OrderMaster> orderList) throws ShoppingException{
		orderMasterDAO.beginTransaction();
		boolean isSuccess = orderMasterDAO.insertOrderDetails(orderList);
		orderMasterDAO.commitTransaction();
		return isSuccess;
		
	}
	
}
