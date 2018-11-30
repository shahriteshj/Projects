package com.jp.shopping.services;

import java.util.ArrayList;

import com.jp.shopping.dao.ProductDAO;
import com.jp.shopping.dao.ProductDAOImpl;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;

public class ProductServiceImpl implements ProductService {

	private ProductDAO prodDAO;

	public ProductServiceImpl() throws CartException {
		prodDAO = new ProductDAOImpl();
	}

	@Override
	public ArrayList<Product> getProductList() throws CartException {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList = prodDAO.getProductList();
		return productList;
	}

	@Override
	public Product getProductDetails(int productId) throws CartException {
		return prodDAO.getProductDetails(productId);
	}

	@Override
	public boolean addNewProduct(Product product) throws CartException {
		return prodDAO.insertNewRecord(product);
	}

	@Override
	public boolean removeProduct(int productId) throws CartException {
		return prodDAO.deleteRecord(productId);
	}

	@Override
	public boolean modifyProduct(Product product) throws CartException {
		return prodDAO.updateRecord(product);
	}

}
