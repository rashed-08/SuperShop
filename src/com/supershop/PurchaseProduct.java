/**
 * 
 */
package com.supershop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author romantic-coder
 *
 */
public class PurchaseProduct {

	public PurchaseProduct() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel welcomeLabel = new JLabel("Purchase Product");
		welcomeLabel.setBounds(150, 50, 250, 40);

		JLabel setProductIdLabel = new JLabel("Product Id: ");
		setProductIdLabel.setBounds(50, 100, 150, 40);

		JTextField setProductIdTextField = new JTextField();
		setProductIdTextField.setBounds(200, 100, 150, 40);

		JLabel setUsernameLabel = new JLabel("Your Username: ");
		setUsernameLabel.setBounds(50, 150, 150, 40);

		JTextField setUsernameTextField = new JTextField();
		setUsernameTextField.setBounds(200, 150, 150, 40);

		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setBounds(200, 200, 100, 40);
		
		purchaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productId = setProductIdTextField.getText();
				String username = setUsernameTextField.getText();
				int check = CustomerDao.purchaseProduct(productId, username);
				if (check == 1) {
					JOptionPane.showMessageDialog(mainFrame, "Successfully purchase.");
					Customer.main(new String[]{});
					mainFrame.dispose();
				} else if (check == 2) {
					JOptionPane.showMessageDialog(mainFrame, "You don't have sufficient balance for purchase this product.");
					Customer.main(new String[]{});
					mainFrame.dispose();
				} else if (check==3){
					JOptionPane.showMessageDialog(mainFrame, "Product stock is empty. You can't bought this product. try again later.");
					Customer.main(new String[]{});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Unable purchase the product.");
					Customer.main(new String[]{});
					mainFrame.dispose();
				}
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 250, 100, 40);
		
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
		mainFrame.add(setUsernameLabel);
		mainFrame.add(setUsernameTextField);
		mainFrame.add(purchaseButton);
		mainFrame.add(backButton);

		mainFrame.setSize(500, 500);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PurchaseProduct();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
