package g2.bankkontoverwaltung.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

import g2.bankkontoverwaltung.ObserverIF;
import g2.bankkontoverwaltung.model.Kunde;
import g2.bankkontoverwaltung.storage.JsonReader;
import g2.bankkontoverwaltung.view.*;


public class User implements ActionListener, ObserverIF {
    private Kunde identity;
    private JsonReader jr;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private WelcomePage welcomePage;
    private CreateDepotPage createDepotPage;
    private CreateGiroPage createGiroPage;
    private GiroOverviewPage giroOverviewPage;
    private DepotOverviewPage depotOverviewPage;

    public User() {
        this.jr = new JsonReader();

        this.loginPage = new LoginPage(this);
    }


    public void actionPerformed(ActionEvent e) {
        // Login Page
        //creates new user account
        if(e.getSource()==loginPage.newUserButton) {
            System.out.println("new user create");
            //leads to new page related to creating user
            this.registrationPage = new RegistrationPage(this);

        }

        //reset text fields if user wants to erase what they wrote
        else if(e.getSource()==loginPage.resetButton) {
            loginPage.userField.setText("");
            loginPage.passField.setText("");
            loginPage.loginMessageLabel.setText("");
            loginPage.frame.dispose();
            //REMOVE AFTER TESTING
            this.welcomePage = new WelcomePage(this, null);//shortcut for testing
        }

        //logs user in after verifying login data
        else if(e.getSource()==loginPage.loginButton) {
            String user = loginPage.userField.getText();
            String pass = String.valueOf(loginPage.passField.getPassword());
            JsonReader jr = new JsonReader();

            //checks if entered login data matches the data stored in the hash map
            try {
                if(jr.login(user, pass)) {
                    this.identity = jr.getKunde(user);
                    loginPage.loginMessageLabel.setForeground(Color.green);
                    loginPage.loginMessageLabel.setText("Login successful");
                    loginPage.frame.dispose();
                    this.welcomePage = new WelcomePage(this, user);
                }else {
                    loginPage.loginMessageLabel.setForeground(Color.red);
                    loginPage.loginMessageLabel.setText("Wrong Login Data");
                }
            } catch (FileNotFoundException ex) {
                loginPage.loginMessageLabel.setForeground(Color.red);
                loginPage.loginMessageLabel.setText("Wrong Login Data");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //if no data entered same error message shown on screen

        }

        // Registration Page
        if(e.getSource()==registrationPage.createButton) {
            System.out.println("creating");

            JsonReader jr = new JsonReader();
            try {
                jr.saveLogin(registrationPage.userField.getText(), String.valueOf(registrationPage.passField.getPassword()));

                HashMap<String, String> personaldaten = new HashMap<>();
                personaldaten.put("username", registrationPage.userField.getText());
                personaldaten.put("name", registrationPage.nameField.getText());
                personaldaten.put("address", registrationPage.addressField.getText());
                Kunde newKunde = new Kunde(personaldaten);
                this.identity = newKunde;
            } catch (FileAlreadyExistsException ex) {
                System.out.println("username already exists choose another");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        // Welcome Page
        if(e.getSource()==welcomePage.buyButton) {
            System.out.println("buy clicked");
            //leads to new page related to buying (NON CENTRAL)
        }else if(e.getSource()==welcomePage.sellButton) {
            System.out.println("sell clicked");
            //leads to new page related to selling (NON CENTRAL)
        }else if(e.getSource()==welcomePage.showAssetsButton) {
            System.out.println("show clicked");
            //leads to new page related to assets (NON CENTRAL)
        }else if(e.getSource()==welcomePage.newDepotButton) {
            System.out.println("new clicked");
            welcomePage.frame.dispose();
            //leads to new page related to depots
            CreateDepotPage depotPage = new CreateDepotPage(welcomePage.user, welcomePage.username);
        }else if(e.getSource()==welcomePage.newGiroButton) {
            System.out.println("new clicked");
            welcomePage.frame.dispose();
            //leads to new page related to giros
            CreateGiroPage giroPage = new CreateGiroPage(welcomePage.user, welcomePage.username);
        }
    }

    @Override
    public void update() {
    	
    }
}
