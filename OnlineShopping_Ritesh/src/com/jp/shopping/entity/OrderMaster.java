package com.jp.shopping.entity;

public class OrderMaster {
	Integer customerId;
	Integer orderId;
	String itemId;
	
	public OrderMaster(Integer customerId, Integer orderId, String itemId) {
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	public OrderMaster(Integer customerId, String itemId) {
		this.customerId = customerId;
		this.itemId = itemId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "OrderMaster [customerId=" + customerId + ", orderId=" + orderId + ", itemId=" + itemId + "]";
	}
	

}
