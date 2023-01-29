package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.model.Girokonto;
import g2.bankkontoverwaltung.model.Konto;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class OverviewPage implements ActionListener{
	
	public JFrame frame = new JFrame();
	public JLabel overviewLabel = new JLabel("ACCOUNT OVERVIEW");
	public JLabel chooseLabel = new JLabel("Which type of accounts do you want to see?");
	public JRadioButton giroButton = new JRadioButton("Giro");
	public JRadioButton depotButton = new JRadioButton("Depot");
	public JButton functionsButton = new JButton("Functions");

	User user;
	Vector<Konto> konten;
	public OverviewPage(User user, Vector<Konto> konten){
		this.user = user;
		this.konten = konten;

		overviewLabel.setBounds(0,0,400,35);
		overviewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		chooseLabel.setBounds(0,25,400,100);
		
		//buttons
		ButtonGroup group = new ButtonGroup();
		group.add(giroButton);
		group.add(depotButton);
		
		giroButton.addActionListener(this);
		depotButton.addActionListener(this);
		functionsButton.addActionListener(this);
		
		giroButton.setBounds(100,100,50,50);
		depotButton.setBounds(175,100,75, 50);
		functionsButton.setBounds(120,150,100,25);
		functionsButton.setFocusable(false);
		
		frame.add(functionsButton);
		frame.add(depotButton);
		frame.add(giroButton);
		frame.add(chooseLabel);
		frame.add(overviewLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==giroButton) {
			System.out.println("show giro accounts");
			//show giro accounts of user
			for (Konto konto: konten) {
				if (konto instanceof Girokonto) {
					System.out.println(((Girokonto) konto).getIban());
					System.out.println(konto.getSaldo());
				}
			}
		}else if(e.getSource()==depotButton) {
			System.out.println("show depot accounts");
			//show depot accounts of user
		} else {user.actionPerformed(e);}
	}

}
