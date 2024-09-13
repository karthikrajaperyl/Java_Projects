package com.zcart.db;

import java.util.HashMap;
import java.util.Map;

import com.zcart.model.Cart;
import com.zcart.model.Product;
import com.zcart.model.User;

public class DBApp {
	protected static Map<String, User> userChache = new HashMap<>();
	protected static Map<String, Product> productChache = new HashMap<>();
	protected static Map<String, Cart> cartCache = new HashMap<>();

	public static User getUser(String id) {
		return userChache.get(id);
	}

	public static Product getProduct(String id) {
		return productChache.get(id);
	}
	
	public static Map<String,User> getAllUsers(){
		return userChache;
	}
	
	public static Map<String,Product> getAllProducts(){
		return productChache;
	}
	
	public static Map<String,Cart> getCartProduct(){
		return cartCache;
	}
	
}
