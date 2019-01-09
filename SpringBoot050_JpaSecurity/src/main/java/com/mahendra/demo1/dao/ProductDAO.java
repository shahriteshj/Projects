package com.mahendra.demo1.dao;

import java.util.List;

import com.mahendra.demo1.entities.Product;

public interface ProductDAO {

	public Product findById(Integer id);
	public void save(Product product);
	public List<Product> getAll();
}
