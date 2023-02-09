package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CreateDepotPage implements ActionListener {
	public JFrame  frame = new JFrame("Create Depot");
	JLabel depotLabel = new JLabel("DEPOT ACCOUNTS");
	JLabel fillLabel = new JLabel("Please fill out the following fields");
	public JTextField referenceIDField = new JTextField();
	JLabel referenceIDLabel = new JLabel("Reference Account ID:");
	public JLabel idWarningLabel = new JLabel("Please only enter positive numbers!");
	public JButton createButton = new JButton("Create account");

	User user;
	public String username;
	public Integer id;
	
	public CreateDepotPage(User user, String username) {
		this.user = user;
		this.username = username;
		
		depotLabel.setBounds(0,0,400,35);
		depotLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		fillLabel.setBounds(0,25,400,100);
		
		referenceIDLabel.setBounds(0,100,150,25);
		referenceIDField.setBounds(150,100,200,25);
		idWarningLabel.setBounds(150,150,225,25);
		idWarningLabel.setVisible(false);
		
		createButton.setBounds(175,125,150,25);
		createButton.setFocusable(false);
		createButton.addActionListener(this);
		
		frame.add(idWarningLabel);
		frame.add(createButton);
		frame.add(referenceIDLabel);
		frame.add(referenceIDField);
		frame.add(fillLabel);
		frame.add(depotLabel);
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

