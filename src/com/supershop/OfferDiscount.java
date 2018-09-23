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
public class OfferDiscount {
	
	public OfferDiscount() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel welcomeLabel = new JLabel("Set Product Offer Amount");
		welcomeLabel.setBounds(150, 50, 250, 40);
		
		JLabel takeProductIdLabel = new JLabel("Product Id: ");
		takeProductIdLabel.setBounds(180, 100, 250, 40);
		
		JTextField takeProductIdTextField = new JTextField();
		takeProductIdTextField.setBounds(280, 100, 190, 40);
		
		JLabel offerAmountLabel = new JLabel("Amount of offer (In percentage):");
		offerAmountLabel.setBounds(30, 150, 250, 40);
		
		JTextField offerAmountTextField = new JTextField();
		offerAmountTextField.setBounds(280, 150, 190, 40);
		
		JButton setOfferAmountButton = new JButton("Update Offer Discount");
		setOfferAmountButton.setBounds(280, 200, 200, 40);
		
		setOfferAmountButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productId = takeProductIdTextField.getText();
				int discountAmount = Integer.parseInt(offerAmountTextField.getText());
				int setDiscountAmount = ManagerDao.updateDiscountOffer(productId, discountAmount);
				if (setDiscountAmount > 0) {
					JOptionPane.showMessageDialog(mainFrame,
							"Successfully updated discount amount.");
					Manager.main(new String[] {});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame,
							"Sorry, unable to update!");
				}
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(280, 250, 100, 40);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.main(new String[] {});
				mainFrame.dispose();
				
			}
		});
		
		mainFrame.add(welcomeLabel);
		mainFrame.add(takeProductIdLabel);
		mainFrame.add(takeProductIdTextField);
		mainFrame.add(offerAmountLabel);
		mainFrame.add(offerAmountTextField);
		mainFrame.add(setOfferAmountButton);
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
					new OfferDiscount();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
