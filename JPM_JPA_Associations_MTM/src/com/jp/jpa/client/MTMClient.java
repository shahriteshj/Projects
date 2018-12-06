package com.jp.jpa.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jp.jpa.entity.Order;
import com.jp.jpa.entity.Product;
import com.jp.jpa.util.JPAUtil;

public class MTMClient {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Product p1 = new Product();
		p1.setProductId(101L);
		p1.setProductName("LED TV");
		p1.setProductPrice(45000.0);
		
		
		Product p2 = new Product();
		p2.setProductId(102L);
		p2.setProductName("Face Wash");
		p2.setProductPrice(80.99);
		
		Product p3 = new Product();
		p3.setProductId(103L);
		p3.setProductName("Pampers");
		p3.setProductPrice(15.75);
		
		Product p4 = new Product();
		p4.setProductId(104L);
		p4.setProductName("CFL Bulb");
		p4.setProductPrice(250.55);
		
		Set<Product> products = new HashSet<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		
		Order o1 = new Order();
		o1.setOrderId(1L);
		o1.setPurchaseDate(new Date());
		o1.setProducts(products);
		
		
		Order o2 = new Order();
		o2.setOrderId(2L);
		o2.setPurchaseDate(new Date());
		o2.setProducts(products);
		
		Set<Order>orders = new HashSet<Order>();
		orders.add(o1);
		orders.add(o2);
		
		p1.setOrders(orders);
		p2.setOrders(orders);
		p3.setOrders(orders);
		p4.setOrders(orders);
		
		em.getTransaction().begin();
		em.persist(o1);
		em.persist(o2);
		em.getTransaction().commit();

	}

}
