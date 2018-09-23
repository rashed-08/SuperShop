package com.supershop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {

	public static String checkValid(String userName, String password, String role) {
		String userNameDB="";
		String passwordDB="";
		String roleDB="";
		try {
			Connection connection = DBConnection.getConnection();
			if (role.equals("Customer")){
				PreparedStatement statement=connection.prepareStatement("select username, password from customer where username=? and password=?");
				statement.setString(1, userName);
				statement.setString(2, password);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					userNameDB = resultSet.getString("username");
					passwordDB = resultSet.getString("password");
				}
				if (userNameDB.equals(userName) && passwordDB.equals(password)){
					return "Customer";
				}
			} else {
				PreparedStatement statement=connection.prepareStatement("select username, password, role from staff where username=? and password=? and role=?");
				statement.setString(1, userName);
				statement.setString(2, password);
				statement.setString(3, role);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					userNameDB = resultSet.getString("username");
					passwordDB = resultSet.getString("password");
					roleDB = resultSet.getString("role");
				}
				
				if (userNameDB.equals(userName) && passwordDB.equals(password) && roleDB.equals("Manager")){
					return "Manager";
				} else if (userNameDB.equals(userName) && passwordDB.equals(password) && roleDB.equals("SalesStaff")){
					return "SalesStaff";
				} else if (userNameDB.equals(userName) && passwordDB.equals(password) && roleDB.equals("WarehouseStaff")){
					return "WarehouseStaff";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
