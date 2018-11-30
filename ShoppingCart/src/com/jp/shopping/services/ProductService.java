package com.jp.shopping.services;

import java.util.ArrayList;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;

public interface ProductService {
	public ArrayList<Product> getProductList() throws CartException;

	public Product getProductDetails(int productId) throws CartException;

	public boolean addNewProduct(Product product) throws CartException;

	public boolean removeProduct(int productId) throws CartException;

	public boolean modifyProduct(Product product) throws CartException;
}
