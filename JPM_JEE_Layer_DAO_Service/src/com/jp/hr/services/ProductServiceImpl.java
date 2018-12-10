package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.dao.ProductDAO;
import com.jp.hr.dao.ProductDAOImpl;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HRException;

public class ProductServiceImpl implements ProductService {

	private ProductDAO prodDAO;

	public ProductServiceImpl() throws HRException {
		prodDAO = new ProductDAOImpl();
	}

	@Override
	public ArrayList<Product> getProductList() throws HRException {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList = prodDAO.getProductList();
		return productList;
	}

	@Override
	public Product getProductDetails(int productId) throws HRException {
		return prodDAO.getProductDetails(productId);
	}

	@Override
	public boolean addNewProduct(Product product) throws HRException {
		return prodDAO.insertNewRecord(product);
	}

	@Override
	public boolean removeProduct(int productId) throws HRException {
		return prodDAO.deleteRecord(productId);
	}

	@Override
	public boolean modifyProduct(Product product) throws HRException {
		return prodDAO.updateRecord(product);
	}

}
