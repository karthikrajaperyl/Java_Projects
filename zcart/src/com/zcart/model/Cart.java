package com.zcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String userId;
	private Map<String, Integer> productId;
	private double price;

	public Cart() {
		productId = new HashMap<>();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Integer> getProductId() {
		return productId;
	}

	public void setProductId(Map<String, Integer> productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
