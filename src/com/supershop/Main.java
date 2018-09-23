package com.supershop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
*	This is a standalone java application which is developed by Java Swing framework. 
*	Swing framework is nothing but it's simple and lightweight GUI (Graphical User Interface) framework.
*/

public class Main {

	public Main() {
		
		//JFrame is a base frame for swing project. You can do it by two ways, one of them is, extends the JFrame and
		//Another way is creating JFrame object. It's parameter goes to page title. 
		JFrame mainFrame = new JFrame("Super Shop");
		//it's necessary when you like to close the window also close the thread.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//JButton is nothing but a normal button. which is work like other button.
		JButton salesStaffButton = new JButton("Login");
		/*setBounds is basically set the element position, the first parameter is going to set x axis of the element
		from left side, second parameter is going to set y axis of the element from top side, third parameter is going
		to set the element width from most left wide where the showing element started, fourth one is also height of 
		the element.*/
		salesStaffButton.setBounds(100, 150, 200, 40);
		//addActionListener is a method, which create and run a thread for a specific button. that's why this thread add 
		//into the button
		salesStaffButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//It's just a trick for going to another class 
				Login.main(new String[] {});

			}
		});

		JButton createCustomerButton = new JButton("Create Customer");
		createCustomerButton.setBounds(100, 200, 200, 40);
		createCustomerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateCustomer.main(new String[] {});

			}
		});

		//All of the label, text field, button and many other things you should add to the JFrame. Because all of the 
		//GUI element handle by the JFrame.
		mainFrame.add(salesStaffButton);
		mainFrame.add(createCustomerButton);

		//setSize is nothing, but it's a window which is show you all the front end things in this fixed dimension window.
		//Here first parameter is going to set window height, second one is going to window width.
		mainFrame.setSize(500, 500);
		//There various layout, but for this project, I'll not use any layout. that's why it's null
		mainFrame.setLayout(null);
		//It's basically the gui element show to you.
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		//EventQueue is a platform-independent class that queues events, both from the underlying peer 
		//classes and from trusted application classes. Causes runnable to have its run method called in the dispatch 
		//thread of the system EventQueue. This will happen after all pending events are processed.
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					//This is for run itself using the thread.
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
