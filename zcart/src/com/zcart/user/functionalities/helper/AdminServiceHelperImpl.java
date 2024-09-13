package com.zcart.user.functionalities.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import com.zcart.constant.DeviceType;
import com.zcart.db.DBApp;
import com.zcart.model.Product;

public class AdminServiceHelperImpl implements IAdminServiceHelper {

	private static String id = "0";

	@Override
	public void addProduct() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			Map<String, Product> map1 = DBApp.getAllProducts();
			Product product = new Product();
			System.out.println("Enter the product name");
			String productName = reader.readLine();
			product.setName(productName);
			System.out.println("Enter the product count");
			int productCount = Integer.parseInt(reader.readLine());
			product.setCount(productCount);
			System.out.println("Enter the device type\n1)Mobile\n2)Laptop\n3)Tablet");
			int deviceType = Integer.parseInt(reader.readLine());
			switch (deviceType) {
			case 1:
				product.setType(DeviceType.MOBILE);
				break;
			case 2:
				product.setType(DeviceType.LAPTOP);
				break;
			case 3:
				product.setType(DeviceType.TABLET);
				break;
			}
			map1.put(String.valueOf(Integer.parseInt(id) + 1), product);
		} catch (Exception e) {
			System.out.println("Error Occured-" + e);
			throw new Exception("unable to add product");
		} finally {
			reader.close();
		}

	}

	@Override
	public void updateProduct() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the product id to update");
		try {
			Product product = null;
			String id = reader.readLine();
			for (Map.Entry<String, Product> prod : DBApp.getAllProducts().entrySet()) {
				if (prod.getKey().equals(id)) {
					product = prod.getValue();
					break;
				}
			}
			System.out.println("Enter the field to update");

		} catch (Exception e) {

		} finally {

		}
	}

	@Override
	public void deleteProduct() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewProduct() throws Exception {
		// TODO Auto-generated method stub

	}

}
