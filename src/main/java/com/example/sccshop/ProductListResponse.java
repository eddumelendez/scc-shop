package com.example.sccshop;

import java.util.List;

/**
 * @author Eddú Meléndez
 */
public class ProductListResponse {

	private List<Product> products;

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
