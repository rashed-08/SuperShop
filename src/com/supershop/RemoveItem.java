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
public class RemoveItem {

	public RemoveItem() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel welcomeLabel = new JLabel("Remove Item");
		welcomeLabel.setBounds(150, 50, 250, 40);

		JLabel setProductIdLabel = new JLabel("Product Id: ");
		setProductIdLabel.setBounds(50, 100, 150, 40);

		JTextField setProductIdTextField = new JTextField();
		setProductIdTextField.setBounds(200, 100, 200, 40);

		JLabel setUsernameLabel = new JLabel("Customer username: ");
		setUsernameLabel.setBounds(50, 150, 150, 40);

		JTextField setUsernameTextField = new JTextField();
		setUsernameTextField.setBounds(200, 150, 200, 40);

		JButton purchaseButton = new JButton("Remove Item");
		purchaseButton.setBounds(200, 200, 150, 40);

		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 250, 150, 40);

		purchaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String productId = setProductIdTextField.getText();
				String userId = setUsernameTextField.getText();

				if ((productId == null || userId == null)
						|| (productId == "" || userId == "")||(productId == null && userId == null) || (productId == "" && userId == "")) {
					JOptionPane.showMessageDialog(mainFrame,
							"Product ID or Username can't be empty!");
				} else {
					int removeItem = StaffDao.removeItem(userId, productId);
					if (removeItem > 0) {
						JOptionPane.showMessageDialog(mainFrame,
								"Successfully remove item from list");
						SalesStaff.main(new String[] {});
						mainFrame.dispose();
					} else {
						JOptionPane.showMessageDialog(mainFrame, "Something went wrong!");
					}
				}

			}
		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalesStaff.main(new String[] {});
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

			@Override
			public void run() {
				try {
					new RemoveItem();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
