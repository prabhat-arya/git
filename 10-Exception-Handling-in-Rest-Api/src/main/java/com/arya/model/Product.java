package com.arya.model;

import lombok.Data;

@Data
public class Product {
	public Product(Integer pid, String pName) {
		super();
		this.pid = pid;
		this.pName = pName;
	}

	private Integer pid;
	private String pName;

}
