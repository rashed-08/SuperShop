/**
 * 
 */
package com.supershop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author romantic-coder
 *
 */
public class ViewProductById {

	// private String productId;

	public ViewProductById() {
		JFrame mainFrame = new JFrame("Super Shop");

		JLabel welcomeLabel = new JLabel("Search product by it's id.");
		welcomeLabel.setBounds(150, 50, 250, 40);

		JLabel setProductIdLabel = new JLabel("Product Id: ");
		setProductIdLabel.setBounds(50, 100, 150, 40);

		JTextField setProductIdTextField = new JTextField();
		setProductIdTextField.setBounds(200, 100, 200, 40);

		JButton viewProductByIdButton = new JButton("View Product");
		viewProductByIdButton.setBounds(150, 150, 200, 40);

		viewProductByIdButton.addActionListener(new ActionListener() {

			String productId = setProductIdTextField.getText();

			@Override
			public void actionPerformed(ActionEvent e) {

				String productId = setProductIdTextField.getText();

				JFrame mainFrame = new JFrame();
				String data[][] = null;
				String column[] = null;

				try {
					Connection connection = DBConnection.getConnection();

					PreparedStatement query = connection.prepareStatement(
							"select * from product where product_id=?",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					query.setString(1, productId);

					ResultSet resultSet = query.executeQuery();

					if (resultSet.next()) {

						ResultSetMetaData resultSetMetaData = resultSet
								.getMetaData();

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
					} else {
						try {
							JOptionPane.showMessageDialog(mainFrame, "Prodcut not found!");
						} catch (Exception e2) {
							System.out.println("Error: " + e2);
						}
					}

				} catch (Exception e2) {
					System.out.println("Through error from viewProduct: " + e2);
				}

				JTable table = new JTable(data, column);
				table.setBounds(30, 40, 200, 300);
				JScrollPane scrollPane = new JScrollPane(table);

				mainFrame.add(scrollPane);

				mainFrame.setSize(500, 500);
				mainFrame.setVisible(true);
			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(150, 200, 200, 40);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Customer.main(new String[] {});
				mainFrame.dispose();
			}
		});

		mainFrame.add(welcomeLabel);
		mainFrame.add(setProductIdLabel);
		mainFrame.add(setProductIdTextField);
		mainFrame.add(viewProductByIdButton);
		mainFrame.add(backButton);

		mainFrame.setSize(500, 500);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new ViewProductById();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
