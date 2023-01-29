package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CreateDepotPage implements ActionListener {
	JFrame  frame = new JFrame();
	JLabel depotLabel = new JLabel("DEPOTKONTO");
	JLabel fillLabel = new JLabel("F�llen Sie die folgenden Felder aus");
	JTextField referenceIDField = new JTextField();
	JLabel referenceIDLabel = new JLabel("Refernzkonto ID:");
	JLabel idWarningLabel = new JLabel("Bitte nur Zahlen eingeben!");
	JButton createButton = new JButton("Konto erstellen");

	User user;
	String username;
	Integer id;
	
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
		if(e.getSource()==createButton) {
			System.out.println("create clicked");
			System.out.println(referenceIDField.getText());
			System.out.println(username);
			
			// if data entered is float
			try {
				idWarningLabel.setVisible(false);
				this.id = Integer.parseInt(referenceIDField.getText());
				frame.dispose();
				DepotOverviewPage overViewPage = new DepotOverviewPage(user, username, id);
			// if data entered is not float
			}catch(NumberFormatException nfe){
				referenceIDField.setText("");
				idWarningLabel.setVisible(true);
			}
			
		}
		
	}

}
