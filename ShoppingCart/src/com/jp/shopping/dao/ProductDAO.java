package com.jp.shopping.dao;

import java.util.ArrayList;

import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;

public interface ProductDAO {

	public ArrayList<Product> getProductList() throws CartException;

	public Product getProductDetails(int productId) throws CartException;

	public boolean insertNewRecord(Product product) throws CartException;

	public boolean deleteRecord(int productId) throws CartException;

	public boolean updateRecord(Product product) throws CartException;
}
