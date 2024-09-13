package com.zcart.user.functionalities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import com.zcart.db.DBApp;
import com.zcart.model.User;
import com.zcart.user.functionalities.helper.CustomerServiceHelperImpl;
import com.zcart.user.functionalities.helper.ICustomerServiceHelper;

public class CustomerZcartService {
	private ICustomerServiceHelper customerService;

	CustomerZcartService() {
		customerService = new CustomerServiceHelperImpl();
	}

	public void loginIntoPage() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		String password = reader.readLine();
		String userId = verify(name, password); 
		if (userId!=null) {
			startService(userId);
		} else {
			throw new Exception("Invalid Credentials");
		}
	}

	private String verify(String name, String password) {
		Map<String, User> users = DBApp.getAllUsers();
		for (User user : users.values()) {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(password)) {
				return user.getUid();
			}
		}
		return null;
	}

	private void startService(String userId) {
		Scanner reader = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			try {
				System.out.println(
						"\nEnter the option\n 1)View The Product \n2)Add the Product To Cart\n3)Buy a Product\n4)Exit");
				int n = reader.nextInt();
				switch (n) {
				case 1:
					customerService.viewProduct();
					break;
				case 2:
					customerService.addToCart(userId);
					break;
				case 3:
					customerService.buyAProduct(userId);
					break;
				case 4:
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Exception Occured-" + e);
				System.out.println("Do you want continue 1 or 0");
				int n = reader.nextInt();
				if (n != 1) {
					flag = false;
				}
			} finally {
				reader.close();
			}
		}
	}
}
