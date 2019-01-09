package com.mahendra.demo1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mahendra.demo1.dao.ProductDAO;
import com.mahendra.demo1.entities.Product;
// http://localhost:8082/api/products/1
// http://localhost:8082/api/products/list
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired private ProductDAO dao;
	
	@GetMapping(value="/list",produces="application/json")
	public List<Product> getAll(){
			return dao.getAll();
	}
	
	@GetMapping(value="/{id}",produces="application/json")
	public Product find(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}
	
	@PostMapping(value="/save",consumes="application/json")
	public ResponseEntity<String> save(@RequestBody Product product) {
		dao.save(product);
		return new ResponseEntity<>("Done",HttpStatus.OK);
	}
}
