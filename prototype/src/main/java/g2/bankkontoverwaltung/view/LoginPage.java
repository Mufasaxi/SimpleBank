package g2.bankkontoverwaltung.view;


import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.storage.JsonReader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.*;

public class LoginPage implements ActionListener{
	public JFrame  frame = new JFrame("Login");
	public JButton loginButton = new JButton("Login");
	public JButton resetButton = new JButton("Reset");
	public JButton newUserButton = new JButton("New User");
	public JTextField userField = new JTextField();
	public JPasswordField passField = new JPasswordField();
	JLabel userLabel = new JLabel("username:");
	JLabel passLabel = new JLabel("password:");
	public JLabel loginMessageLabel = new JLabel();

	private User user;

	public LoginPage(User user){
		this.user = user;

		userLabel.setBounds(50,100,75,25);
		passLabel.setBounds(50,150,75,25);
		
		//tells user if login data correct or not
		loginMessageLabel.setBounds(125,250,250,35);
		
		userField.setBounds(125,100,200,25);
		passField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		newUserButton.setBounds(160,225,125,25);
		newUserButton.setFocusable(false);
		newUserButton.addActionListener(this);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(loginMessageLabel);
		frame.add(userLabel);
		frame.add(passLabel);
		frame.add(userField);
		frame.add(passField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(newUserButton);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		user.actionPerformed(e);
	}
	
}
