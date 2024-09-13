package com.zcart.user.functionalities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import com.zcart.db.DBApp;
import com.zcart.model.User;
import com.zcart.user.functionalities.helper.AdminServiceHelperImpl;
import com.zcart.user.functionalities.helper.IAdminServiceHelper;

public class AdminZcartService {
	private IAdminServiceHelper adminHelper;

	AdminZcartService() {
		adminHelper = new AdminServiceHelperImpl();
	}

	public void loginIntoPage() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		String password = reader.readLine();
		if (verify(name, password)) {
			startService();
		} else {
			throw new Exception("Invalid Credentials");
		}
	}

	private boolean verify(String name, String password) {
		Map<String, User> users = DBApp.getAllUsers();
		for (User user : users.values()) {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		}
		return false;
	}

	private void startService() {
		Scanner reader = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			try {
				System.out.println(
						"\nEnter the option\n 1)Add The Product \n2)Delete Product \n3)Update Product\n4)View Product \n5)Exit");
				int n = reader.nextInt();
				switch (n) {
				case 1:
					adminHelper.addProduct();
					break;
				case 2:
					break;
				case 3:
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
