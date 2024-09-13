package com.zcart.user.functionalities.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.zcart.db.DBApp;
import com.zcart.model.Cart;
import com.zcart.model.Product;

public class CustomerServiceHelperImpl implements ICustomerServiceHelper {

	@Override
	public void viewProduct() {
		for (Map.Entry<String, Product> map : DBApp.getAllProducts().entrySet()) {
			map.getValue().toString();
		}
	}

	@Override
	public void addToCart(String userId) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter the product to add");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String productId = reader.readLine();
			Product product = null;
			if (DBApp.getAllProducts().containsKey(productId)) {
				product = DBApp.getAllProducts().get(productId);
				if (product != null) {
					boolean flag = true;
					while (flag) {
						System.out.println("Enter the product count");
						int count = reader.read();
						if (count > product.getCount()) {
							addProductToCart(userId, product, count);
							flag = false;
						} else {
							System.out.println("Currently available stock" + product.getCount());
						}
					}
				}
				System.out.println("Product Added to Cart Successfully");
			} else {
				System.out.println("Product Not Found");
			}
		} catch (Exception e) {
			System.out.println("Error Occured - " + e);
		}
	}

	@Override
	public void buyAProduct(String userId) {
		Cart cart = DBApp.getCartProduct().get(userId);
		Map<String, Product> productDB = DBApp.getAllProducts();
		double prize = cart.getPrice();
		if (makePayment(prize)) {
			for (Map.Entry<String, Integer> product : cart.getProductId().entrySet()) {
				String productId = product.getKey();
				Integer productCount = product.getValue();
				Product finalProduct = productDB.get(productId);
				finalProduct.setCount(finalProduct.getCount() - productCount);
				product.toString();
			}
		} else {
			System.out.println("payment failed");
		}
	}

	private void addProductToCart(String userId, Product product, int count) throws Exception {
		Cart cart = null;
		if (DBApp.getAllUsers().containsKey(userId)) {
			cart = DBApp.getCartProduct().get(userId);
		} else {
			cart = new Cart();
			cart.setUserId(userId);
		}
		cart.getProductId().put(product.getId(), count);
		cart.setPrice(count * cart.getPrice() * product.getPrice());
		DBApp.getCartProduct().put(userId, cart);
	}

	private boolean makePayment(double prize) {
		Scanner sc = new Scanner(System.in);
		double prizeValue = sc.nextDouble();
		if (prize == prizeValue)
			return true;
		else
			return false;

	}
}
