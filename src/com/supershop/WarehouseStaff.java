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
public class WarehouseStaff {
	
	public WarehouseStaff() {
		JFrame mainFrame = new JFrame("Super Shop");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel warehouseWelcomeLabel = new JLabel("Welcome Warehouse Staff");
		warehouseWelcomeLabel.setBounds(150, 50, 200, 30);
		
		JButton replenishStockButton = new JButton("Replenish Stock");
		replenishStockButton.setBounds(150, 100, 200, 40);
		
		replenishStockButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ReplenishStock.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		JButton logout = new JButton("Logout");
		logout.setBounds(150, 150, 200, 40);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		mainFrame.add(warehouseWelcomeLabel);
		mainFrame.add(replenishStockButton);
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
					new WarehouseStaff();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
