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
public class ReplenishStock {

	public ReplenishStock() {
		JFrame mainFrame = new JFrame("Super Shop");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel createNewStaffLabel = new JLabel("Welcome Warehouse Staff");
		createNewStaffLabel.setBounds(150, 50, 200, 50);
		
		JLabel stockProductIDLabel = new JLabel("Product Id: ");
		stockProductIDLabel.setBounds(50, 100, 200, 50);

		JTextField stockProductIDTextField = new JTextField();
		stockProductIDTextField.setBounds(180, 100, 250, 40);
		
		JLabel stockLevelLabel = new JLabel("Stock Amount: ");
		stockLevelLabel.setBounds(50, 150, 200, 50);

		JTextField stockLevelTextField = new JTextField();
		stockLevelTextField.setBounds(180, 150, 250, 40);
		
		JButton setStock = new JButton("Create Staff");
		setStock.setBounds(150, 200, 250, 40);
		
		setStock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String productId = stockLevelTextField.getText();
				int stockLevel = Integer.parseInt(stockLevelTextField.getText());
				int stockLevelUp = StaffDao.replenishStock(productId, stockLevel);
				if (stockLevelUp > 0) {
					JOptionPane.showMessageDialog(mainFrame, "Successfully you have stock level up.");
					WarehouseStaff.main(new String[]{});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Something went wrong!");
				}
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(150, 250, 250, 40);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WarehouseStaff.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		mainFrame.add(createNewStaffLabel);
		mainFrame.add(stockProductIDLabel);
		mainFrame.add(stockProductIDTextField);
		mainFrame.add(stockLevelLabel);
		mainFrame.add(stockLevelTextField);
		mainFrame.add(setStock);
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
					new ReplenishStock();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
