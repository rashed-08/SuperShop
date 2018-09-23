/**
 * 
 */
package com.supershop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author romantic-coder
 *
 */
public class Login {

	public Login() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// For User Name
		JLabel userNameLabel = new JLabel("Username: ");
		userNameLabel.setBounds(50, 50, 100, 40);
		JTextField userNameTextField = new JTextField();
		userNameTextField.setBounds(150, 50, 200, 40);

		// For Password
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(50, 100, 100, 40);
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setBounds(150, 100, 200, 40);

		String roll[] = { "Manager", "SalesStaff", "WarehouseStaff", "Customer" };

		// For User Name
		JLabel userRoleLabel = new JLabel("User Role: ");
		userRoleLabel.setBounds(50, 150, 100, 40);
		JComboBox comboBox = new JComboBox(roll);
		comboBox.setBounds(150, 150, 200, 40);

		// Login Button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(250, 200, 100, 40);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userName = userNameTextField.getText();
				String password = String.valueOf(passwordTextField
						.getPassword());
				String role = (String) comboBox.getItemAt(comboBox
						.getSelectedIndex());

				String userRole = LoginDao.checkValid(userName, password, role);

				if (userRole.equals("Manager")) {
					try {
						new Manager();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else if (userRole.equals("SalesStaff")) {
					try {
						new SalesStaff();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else if (userRole.equals("WarehouseStaff")) {
					try {
						new WarehouseStaff();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else if (userRole.equals("Customer")) {
					try {
						new Customer();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Something went wrong! Please try again.");
				}
			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(250, 250, 100, 40);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(new String[] {});
				mainFrame.dispose();

			}
		});

		mainFrame.add(userNameLabel);
		mainFrame.add(userNameTextField);
		mainFrame.add(passwordLabel);
		mainFrame.add(passwordTextField);
		mainFrame.add(userRoleLabel);
		mainFrame.add(comboBox);
		mainFrame.add(loginButton);
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
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
