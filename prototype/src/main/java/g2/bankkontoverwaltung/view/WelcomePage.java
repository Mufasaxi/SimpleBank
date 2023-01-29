package g2.bankkontoverwaltung.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomePage implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel functionsLabel = new JLabel("KONTO FUNKTIONEN");
	JLabel chooseLabel = new JLabel("W�hlen Sie eine der folgenden Funktionen");
	JRadioButton newDepotButton = new JRadioButton("Depotkonto er�ffnen");
	JRadioButton newGiroButton = new JRadioButton("Girokonto er�ffnen");
	JRadioButton buyButton = new JRadioButton("Aktien kaufen");
	JRadioButton sellButton = new JRadioButton("Aktien verkaufen");
	JRadioButton showAssetsButton = new JRadioButton("Posten anzeigen");
	String user;
	Float saldo;
	
	WelcomePage(String user, Float saldo){
		this.user = user;
		this.saldo = saldo;
		
		functionsLabel.setBounds(0,0,400,35);
		functionsLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		chooseLabel.setBounds(0,25,400,100);
		
		
		//buttons
		ButtonGroup group = new ButtonGroup();
		group.add(buyButton);
		group.add(newDepotButton);
		group.add(sellButton);
		group.add(showAssetsButton);
		
		buyButton.addActionListener(this);
		sellButton.addActionListener(this);
		newDepotButton.addActionListener(this);
		showAssetsButton.addActionListener(this);
		newGiroButton.addActionListener(this);
		
		buyButton.setBounds(50,100,150,50);
		sellButton.setBounds(50,150,150,50);
		showAssetsButton.setBounds(50,200,150,50);
		newDepotButton.setBounds(50,250,150,50);
		newGiroButton.setBounds(50,300,150,50);
		
		buyButton.setFocusable(false);
		sellButton.setFocusable(false);
		showAssetsButton.setFocusable(false);
		newDepotButton.setFocusable(false);
		newGiroButton.setFocusable(false);
		
		//frame
		frame.add(functionsLabel);
		frame.add(chooseLabel);
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
		if(e.getSource()==buyButton) {
			System.out.println("buy clicked");
			//leads to new page related to buying (NON CENTRAL)
		}else if(e.getSource()==sellButton) {
			System.out.println("sell clicked");
			//leads to new page related to selling (NON CENTRAL)
		}else if(e.getSource()==showAssetsButton) {
			System.out.println("show clicked");
			//leads to new page related to assets (NON CENTRAL)
		}else if(e.getSource()==newDepotButton) {
			System.out.println("new clicked");
			frame.dispose();
			//leads to new page related to depots
			CreateDepotPage depotPage = new CreateDepotPage(user);			
		}else if(e.getSource()==newGiroButton) {
			System.out.println("new clicked");
			frame.dispose();
			//leads to new page related to giros
			CreateGiroPage giroPage = new CreateGiroPage(user);			
		}
		
	}

}
