package g2.bankkontoverwaltung.view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class LoginPage implements ActionListener{
	JFrame  frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton newUserButton = new JButton("Neue Kunde");
	JTextField userField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JLabel userLabel = new JLabel("username:");
	JLabel passLabel = new JLabel("password:");
	JLabel loginMessageLabel = new JLabel();
	
	HashMap<String,String> loginData = new HashMap<String,String>();
	
	LoginPage(HashMap<String, String> originalLoginData){
		
		this.loginData = originalLoginData;
		
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
		//creates new user account
		if(e.getSource()==newUserButton) {
			System.out.println("new user create");
			//leads to new page related to creating user
			RegistrationPage registrationPage = new RegistrationPage(loginData);
		}
		
		//reset text fields if user wants to erase what they wrote
		else if(e.getSource()==resetButton) {
			userField.setText("");
			passField.setText("");
			loginMessageLabel.setText("");
			frame.dispose();
			//REMOVE AFTER TESTING
			WelcomePage welcomePage = new WelcomePage(null,null);//shortcut for testing
		}
		
		//logs user in after verifying login data
		else if(e.getSource()==loginButton) {
			String user = userField.getText();
			String pass = String.valueOf(passField.getPassword());
			
			//checks if entered login data matches the data stored in the hash map
			if(loginData.containsKey(user)) {
				if(loginData.get(user).equals(pass)) {
					loginMessageLabel.setForeground(Color.green);
					loginMessageLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(user,null);
				}else {
					loginMessageLabel.setForeground(Color.red);
					loginMessageLabel.setText("Wrong Login Data");
				}
			//if no data entered same error message shown on screen
			}else {
				loginMessageLabel.setForeground(Color.red);
				loginMessageLabel.setText("Wrong Login Data");
			}
		}
		
		
	}
	
}
