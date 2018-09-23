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
public class SalesStaff {

	public SalesStaff() {
		JFrame mainFrame = new JFrame("Super Shop");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel salesStaffWelcomeLabel = new JLabel("Welcome Sales Staff");
		salesStaffWelcomeLabel.setBounds(150, 50, 200, 30);

		JButton removeItemButton = new JButton("Remove Item");
		removeItemButton.setBounds(150, 100, 200, 40);

		removeItemButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveItem.main(new String[] {});

			}
		});

		JButton cancelPurchaseButton = new JButton("Cancel Purchase");
		cancelPurchaseButton.setBounds(150, 150, 200, 40);

		cancelPurchaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CancelPurchase.main(new String[] {});
			}
		});
		
		JButton logout = new JButton("Logout");
		logout.setBounds(150, 200, 200, 40);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				mainFrame.dispose();
			}
		});

		mainFrame.add(salesStaffWelcomeLabel);
		mainFrame.add(removeItemButton);
		mainFrame.add(cancelPurchaseButton);
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
					new SalesStaff();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
