package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CreateDepotPage implements ActionListener {
	JFrame  frame = new JFrame();
	JLabel depotLabel = new JLabel("DEPOTKONTO");
	JLabel fillLabel = new JLabel("F�llen Sie die folgenden Felder aus");
	JTextField startSaldoField = new JTextField();
	JLabel saldoLabel = new JLabel("Start Saldo:");
	JLabel saldoWarningLabel = new JLabel("Bitte nur Zahlen eingeben!");
	JButton createButton = new JButton("Konto erstellen");

	User user;
	String username;
	Float saldo;
	
	public CreateDepotPage(User user, String username) {
		this.user = user;
		this.username = username;
		
		depotLabel.setBounds(0,0,400,35);
		depotLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		fillLabel.setBounds(0,25,400,100);
		
		saldoLabel.setBounds(50,100,75,25);
		startSaldoField.setBounds(125,100,200,25);
		saldoWarningLabel.setBounds(150,150,200,25);
		saldoWarningLabel.setVisible(false);
		
		createButton.setBounds(175,125,150,25);
		createButton.setFocusable(false);
		createButton.addActionListener(this);
		
		frame.add(saldoWarningLabel);
		frame.add(createButton);
		frame.add(saldoLabel);
		frame.add(startSaldoField);
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
			System.out.println(startSaldoField.getText());
			System.out.println(username);
			
			// if data entered is float
			try {
				saldoWarningLabel.setVisible(false);
				this.saldo = Float.parseFloat(startSaldoField.getText());
				frame.dispose();
				DepotOverviewPage overViewPage = new DepotOverviewPage(user, username, saldo);
			// if data entered is not float
			}catch(NumberFormatException nfe){
				startSaldoField.setText("");
				saldoWarningLabel.setVisible(true);
			}
			
		}
		
	}

}
