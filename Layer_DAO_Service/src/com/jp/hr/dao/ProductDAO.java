package com.jp.hr.dao;

import java.util.ArrayList;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HRException;

public interface ProductDAO {
	
	public ArrayList<Product> getProductList() throws HRException;
	
	public Product getProductDetails(int productId) throws HRException;
	
	public boolean insertNewRecord(Product product) throws HRException;
	
	public boolean deleteRecord(int productId) throws HRException;
	
	public boolean updateRecord(Product product) throws HRException;
}


