package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.storage.JsonReader;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class RegistrationPage implements ActionListener{
	public JFrame  frame = new JFrame("Registration");
	JLabel registerLabel = new JLabel("REGISTRATION");
	JLabel fillLabel = new JLabel("Please fill out the following fields");
	public JTextField nameField = new JTextField();
	public JTextField addressField = new JTextField();
	public JTextField userField = new JTextField();
	public JPasswordField passField = new JPasswordField();
	JLabel nameLabel = new JLabel("name:");
	JLabel addressLabel = new JLabel("address:");
	JLabel userLabel = new JLabel("username:");
	JLabel passLabel = new JLabel("password:");
	public JButton createButton = new JButton("Register");
	public JLabel passWarningLabel = new JLabel("The password must be atleast 9 characters long!");

	private User user;
	String password;

	public RegistrationPage(User user){
		this.user = user;
		
		registerLabel.setBounds(0,0,400,35);
		registerLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		fillLabel.setBounds(0,25,400,100);
		
		nameLabel.setBounds(50,100,75,25);
		addressLabel.setBounds(50,150,75,25);
		userLabel.setBounds(50,200,75,25);
		passLabel.setBounds(50,250,75,25);
		passWarningLabel.setBounds(15,325,350,25);
		passWarningLabel.setVisible(false);
		
		nameField.setBounds(125,100,200,25);
		addressField.setBounds(125,150,200,25);
		userField.setBounds(125,200,200,25);
		passField.setBounds(125,250,200,25);
		
		createButton.setBounds(125,350,100,25);
		createButton.setFocusable(false);
		createButton.addActionListener(this);
		

		frame.add(passWarningLabel);
		frame.add(createButton);
		frame.add(addressLabel);
		frame.add(nameLabel);
		frame.add(userLabel);
		frame.add(passLabel);
		frame.add(addressField);
		frame.add(nameField);
		frame.add(userField);
		frame.add(passField);
		frame.add(fillLabel);
		frame.add(registerLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		user.actionPerformed(e);
	}

}
