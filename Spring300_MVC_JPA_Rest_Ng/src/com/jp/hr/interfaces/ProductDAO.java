package com.jp.hr.interfaces;

import java.util.List;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

public interface ProductDAO {

	public List<Product> getProductList() throws HrException;

	public Product getProductDetails(int productId) throws HrException;

	public boolean insertNewRecord(Product product) throws HrException;

	public boolean deleteRecord(int productId) throws HrException;

	public boolean updateRecord(Product product) throws HrException;
}
