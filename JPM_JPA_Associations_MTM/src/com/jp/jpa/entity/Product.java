package com.jp.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_MTM")
public class Product implements Serializable {

	private static final long serialVersionUID = 8742213180962259677L;

	@Id
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="product_price")
	private Double productPrice;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="products")
	private Set<Order> orders = new HashSet<Order>();

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
}
