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
public class CreateCustomer {

	public CreateCustomer() {
		JFrame mainFrame = new JFrame("Super Shop");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel createNewAccountLabel = new JLabel("Create New Account");
		createNewAccountLabel.setBounds(150, 50, 200, 50);

		JLabel customerNameLabel = new JLabel("Customer Name: ");
		customerNameLabel.setBounds(50, 100, 200, 50);

		JTextField customerNameTextField = new JTextField();
		customerNameTextField.setBounds(200, 100, 250, 40);

		JLabel customerAddressLabel = new JLabel("Customer Address: ");
		customerAddressLabel.setBounds(50, 150, 200, 50);

		JTextField customerAddressTextField = new JTextField();
		customerAddressTextField.setBounds(200, 150, 250, 40);

		JLabel customerUsernameLabel = new JLabel("Username: ");
		customerUsernameLabel.setBounds(50, 200, 200, 50);

		JTextField customerUsernameTextField = new JTextField();
		customerUsernameTextField.setBounds(200, 200, 250, 40);

		JLabel customerPasswordLabel = new JLabel("Password: ");
		customerPasswordLabel.setBounds(50, 250, 200, 50);

		JPasswordField customerPasswordTextField = new JPasswordField();
		customerPasswordTextField.setBounds(200, 250, 250, 40);

		JLabel customerCreditCardLabel = new JLabel("Credit Card No: ");
		customerCreditCardLabel.setBounds(50, 300, 200, 50);

		JTextField customerCreditCardTextField = new JTextField();
		customerCreditCardTextField.setBounds(200, 300, 250, 40);

		JLabel customerCreditCardBalanceLabel = new JLabel(
				"Credit Card Balance: ");
		customerCreditCardBalanceLabel.setBounds(50, 350, 200, 50);

		JTextField customerCreditCardBalanceTextField = new JTextField();
		customerCreditCardBalanceTextField.setBounds(200, 350, 250, 40);

		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(250, 450, 200, 40);

		createAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String customerName = customerNameTextField.getText();
				String customerUsername = customerUsernameTextField.getText();
				String customerPassword = new String(customerPasswordTextField
						.getPassword());
				int userCreditCardNo = Integer
						.parseInt(customerCreditCardTextField.getText());
				int userCreditCardBalance = Integer
						.parseInt(customerCreditCardBalanceTextField.getText());
				int createCustomer = CustomerDao.createCustomer(customerName,
						customerUsername, customerPassword, userCreditCardNo,
						userCreditCardBalance);
				if (createCustomer > 0) {
					JOptionPane.showMessageDialog(mainFrame,
							"You have successfully created new account.");
					Login.main(new String[] {});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Something went wrong while creating account!");
				}
			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(250, 500, 100, 40);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(new String[] {});
				mainFrame.dispose();
			}
		});

		mainFrame.add(createNewAccountLabel);
		mainFrame.add(customerNameLabel);
		mainFrame.add(customerNameTextField);
		mainFrame.add(customerAddressLabel);
		mainFrame.add(customerAddressTextField);
		mainFrame.add(customerUsernameLabel);
		mainFrame.add(customerUsernameTextField);
		mainFrame.add(customerPasswordLabel);
		mainFrame.add(customerPasswordTextField);
		mainFrame.add(customerCreditCardLabel);
		mainFrame.add(customerCreditCardTextField);
		mainFrame.add(customerCreditCardBalanceLabel);
		mainFrame.add(customerCreditCardBalanceTextField);
		mainFrame.add(createAccountButton);
		mainFrame.add(backButton);

		mainFrame.setSize(500, 600);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new CreateCustomer();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
