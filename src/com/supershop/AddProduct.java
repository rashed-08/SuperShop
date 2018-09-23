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
public class AddProduct {

	public AddProduct() {
		
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel productAddLabel = new JLabel("Add new product");
		productAddLabel.setBounds(150, 50, 150, 40);

		JLabel productIdLabel = new JLabel("Product ID: ");
		productIdLabel.setBounds(50, 100, 150, 40);

		JTextField productIdTextField = new JTextField();
		productIdTextField.setBounds(200, 100, 300, 40);

		JLabel productNameLabel = new JLabel("Product Name: ");
		productNameLabel.setBounds(50, 150, 150, 40);

		JTextField productNameTextField = new JTextField();
		productNameTextField.setBounds(200, 150, 300, 40);

		JLabel productStockLabel = new JLabel("Product Stock: ");
		productStockLabel.setBounds(50, 200, 150, 40);

		JTextField productStockTextField = new JTextField();
		productStockTextField.setBounds(200, 200, 300, 40);

		JLabel productUnitPriceLabel = new JLabel("Unit Price: ");
		productUnitPriceLabel.setBounds(50, 250, 150, 40);

		JTextField productUnitPriceTextField = new JTextField();
		productUnitPriceTextField.setBounds(200, 250, 300, 40);

		JLabel productSalePriceLabel = new JLabel("Sale Price: ");
		productSalePriceLabel.setBounds(50, 300, 150, 40);

		JTextField productSalePriceTextField = new JTextField();
		productSalePriceTextField.setBounds(200, 300, 300, 40);

		JLabel productOfferDiscountLabel = new JLabel("Offer Discount: ");
		productOfferDiscountLabel.setBounds(50, 350, 150, 40);

		JTextField productOfferDiscountTextField = new JTextField();
		productOfferDiscountTextField.setBounds(200, 350, 300, 40);

		JButton saveProduct = new JButton("Save Product");
		saveProduct.setBounds(200, 400, 150, 40);

		JButton backButton = new JButton("Back");
		backButton.setBounds(200, 450, 150, 40);

		saveProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String productId = productIdTextField.getText();
				String productName = productNameTextField.getText();
				int Stock = Integer.parseInt(productStockTextField.getText());
				int unitPrice = Integer.parseInt(productUnitPriceTextField
						.getText());
				int salePrice = Integer.parseInt(productSalePriceTextField
						.getText());
				int discountPercentage = Integer
						.parseInt(productOfferDiscountTextField.getText());

				/*
				 * There are two case, sometimes you want add the product with discount or sometime without discount
				 * For this reason, divide two condition. In the calculation, you may confused.
				 * suppose sale price = 10$, discount = 10%
				 * so discountMoney = (10*10)/100 = 1.00.
				 * if you check then you can see, It's output 1. why? Because int to double or double to int
				 * auto casted by compiler. that's why you see the output is only 1.
				 * 
				 * */
				
				if (discountPercentage > 0) {
					int discountMoney = (salePrice * discountPercentage) / 100 ;
					salePrice = (salePrice - discountMoney);
					int saveProduct = ManagerDao.saveProductWithDiscount(
							productId, productName, unitPrice,
							discountPercentage, salePrice, Stock);
					if (saveProduct > 0) {
						//JOptionPane is a JFrame pop-up dialog box
						JOptionPane.showMessageDialog(mainFrame,
								"Successfully added product.");
						Manager.main(new String[] {});
						//When leave this method, then close this thread. As a result, close the component of this frame.
						mainFrame.dispose();
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"Sorry, unable to save!");
					}
				} else {
					int saveProduct = ManagerDao
							.saveProductWithoutDiscount(productId, productName,
									unitPrice, salePrice, Stock);
					if (saveProduct > 0) {
						JOptionPane.showMessageDialog(mainFrame,
								"Successfully added product.");
						Manager.main(new String[] {});
						mainFrame.dispose();
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"Sorry, unable to save!");
					}
				}

			}
		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.main(new String[] {});
				mainFrame.dispose();
			}
		});

		mainFrame.add(productAddLabel);
		mainFrame.add(productIdLabel);
		mainFrame.add(productIdTextField);
		mainFrame.add(productNameLabel);
		mainFrame.add(productNameTextField);
		mainFrame.add(productStockLabel);
		mainFrame.add(productStockTextField);
		mainFrame.add(productUnitPriceLabel);
		mainFrame.add(productUnitPriceTextField);
		mainFrame.add(productSalePriceLabel);
		mainFrame.add(productSalePriceTextField);
		mainFrame.add(productOfferDiscountLabel);
		mainFrame.add(productOfferDiscountTextField);
		mainFrame.add(backButton);
		mainFrame.add(saveProduct);

		mainFrame.setSize(600, 600);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new AddProduct();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
