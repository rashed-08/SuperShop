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

/**
 * @author romantic-coder
 *
 */
public class Customer {

	public Customer() {
		JFrame mainFrame = new JFrame("Super Shop");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel customerWelcomeLabel = new JLabel("Welcome to Super Shop");
		customerWelcomeLabel.setBounds(150, 50, 200, 30);

		JButton viewProductButton = new JButton("View Product");
		viewProductButton.setBounds(150, 100, 200, 40);
		
		viewProductButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewProduct.main(new String[] {});
			}
		});
		
		JButton viewProductByIdButton = new JButton("View Product by Id");
		viewProductByIdButton.setBounds(150, 150, 200, 40);
		
		viewProductByIdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewProductById.main(new String[] {});
			}
		});
		
		JButton purchaseProductButton = new JButton("Purchase Products");
		purchaseProductButton.setBounds(150, 200, 200, 40);
		
		purchaseProductButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PurchaseProduct.main(new String[] {});
				
			}
		});
		
		JButton logout = new JButton("Logout");
		logout.setBounds(150, 250, 200, 40);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		mainFrame.add(customerWelcomeLabel);
		mainFrame.add(purchaseProductButton);
		mainFrame.add(viewProductButton);
		mainFrame.add(viewProductByIdButton);
		mainFrame.add(logout);
		
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new Customer();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
