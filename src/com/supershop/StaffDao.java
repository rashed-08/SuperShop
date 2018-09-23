package com.supershop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDao {
	
	public static int updateStockByWarehouseStaff(String username, String password, String email, String userRole) {
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
			System.out.println("Error occurred from updateStockByWarehouseStaff method: " + e);
		}
		return status;
	}
	
	public static int removeItem(String username, String productID) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from purchase where user_id=? and product_id=?");
			statement.setString(1, username);
			statement.setString(2, productID);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error occurred from removeItem method: " + e);
		}
		return status;
	}
	
	public static int cancelPurchase(String username) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from purchase where user_id=?");
			statement.setString(1, username);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error occurred from cancelPurchase method: " + e);
		}
		return status;
	}
	
	public static int replenishStock(String productId, int stockLevel) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select stock from product where product_id=?");
			statement.setString(1, productId);
			ResultSet resultSet = statement.executeQuery();
			int presentStock = 0;
			while (resultSet.next()) {
				presentStock = resultSet.getInt("stock");
			}
			PreparedStatement statement2 = connection.prepareStatement("update product set stock=? where product_id=?");
			statement2.setInt(1, presentStock+stockLevel);
			statement2.setString(2, productId);
			status = statement2.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error occurred from replenishStock method: " + e);
		}
		return status;
	}

}
