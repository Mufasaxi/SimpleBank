package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CreateDepotPage implements ActionListener {
	public JFrame  frame = new JFrame();
	JLabel depotLabel = new JLabel("DEPOTKONTO");
	JLabel fillLabel = new JLabel("F�llen Sie die folgenden Felder aus");
	public JTextField referenceIDField = new JTextField();
	JLabel referenceIDLabel = new JLabel("Refernzkonto ID:");
	public JLabel idWarningLabel = new JLabel("Bitte nur Zahlen eingeben!");
	public JButton createButton = new JButton("Konto erstellen");

	User user;
	public String username;
	public Integer id;
	
	public CreateDepotPage(User user, String username) {
		this.user = user;
		this.username = username;
		
		depotLabel.setBounds(0,0,400,35);
		depotLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		fillLabel.setBounds(0,25,400,100);
		
		referenceIDLabel.setBounds(50,100,75,25);
		referenceIDField.setBounds(125,100,200,25);
		idWarningLabel.setBounds(150,150,200,25);
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

