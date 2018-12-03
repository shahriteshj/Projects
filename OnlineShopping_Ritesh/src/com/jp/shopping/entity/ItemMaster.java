package com.jp.shopping.entity;

public class ItemMaster {
	String itemId;
	String name;
	String category;
	Float price;
	Integer itemInStock;
	
	public ItemMaster(String itemId, String name, String category, Float price, Integer itemInStock) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.itemInStock = itemInStock;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getItemInStock() {
		return itemInStock;
	}

	public void setItemInStock(Integer itemInStock) {
		this.itemInStock = itemInStock;
	}

	@Override
	public String toString() {
		return "ItemMaster [itemId=" + itemId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", itemInStock=" + itemInStock + "]";
	}
	
	
	

}
