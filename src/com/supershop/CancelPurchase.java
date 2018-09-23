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
public class CancelPurchase {

	public CancelPurchase() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel welcomeLabel = new JLabel("Cancel Purchase");
		welcomeLabel.setBounds(150, 50, 250, 40);

		JLabel setUsernameLabel = new JLabel("Your Username: ");
		setUsernameLabel.setBounds(50, 100, 150, 40);

		JTextField setUsernameTextField = new JTextField();
		setUsernameTextField.setBounds(200, 100, 150, 40);

		JButton purchaseButton = new JButton("Cancel Purchase");
		purchaseButton.setBounds(100, 150, 200, 40);

		JButton backButton = new JButton("Back");
		backButton.setBounds(100, 200, 200, 40);

		purchaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = setUsernameTextField.getText();
				if (username == null || username == ""){
					JOptionPane.showMessageDialog(mainFrame, "Username can't be empty!");
				} else {
					int cancelPurchase = StaffDao.cancelPurchase(username);
					if (cancelPurchase > 0) {
						JOptionPane.showMessageDialog(mainFrame, "Successfully cancel user purchase!");
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
					new CancelPurchase();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
