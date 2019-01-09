package com.mahendra.demo1.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="products")
@Table(name="products")
public class Product implements Serializable{
	@Id
	@Column(name="id",precision=3)
	private Integer productId;
	
	@Column(name="pname",length=20)
	private String name;
	
	@Column(name="pdescr",length=120)
	private String description;
	@Column(name="price",precision=8,scale=2)
	private Float price;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Product(Integer productId, String name, String description, Float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
