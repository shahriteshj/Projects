package com.jp.shopping.service;

import java.util.ArrayList;

import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;

public interface OrderMasterService {

	public boolean placeOrder(ArrayList<OrderMaster> orderList) throws ShoppingException;

}
