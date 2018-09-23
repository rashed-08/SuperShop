/**
 * 
 */
package com.supershop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author romantic-coder
 *
 */
public class Manager {

	public Manager() {
		JFrame mainFrame = new JFrame("Super Shop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Welcome Manager");
		label.setBounds(150, 50, 200, 30);

		JButton addProductButton = new JButton("Add Product");
		addProductButton.setBounds(120, 100, 200, 40);

		addProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddProduct.main(new String[] {});
			}
		});

		JButton overRidePriceButton = new JButton("Override Price");
		overRidePriceButton.setBounds(120, 150, 200, 40);

		overRidePriceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OverridePrice.main(new String[] {});

			}
		});

		JButton offerDiscountButton = new JButton("Offer Discount");
		offerDiscountButton.setBounds(120, 200, 200, 40);

		offerDiscountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OfferDiscount.main(new String[] {});

			}
		});

		JButton generateSalesReportButton = new JButton("Generate Sales Report");
		generateSalesReportButton.setBounds(120, 250, 200, 40);

		generateSalesReportButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JasperReport jasperReport;
					JasperPrint jasperPrint;
					
					Connection connection = DBConnection.getConnection();
					
					HashMap jasperParameter = new HashMap();
					
					//Here is romantic-coder is my pc user name, it's replace by user pc user name.
					jasperReport = JasperCompileManager.compileReport("/home/romantic-coder/Sales Report.jrxml");
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameter, connection);
					
					File makeDirectory = new File("/home/romantic-coder/generate sales report");
					makeDirectory.mkdirs();
					
					JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/romantic-coder/generate sales report/sales_report.pdf");
					
					JOptionPane.showMessageDialog(mainFrame, "This report in saved in your drive.");
					
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}

			}
		});

		JButton generateRevenueReportButton = new JButton(
				"Generate Revenue Report");
		generateRevenueReportButton.setBounds(120, 300, 218, 40);

		generateRevenueReportButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JasperReport jasperReport;
					JasperPrint jasperPrint;
					
					JRDataSource dataSource = new JREmptyDataSource();;
					
					Connection connection = DBConnection.getConnection();
					
					HashMap jasperParameter = new HashMap();
					
					jasperReport = JasperCompileManager.compileReport("/home/romantic-coder/Revenue Report.jrxml");
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameter, connection);
					
					File makeDirectory = new File("/home/romantic-coder/generate revenue report");
					makeDirectory.mkdirs();
					
					JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/romantic-coder/generate revenue report/revenue_report.pdf");
					
					JOptionPane.showMessageDialog(mainFrame, "This report in saved in your drive.");
					
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}

			}
		});
		
		JButton createStaffButton = new JButton("Create Staff");
		createStaffButton.setBounds(120, 350, 200, 40);
		createStaffButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateStaff.main(new String[] {});

			}
		});

		JButton logout = new JButton("Logout");
		logout.setBounds(120, 400, 100, 40);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				mainFrame.dispose();
			}
		});

		mainFrame.add(label);
		mainFrame.add(addProductButton);
		mainFrame.add(overRidePriceButton);
		mainFrame.add(offerDiscountButton);
		mainFrame.add(generateSalesReportButton);
		mainFrame.add(generateRevenueReportButton);
		mainFrame.add(createStaffButton);
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
					new Manager();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

}
