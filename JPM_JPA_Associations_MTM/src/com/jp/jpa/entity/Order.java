package com.jp.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER_MTM")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_DATE")
	private Date purchaseDate;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "ORDER_PRODUCT_MTM", 
	joinColumns = { @JoinColumn(name = "ORDER_ID") }, 
	inverseJoinColumns = {
			@JoinColumn(name = "PRODUCT_ID") })
	private Set<Product> products = new HashSet<Product>();

	public Order() {

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", purchaseDate=" + purchaseDate + ", products=" + products + "]";
	}
	
	

}
