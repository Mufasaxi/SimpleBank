package g2.bankkontoverwaltung.view;

import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.model.Girokonto;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GiroOverviewPage implements ActionListener {

    public JFrame frame = new JFrame("Giro Overview");
    JLabel overviewLabel = new JLabel("OVERVIEW");
    JLabel userLabel = new JLabel();
    JLabel saldoLabel = new JLabel();
    JLabel ibanLabel = new JLabel();
    public JButton functionsButton = new JButton("Functions");

    User user;
    public String username;
    double saldo;
    String IBAN;

    public GiroOverviewPage(User user, Girokonto konto) {
        this.user = user;
        this.username = konto.getBenutzername();
        this.saldo = konto.getSaldo();
        this.IBAN = konto.getIban();

        userLabel.setText("username: " + username);
        userLabel.setBounds(0, 25, 150, 100);

        saldoLabel.setText("balance: " + saldo);
        saldoLabel.setBounds(0, 50, 100, 100);

        ibanLabel.setText("IBAN: " + IBAN);
        ibanLabel.setBounds(0, 75, 200, 100);


        overviewLabel.setBounds(0, 0, 400, 35);
        overviewLabel.setFont(new Font("Serif", Font.PLAIN, 25));

        functionsButton.setBounds(175, 150, 150, 25);
        functionsButton.setFocusable(false);
        functionsButton.addActionListener(this);

        frame.add(ibanLabel);
        frame.add(functionsButton);
        frame.add(saldoLabel);
        frame.add(userLabel);
        frame.add(overviewLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user.actionPerformed(e);
    }

}
