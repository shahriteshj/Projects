package com.jp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	@Qualifier("serviceProd")
	private ProductService prodService;

	@RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProdList() {
		System.out.println("In getProdList().");
		List<Product> prodList = null;
		try {
			prodList = prodService.getProductList();
		} catch (HrException e) {
			e.printStackTrace();
		}
		return prodList;
	}

	@RequestMapping(value = "/prodDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductDetails(@RequestParam("prodId") int prodId) {
		System.out.println("In getProductDetails().");
		Product prod = null;
		try {
			prod = prodService.getProductDetails(prodId);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return prod;
	}

}
