package com.jp.hr.services;

import java.util.ArrayList;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HRException;

public interface ProductService {
	public ArrayList<Product> getProductList() throws HRException;
	public Product getProductDetails(int productId) throws HRException;
	public boolean addNewProduct(Product product) throws HRException;
	public boolean removeProduct(int productId) throws HRException;
	public boolean modifyProduct(Product product) throws HRException;
}
