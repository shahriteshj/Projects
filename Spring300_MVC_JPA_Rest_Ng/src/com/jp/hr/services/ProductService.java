package com.jp.hr.services;

import java.util.List;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

public interface ProductService {
	public List<Product> getProductList() throws HrException;

	public Product getProductDetails(int productId) throws HrException;

	public boolean addNewProduct(Product product) throws HrException;

	public boolean removeProduct(int productId) throws HrException;

	public boolean modifyProduct(Product product) throws HrException;
}
