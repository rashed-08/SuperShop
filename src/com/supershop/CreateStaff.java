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
public class CreateStaff {

	public CreateStaff() {
		JFrame mainFrame = new JFrame("Super Shop");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel createNewStaffLabel = new JLabel("Create New Staff");
		createNewStaffLabel.setBounds(150, 50, 200, 50);
		
		JLabel staffUsernameLabel = new JLabel("Username: ");
		staffUsernameLabel.setBounds(50, 100, 200, 50);

		JTextField staffUsernameTextField = new JTextField();
		staffUsernameTextField.setBounds(150, 100, 250, 40);

		JLabel staffPasswordLabel = new JLabel("Password: ");
		staffPasswordLabel.setBounds(50, 150, 200, 50);

		JPasswordField staffPasswordTextField = new JPasswordField();
		staffPasswordTextField.setBounds(150, 150, 250, 40);
		
		JLabel staffEmailLabel = new JLabel("Email: ");
		staffEmailLabel.setBounds(50, 200, 200, 50);

		JTextField staffEmailTextField = new JTextField();
		staffEmailTextField.setBounds(150, 200, 250, 40);
		
		String role[] = { "SalesStaff", "WarehouseStaff"};

		JLabel userRoleLabel = new JLabel("Select Employee Role: ");
		userRoleLabel.setBounds(50, 250, 250, 40);
		JComboBox userRoleComboBox = new JComboBox(role);
		userRoleComboBox.setBounds(220, 250, 180, 40);
		
		JButton createStaffButton = new JButton("Create Staff");
		createStaffButton.setBounds(150, 300, 200, 40);
		
		createStaffButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = staffUsernameTextField.getText();
				String password = new String(staffPasswordTextField.getPassword());
				String email = staffEmailTextField.getText();
				String userRole = (String) userRoleComboBox.getItemAt(userRoleComboBox.getSelectedIndex());
				int createStuff = StaffDao.updateStockByWarehouseStaff(username, password, email, userRole);
				if (createStuff > 0) {
					JOptionPane.showMessageDialog(mainFrame, "You have successfully create new stuff");
					Manager.main(new String[]{});
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Something went wrong!");
				}
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(150, 350, 200, 40);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.main(new String[] {});
				mainFrame.dispose();
			}
		});
		
		mainFrame.add(createNewStaffLabel);
		mainFrame.add(staffUsernameLabel);
		mainFrame.add(staffUsernameTextField);
		mainFrame.add(staffPasswordLabel);
		mainFrame.add(staffPasswordTextField);
		mainFrame.add(staffEmailLabel);
		mainFrame.add(staffEmailTextField);
		mainFrame.add(userRoleLabel);
		mainFrame.add(userRoleComboBox);
		mainFrame.add(createStaffButton);
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
					new CreateStaff();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
