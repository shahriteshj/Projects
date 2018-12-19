package com.jp.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.ProductDAO;

@Service("serviceProd")
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDAO prodDAO;

	public ProductServiceImpl() throws HrException {

	}

	@Autowired
	public ProductServiceImpl(@Qualifier("daoProductDS") ProductDAO prodDAO) throws HrException {
		this.prodDAO = prodDAO;
	}

	@Override
	public List<Product> getProductList() throws HrException {
		List<Product> productList = null;
		productList = prodDAO.getProductList();
		return productList;
	}

	@Override
	public Product getProductDetails(int productId) throws HrException {
		return prodDAO.getProductDetails(productId);
	}

	@Override
	@Transactional
	public boolean addNewProduct(Product product) throws HrException {
		return prodDAO.insertNewRecord(product);
	}

	@Override
	@Transactional
	public boolean removeProduct(int productId) throws HrException {
		return prodDAO.deleteRecord(productId);
	}

	@Override
	@Transactional
	public boolean modifyProduct(Product product) throws HrException {
		return prodDAO.updateRecord(product);
	}

}
