package com.jp.hr.entities;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
	Integer prodId;
	String category;
	

	@NotNull
	@Size(min = 3, max = 20, message="Product Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Product Name has invalid characters")
	String name;
	
	
	@Digits(fraction= 2, integer=5)
	Float price;

	public Product() {

	}

	public Product(Integer prodId, String category, String name, Float price) {
		super();
		this.prodId = prodId;
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", category=" + category + ", name=" + name + ", price=" + price + "]";
	}

}
