package g2.bankkontoverwaltung.view;


import g2.bankkontoverwaltung.controller.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomePage implements ActionListener{
	
	public JFrame frame = new JFrame();
	JLabel functionsLabel = new JLabel("KONTO FUNKTIONEN");
	JLabel chooseLabel = new JLabel("W�hlen Sie eine der folgenden Funktionen");

	public JRadioButton newDepotButton = new JRadioButton("Depotkonto er�ffnen");
	public JRadioButton newGiroButton = new JRadioButton("Girokonto er�ffnen");
	public JRadioButton buyButton = new JRadioButton("Aktien kaufen");
	public JRadioButton sellButton = new JRadioButton("Aktien verkaufen");
	public JRadioButton showAssetsButton = new JRadioButton("Posten anzeigen");
	public JRadioButton overviewButton = new JRadioButton("Account Overview");

	public User user;
	public String username;

	Float saldo;
	
	public WelcomePage(User user, String username){
		this.user = user;
		this.username = username;

		functionsLabel.setBounds(0,0,400,35);
		functionsLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		chooseLabel.setBounds(0,25,400,100);
		
		
		//buttons
		ButtonGroup group = new ButtonGroup();
		group.add(buyButton);
		group.add(newDepotButton);
		group.add(sellButton);
		group.add(showAssetsButton);
		group.add(overviewButton);
		
		buyButton.addActionListener(this);
		sellButton.addActionListener(this);
		newDepotButton.addActionListener(this);
		showAssetsButton.addActionListener(this);
		newGiroButton.addActionListener(this);
		overviewButton.addActionListener(this);
		
		buyButton.setBounds(50,100,150,50);
		sellButton.setBounds(50,150,150,50);
		showAssetsButton.setBounds(50,200,150,50);
		newDepotButton.setBounds(50,250,150,50);
		newGiroButton.setBounds(50,300,150,50);
		overviewButton.setBounds(50,350,150,50);
		
		buyButton.setFocusable(false);
		sellButton.setFocusable(false);
		showAssetsButton.setFocusable(false);
		newDepotButton.setFocusable(false);
		newGiroButton.setFocusable(false);
		overviewButton.setFocusable(false);
		
		//frame
		frame.add(functionsLabel);
		frame.add(chooseLabel);
		frame.add(overviewButton);
		frame.add(buyButton);
		frame.add(sellButton);
		frame.add(newDepotButton);
		frame.add(newGiroButton);
		frame.add(showAssetsButton);
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
