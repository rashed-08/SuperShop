/**
 * 
 */
package com.supershop;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author romantic-coder
 *
 */
public class ViewProduct {

	public ViewProduct() {
		JFrame mainFrame = new JFrame();
		String data[][] = null;
		String column[] = null;

		try {
			Connection connection = DBConnection.getConnection();

			PreparedStatement query = connection.prepareStatement(
					"select product_id, product_name, unit_price, discount, sale_price, stock from product", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet = query.executeQuery();

			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			int cols = resultSetMetaData.getColumnCount();
			column = new String[cols];

			for (int i = 1; i <= cols; i++) {
				column[i - 1] = resultSetMetaData.getColumnName(i);
			}

			resultSet.last();
			int rows = resultSet.getRow();
			resultSet.beforeFirst();
			data = new String[rows][cols];
			int count = 0;

			while (resultSet.next()) {
				for (int i = 1; i <= cols; i++) {
					data[count][i - 1] = resultSet.getString(i);
				}
				count++;
			}
			connection.close();

		} catch (Exception e) {
			System.out.println("Through error from viewProduct: " + e);
		}

		JTable table = new JTable(data, column);
		table.setBounds(30, 40, 200, 300);
		JScrollPane scrollPane = new JScrollPane(table);

		mainFrame.add(scrollPane);

		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new ViewProduct();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
