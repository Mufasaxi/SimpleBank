package g2.bankkontoverwaltung.view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GiroOverviewPage implements ActionListener {
	
	JFrame  frame = new JFrame();
	JLabel overviewLabel = new JLabel("�BERSICHT");
	JLabel userLabel = new JLabel();
	JLabel saldoLabel = new JLabel();
	JLabel ibanLabel = new JLabel();
	JButton functionsButton = new JButton("Funktionen");
	
	String user;
	Float saldo;
	String IBAN;
	
	GiroOverviewPage(String user, Float saldo, String IBAN){
		this.user = user;
		this.saldo = saldo;
		this.IBAN = IBAN;
		
		userLabel.setText("username: "+ user );
		userLabel.setBounds(0,25,100,100);
		
		saldoLabel.setText("saldo: "+ saldo);
		saldoLabel.setBounds(0,50,100,100);
		
		ibanLabel.setText("IBAN: "+ IBAN);
		ibanLabel.setBounds(0,75,175,100);
		
		
		overviewLabel.setBounds(0,0,400,35);
		overviewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		functionsButton.setBounds(175,150,150,25);
		functionsButton.setFocusable(false);
		functionsButton.addActionListener(this);
		
		frame.add(ibanLabel);
		frame.add(functionsButton);
		frame.add(saldoLabel);
		frame.add(userLabel);
		frame.add(overviewLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==functionsButton) {
			frame.dispose();
			WelcomePage welcomePage = new WelcomePage(user, saldo);
		}
		
	}

}
