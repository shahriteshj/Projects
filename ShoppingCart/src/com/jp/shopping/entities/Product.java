package com.jp.shopping.entities;

public class Product {
	Integer prodID;
	String category;
	String name;
	Float price;
	byte[] image;
	String base64Image;
	
	public Product() {

	}

	public Product(Integer prodID, String category, String name, Float price) {
		super();
		this.prodID = prodID;
		this.category = category;
		this.name = name;
		this.price = price;
	}
	
	public Product(Integer prodID, String category, String name, Float price,byte[] image,String base64Image) {
		this.prodID = prodID;
		this.category = category;
		this.name = name;
		this.price = price;
		this.image = image;
		this.base64Image = base64Image;
	}
	
	public Product(Integer prodID, String category, String name, Float price,byte[] image) {
		super();
		this.prodID = prodID;
		this.category = category;
		this.name = name;
		this.price = price;
		this.image = image;
		
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
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
	
		public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public String toString() {
		return "Product [prodID=" + prodID + ", category=" + category + ", name=" + name + ", price=" + price + "]";
	}

}
