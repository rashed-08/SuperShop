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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * @author romantic-coder
 *
 */
public class OverridePrice {

	
	public OverridePrice() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel overridePriceWelcomeLabel = new JLabel("Override Product Price");
		overridePriceWelcomeLabel.setBounds(150, 50, 250, 40);
		
		JLabel productIdLabel = new JLabel("Product Id:");
		productIdLabel.setBounds(50, 100, 200, 40);
		
		JTextField productIdTextField = new JTextField();
		productIdTextField.setBounds(150, 100, 200, 40);
		
		JLabel productPriceOverrideLabel = new JLabel("Override price: ");
		productPriceOverrideLabel.setBounds(40, 150, 250, 40);

		JTextField productPriceOverrideTextField = new JTextField();
		productPriceOverrideTextField.setBounds(150, 150, 200, 40);
		
		JButton setPriceButton = new JButton("Set Price");
		setPriceButton.setBounds(200, 200, 150, 40);
		
		setPriceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productId = productIdTextField.getText();
				int overridePrice = Integer.parseInt(productPriceOverrideTextField.getText());
				int setOverridedPrice = ManagerDao.overridePrice(productId, overridePrice);
				if (setOverridedPrice > 0) {
					JOptionPane.showMessageDialog(mainFrame,
							"Successfully added product.");
					Manager.main(new String[] {});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame,
							"Sorry, unable to override price!");
				}
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 250, 100, 40);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		mainFrame.add(overridePriceWelcomeLabel);
		mainFrame.add(productIdLabel);
		mainFrame.add(productIdTextField);
		mainFrame.add(productPriceOverrideLabel);
		mainFrame.add(productPriceOverrideTextField);
		mainFrame.add(setPriceButton);
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
					new OverridePrice();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
