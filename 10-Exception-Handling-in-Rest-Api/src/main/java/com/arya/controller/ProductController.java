package com.arya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arya.model.Product;
import com.arya.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping(value = "/product", produces = {"application/json"})
	public Product findProductById(@RequestParam("pid") String id) {
		return service.findProduct(Integer.parseInt(id));
	}
}

	