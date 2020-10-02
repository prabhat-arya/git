package com.arya.service;

import org.springframework.stereotype.Service;

import com.arya.exception.NoProductFoundException;
import com.arya.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Override
	public Product findProduct(Integer id) {
		if (id==100) {
			return new Product(100, "bick");
		}else {
			throw new NoProductFoundException("Product is not there with this id");
		}
	}

}
