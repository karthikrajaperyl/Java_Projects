package com.zcart.main;

import java.util.Scanner;

import com.zcart.user.functionalities.AdminZcartService;

public class StartPage {

	private AdminZcartService cartService;

	public static void main(String[] args) {
		System.out.println("Enter as the \n1) Admin \n 2)customer");
		Scanner scanner = new Scanner(System.in);
		try {
			int n = scanner.nextInt();
			StartPage page = new StartPage();
			switch (n) {
			case 1:
				System.out.println("");
				page.loginAsAdmin();
				break;
			case 2:
				System.out.println("");
				page.loginAsCustomer();
				break;
			case 3:
				System.out.println("Invalid Choice");
				break;
			}
		} catch (Exception e) {
			System.out.println("Error Occured-" + e);
		} finally {
			scanner.close();
		}
	}

	public void loginAsCustomer() {

	}

	public void loginAsAdmin() throws Exception {
		cartService.loginIntoPage();
	}
}
