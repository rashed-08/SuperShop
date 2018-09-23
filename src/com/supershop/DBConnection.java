/**
 * 
 */
package com.supershop;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author romantic-coder
 *
 */
public class DBConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String mySQLDriver = "com.mysql.jdbc.Driver";
		String mySQLUrl = "jdbc:mysql://localhost:3306/supershop";
		String mySQLUsername = "root";
		String mySQLPassword = "root";
		try {
			Class.forName(mySQLDriver);
			connection = DriverManager.getConnection(mySQLUrl, mySQLUsername,
					mySQLPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
