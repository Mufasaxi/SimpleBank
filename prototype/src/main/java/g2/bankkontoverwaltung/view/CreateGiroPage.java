package g2.bankkontoverwaltung.view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class CreateGiroPage implements ActionListener {
	JFrame  frame = new JFrame();
	JLabel giroLabel = new JLabel("GIROKONTO");
	JLabel fillLabel = new JLabel("F�llen Sie die folgenden Felder aus");
	JTextField startSaldoField = new JTextField();
	JLabel saldoLabel = new JLabel("Start Saldo:");
	JLabel saldoWarningLabel = new JLabel("Bitte nur Zahlen eingeben!");
	JButton createButton = new JButton("Konto erstellen");
	
	String user;
	Float saldo;
	String IBAN;
	
	CreateGiroPage(String user) {
		this.user = user;
		this.IBAN = generateIBAN();
		
		giroLabel.setBounds(0,0,400,35);
		giroLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
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
		frame.add(giroLabel);
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
			System.out.println(user);
			
			// if data entered is float
			try {
				saldoWarningLabel.setVisible(false);
				this.saldo = Float.parseFloat(startSaldoField.getText());
				frame.dispose();
				GiroOverviewPage overViewPage = new GiroOverviewPage(user, saldo, IBAN);
			// if data entered is not float
			}catch(NumberFormatException nfe){
				startSaldoField.setText("");
				saldoWarningLabel.setVisible(true);
			}
			
		}
		
	}
	
	//randomly generates an IBAN for each new giro account made
	public String generateIBAN() {
		String IBAN = "DE";
		Random number = new Random();
		
		int num1 = number.nextInt(10);
		int num2 = number.nextInt(10);
		IBAN += Integer.toString(num1) + Integer.toString(num2) + " ";
		
		int count = 0;
	    int n = 0;
	    for(int i =0; i < 12;i++)
	    {
	        if(count == 4)
	        {
	            IBAN += " ";
	            count =0;
	        }
	        else 
	            n = number.nextInt(10);
	            IBAN += Integer.toString(n);
	            count++;            

	    }
		
		return IBAN;
	}
	
}
