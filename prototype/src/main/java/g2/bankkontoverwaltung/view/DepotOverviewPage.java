package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.model.Depotkonto;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DepotOverviewPage implements ActionListener{
	
	public JFrame  frame = new JFrame();
	JLabel overviewLabel = new JLabel("�BERSICHT");
	JLabel userLabel = new JLabel();
	JLabel referenceIDLabel = new JLabel();
	public JButton functionsButton = new JButton("Funktionen");

	User user;
	public String username;
	Integer id;
	
	public DepotOverviewPage(User user, Depotkonto konto){
		this.user = user;
		this.username = konto.getBenutzername();
		this.id = konto.getId();
		
		userLabel.setText("username: "+ username );
		userLabel.setBounds(0,25,100,100);
		
		referenceIDLabel.setText("reference ID: "+ konto.getReferenzkonten().toString());
		referenceIDLabel.setBounds(0,50,100,100);
		
		overviewLabel.setBounds(0,0,400,35);
		overviewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		functionsButton.setBounds(175,125,150,25);
		functionsButton.setFocusable(false);
		functionsButton.addActionListener(this);
		
		frame.add(functionsButton);
		frame.add(referenceIDLabel);
		frame.add(userLabel);
		frame.add(overviewLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//returns to main page
		user.actionPerformed(e);
		
	}

}
