package com.supershop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDao {

	public static int createCustomer(String name, String username,
			String password, int card_no, int card_balance) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into customer (username, password,name, card_no, card_balance) values (?,?,?,?,?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setInt(4, card_no);
			statement.setInt(5, card_balance);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("Error occurred in create customer: " + e);
		}
		return status;
	}
	
	public static int purchaseProduct(String productId, String username) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("select unit_price, sale_price, stock from product where product_id=?");
			statement.setString(1, productId);
			ResultSet resultSet = statement.executeQuery();
			
			int salePrice = 0, unitPrice = 0, stock = 0;
			
			while (resultSet.next()) {
				unitPrice = resultSet.getInt("unit_price");
				salePrice = resultSet.getInt("sale_price");
				stock = resultSet.getInt("stock");
			}
			
			PreparedStatement statement2 = connection.prepareStatement("select card_balance from customer where username=?");
			statement2.setString(1, username);
			resultSet = statement2.executeQuery();
			
			int checkBalance = 0;
			
			while (resultSet.next()) {
				checkBalance = resultSet.getInt("card_balance");
			}
			
			if (salePrice > checkBalance) {
				status = 2;
				return status;
			}
			
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = simpleDateFormat.format(date);
			
			if (stock > 0){
				PreparedStatement purchaseProduct = connection.prepareStatement("insert into purchase(user_id, product_id) values (?,?)");
				purchaseProduct.setString(1, username);
				purchaseProduct.setString(2, productId);
				status = purchaseProduct.executeUpdate();
				
				int afterSoldProductCardBalance = checkBalance - salePrice;
				
				if (status == 1){
					PreparedStatement saveSoldInformation = connection.prepareStatement("insert into sale(user_id, product_id, unit_price, sold_price, order_date) values (?,?,?,?,?)");
					saveSoldInformation.setString(1, username);
					saveSoldInformation.setString(2, productId);
					saveSoldInformation.setInt(3, unitPrice);
					saveSoldInformation.setInt(4, salePrice);
					saveSoldInformation.setString(5, currentDate);
					status = saveSoldInformation.executeUpdate();
					
					PreparedStatement setRestCardBalance = connection.prepareStatement("update customer set card_balance=? where username=?");
					setRestCardBalance.setInt(1, afterSoldProductCardBalance);
					setRestCardBalance.setString(2, username);
					status = setRestCardBalance.executeUpdate();
					
					PreparedStatement updateStockLevel = connection.prepareStatement("update product set stock=? where product_id=?");
					updateStockLevel.setInt(1, stock-1);
					updateStockLevel.setString(2, productId);
					status = updateStockLevel.executeUpdate();
				}
			} else {
				status = 3;
				return status;
			}
		} catch (Exception e) {
			System.out.println("Error occurred from purchaseProduct method: " + e);
		}
		return status;
	}

}
