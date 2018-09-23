package com.supershop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDao {

	public static int saveProductWithoutDiscount(String productId, String productName,
			int unitPrice, int salePrice, int stock) {
		int status = 0;
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into product (product_id, product_name, unit_price, sale_price, stock) values (?,?,?,?,?)");
			statement.setString(1, productId);
			statement.setString(2, productName);
			statement.setInt(3, unitPrice);
			statement.setInt(4, salePrice);
			statement.setInt(5, stock);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error comes from saveProductWithoutDiscount method "+e);
		}
		return status;
	}
	
	public static int saveProductWithDiscount(String productId, String productName,
			int unitPrice, int discount, int salePrice, int stock) {
		int status = 0;
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			int updatedDiscount = (salePrice * discount) / 100;
			int discountedSalePrice = salePrice - updatedDiscount;
			PreparedStatement statement = connection
					.prepareStatement("insert into product (product_id, product_name, unit_price, discount, sale_price, stock) values (?,?,?,?,?,?)");
			statement.setString(1, productId);
			statement.setString(2, productName);
			statement.setInt(3, unitPrice);
			statement.setInt(4, discount);
			statement.setInt(5, discountedSalePrice);
			statement.setInt(6, stock);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error comes from saveProductWithDiscount method "+e);
		}
		return status;
	}
	
	public static int overridePrice(String productId, int overridePrice) {
		int status = 0;
		
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select unit_price, sale_price from product where product_id=?");
			statement.setString(1, productId);
			ResultSet resultSet = statement.executeQuery();
			int presentUnitPrice = 0, presentSalePrice = 0;
			while (resultSet.next()) {
				presentUnitPrice = resultSet.getInt("unit_price");
				presentSalePrice = resultSet.getInt("sale_price");
			}
			if (presentUnitPrice > overridePrice || presentUnitPrice < overridePrice) {
				PreparedStatement statement2 = connection.prepareStatement("update product set unit_price=?, sale_price=? where product_id=?");
				statement2.setInt(1, overridePrice);
				statement2.setInt(2, overridePrice);
				statement2.setString(3, productId);
				status = statement2.executeUpdate();
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error comes from overridePrice method " + e);
		}
		
		return status;
	}
	
	public static int updateDiscountOffer(String productId, int updateDiscount) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement1 = connection.prepareStatement("select sale_price, discount from product where product_id=?");
			statement1.setString(1, productId);
			ResultSet resultSet = statement1.executeQuery();
			int presentSalePrice = 0, presentDiscount = 0;
			while (resultSet.next()) {
				presentSalePrice = resultSet.getInt("sale_price");
				presentDiscount = resultSet.getInt("discount");
			}
			int updatedDiscount = (presentSalePrice * updateDiscount) / 100;
			int discountedSalePrice = presentSalePrice - updatedDiscount;
			if (presentDiscount > updateDiscount || presentDiscount < updateDiscount) {
				PreparedStatement statement2 = connection.prepareStatement("update product set sale_price=?, discount=? where product_id=?");
				statement2.setInt(1, discountedSalePrice);
				statement2.setInt(2, updateDiscount);
				statement2.setString(3, productId);
				status = statement2.executeUpdate();
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error comes from updateDiscountOffer method " + e);
		}
		return status;
	}
	
	public static int createStaff(String username, String password, String email, String userRole) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into staff (username, password, email, role) values (?,?,?,?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, userRole);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error comes from updateDiscountOffer method " + e);
		}
		return status;
	}
}
