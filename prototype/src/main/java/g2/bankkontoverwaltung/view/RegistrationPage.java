package g2.bankkontoverwaltung.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class RegistrationPage implements ActionListener{
	JFrame  frame = new JFrame();
	JLabel registerLabel = new JLabel("ANMELDUNG");
	JLabel fillLabel = new JLabel("F�llen Sie die folgenden Felder aus");
	JTextField nameField = new JTextField();
	JTextField addressField = new JTextField();
	JTextField userField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JPasswordField confirmPassField = new JPasswordField();
	JLabel nameLabel = new JLabel("name:");
	JLabel addressLabel = new JLabel("address:");
	JLabel userLabel = new JLabel("username:");
	JLabel passLabel = new JLabel("password:");
	JLabel confirmPassLabel = new JLabel("confirm password:");
	JButton createButton = new JButton("Anmelden");
	
	HashMap<String,String> loginData = new HashMap<String,String>();
	
	RegistrationPage(HashMap<String, String> originalLoginData){
		this.loginData = originalLoginData;
		
		registerLabel.setBounds(0,0,400,35);
		registerLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		fillLabel.setBounds(0,25,400,100);
		
		nameLabel.setBounds(50,100,75,25);
		addressLabel.setBounds(50,150,75,25);
		userLabel.setBounds(50,200,75,25);
		passLabel.setBounds(50,250,75,25);
		confirmPassLabel.setBounds(15,300,150,25);
		
		nameField.setBounds(125,100,200,25);
		addressField.setBounds(125,150,200,25);
		userField.setBounds(125,200,200,25);
		passField.setBounds(125,250,200,25);
		confirmPassField.setBounds(125,300,200,25);
		
		createButton.setBounds(125,350,100,25);
		createButton.setFocusable(false);
		createButton.addActionListener(this);
		
		frame.add(createButton);
		frame.add(addressLabel);
		frame.add(nameLabel);
		frame.add(userLabel);
		frame.add(passLabel);
		frame.add(confirmPassLabel);
		frame.add(addressField);
		frame.add(nameField);
		frame.add(userField);
		frame.add(passField);
		frame.add(confirmPassField);
		frame.add(fillLabel);
		frame.add(registerLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==createButton) {
			System.out.println(this.loginData);
			System.out.println("creating");
			if(this.loginData.containsKey(userField.getText())) {
				System.out.println("username already exists choose another");
			}
		}
		
	}

}
