package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DepotOverviewPage implements ActionListener{
	
	JFrame  frame = new JFrame();
	JLabel overviewLabel = new JLabel("�BERSICHT");
	JLabel userLabel = new JLabel();
	JLabel referenceIDLabel = new JLabel();
	JButton functionsButton = new JButton("Funktionen");

	User user;
	String username;
	Integer id;
	
	DepotOverviewPage(User user, String username, Integer id){
		this.user = user;
		this.username = username;
		this.id = id;
		
		userLabel.setText("username: "+ user );
		userLabel.setBounds(0,25,100,100);
		
		referenceIDLabel.setText("reference ID: "+ id);
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
		if(e.getSource()==functionsButton) {
			frame.dispose();
			WelcomePage welcomePage = new WelcomePage(user, username);
		}
		
	}

}
