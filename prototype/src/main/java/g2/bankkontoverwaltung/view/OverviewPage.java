package g2.bankkontoverwaltung.view;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel overviewLabel = new JLabel("ACCOUNT OVERVIEW");
	JLabel chooseLabel = new JLabel("Which type of accounts do you want to see?");
	JRadioButton giroButton = new JRadioButton("Giro");
	JRadioButton depotButton = new JRadioButton("Depot");
	JButton functionsButton = new JButton("Functions");
	
	OverviewPage(){
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
		}else if(e.getSource()==depotButton) {
			System.out.println("show depot accounts");
			//show depot accounts of user
		}else if(e.getSource()==functionsButton) {
			System.out.println("functions clicked");
			frame.dispose();
			//leads back to welcome page
			WelcomePage welcomePage = new WelcomePage(null, null);
		}
		
	}

}
