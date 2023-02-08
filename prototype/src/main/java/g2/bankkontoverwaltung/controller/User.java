package g2.bankkontoverwaltung.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import g2.bankkontoverwaltung.ObserverIF;
import g2.bankkontoverwaltung.model.Kunde;
import g2.bankkontoverwaltung.storage.JsonReader;
import g2.bankkontoverwaltung.view.*;
import org.apache.commons.lang.IllegalClassException;


public class User implements ActionListener, ObserverIF {
    private Kunde identity;
    private final JsonReader jr;
    private final LoginPage loginPage;
    private RegistrationPage registrationPage;
    private WelcomePage welcomePage;
    private CreateDepotPage createDepotPage;
    private CreateGiroPage createGiroPage;
    private GiroOverviewPage giroOverviewPage;
    private DepotOverviewPage depotOverviewPage;
    private OverviewPage overviewPage;

    public User() throws URISyntaxException, IOException {
        this.jr = new JsonReader();
        this.loginPage = new LoginPage(this);
    }


    public void actionPerformed(ActionEvent e) {
        // Login Page
        //creates new user account
        if (e.getSource() == loginPage.newUserButton) {
            System.out.println("new user create");
            loginPage.frame.dispose();
            //leads to new page related to creating user
            this.registrationPage = new RegistrationPage(this);

        }

        //reset text fields if user wants to erase what they wrote
        else if (e.getSource() == loginPage.resetButton) {
            loginPage.userField.setText("");
            loginPage.passField.setText("");
            loginPage.loginMessageLabel.setText("");
            //loginPage.frame.dispose();
            //REMOVE AFTER TESTING
//            this.welcomePage = new WelcomePage(this, null);//shortcut for testing
        }

        //logs user in after verifying login data
        else if (e.getSource() == loginPage.loginButton) {
            String user = loginPage.userField.getText();
            String pass = String.valueOf(loginPage.passField.getPassword());
            JsonReader jr;
            try {
                jr = new JsonReader();
            } catch (URISyntaxException | IOException ex) {
                throw new RuntimeException(ex);
            }

            //checks if entered login data matches the data stored in the hash map
            try {
                if (jr.login(user, pass)) {
                    this.identity = jr.getKunde(user);
                    loginPage.loginMessageLabel.setForeground(Color.green);
                    loginPage.loginMessageLabel.setText("Login successful");
                    loginPage.frame.dispose();
                    this.welcomePage = new WelcomePage(this, user);
                } else {
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

        } else if (registrationPage != null && e.getSource() == registrationPage.createButton) {
            System.out.println("creating");

            JsonReader jr;
            try {
                jr = new JsonReader();
            } catch (URISyntaxException | IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
            	
        		String password = String.valueOf(registrationPage.passField.getPassword());
    		    Pattern passwordRegex = Pattern.compile("^\\w{9,}$");
    		    Matcher matcher = passwordRegex.matcher(password);
    		    
    		    if (!matcher.find()) {//...getPassword().equals(registrationPage...
    		    	System.out.println("Mind. 9 Zeichen aus Alphabet und Nummern!");
    		    	registrationPage.passWarningLabel.setVisible(true);
//    		    }else if(!registrationPage.passField.getPassword().equals(registrationPage.confirmPassField.getPassword())) {
//    		    	System.out.println("Passworter mussen sich einigen");
//    		    	System.out.println(registrationPage.passField.getPassword());
//    		    	System.out.println(registrationPage.confirmPassField.getPassword());
//    		    	registrationPage.confirmWarningLabel.setVisible(true);
//    		    	
    		    } else {
    		    	registrationPage.passWarningLabel.setVisible(false);
	                jr.saveLogin(registrationPage.userField.getText(), String.valueOf(registrationPage.passField.getPassword()));
	
	                HashMap<String, String> personaldaten = new HashMap<>();
	                personaldaten.put("username", registrationPage.userField.getText());
	                personaldaten.put("name", registrationPage.nameField.getText());
	                personaldaten.put("address", registrationPage.addressField.getText());
	                Kunde newKunde = new Kunde(personaldaten);
	                this.identity = newKunde;

	                registrationPage.frame.dispose();
	                this.welcomePage = new WelcomePage(this, registrationPage.userField.getText());
    		    }
            } catch (FileAlreadyExistsException ex) {
            	registrationPage.userWarningLabel.setVisible(true);
                System.out.println("username already exists choose another");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException e1) {
                throw new RuntimeException(e1);
            }
        } else if (e.getSource() == welcomePage.newDepotButton) {
            System.out.println("new clicked");
            welcomePage.frame.dispose();
            //leads to new page related to depots
            this.createDepotPage = new CreateDepotPage(this, welcomePage.username);
        } else if (e.getSource() == welcomePage.newGiroButton) {
            System.out.println("new clicked");
            welcomePage.frame.dispose();
            //leads to new page related to giros
            this.createGiroPage = new CreateGiroPage(this, welcomePage.username);
        } else if (e.getSource() == welcomePage.overviewButton) {
            System.out.println("overview clicked");
            welcomePage.frame.dispose();
            this.overviewPage = new OverviewPage(this, this.identity.getKonten());
        } else if (createGiroPage != null && e.getSource() == createGiroPage.createButton) {
            System.out.println("create clicked");
            System.out.println(createGiroPage.startSaldoField.getText());
            System.out.println(createGiroPage.username);

            // if data entered is float
            try {
                createGiroPage.saldoWarningLabel.setVisible(false);
                this.createGiroPage.saldo = Double.parseDouble(createGiroPage.startSaldoField.getText());
                createGiroPage.frame.dispose();
                this.giroOverviewPage = new GiroOverviewPage(this, this.identity.createGirokonto(this.createGiroPage.saldo));
                this.jr.saveKunde(this.identity);
                // if data entered is not float
            } catch (NumberFormatException nfe) {
                createGiroPage.startSaldoField.setText("");
                createGiroPage.saldoWarningLabel.setVisible(true);
            } catch (IOException | URISyntaxException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalArgumentException ile) {
            	createGiroPage.startSaldoField.setText("");
                createGiroPage.saldoWarningLabel.setVisible(true);
            }
            try {
                jr.saveKunde(this.identity);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (giroOverviewPage != null && e.getSource() == giroOverviewPage.functionsButton) {
            giroOverviewPage.frame.dispose();
            System.out.println(giroOverviewPage.username);
            this.welcomePage = new WelcomePage(this, giroOverviewPage.username);
        } else if (createDepotPage != null && e.getSource() == createDepotPage.createButton) {
            System.out.println("create clicked");
            System.out.println(createDepotPage.referenceIDField.getText());
            System.out.println(createDepotPage.username);

            // if data entered is float
            try {
                createDepotPage.idWarningLabel.setVisible(false);
                createDepotPage.id = Integer.parseInt(createDepotPage.referenceIDField.getText());
                createDepotPage.frame.dispose();
                this.depotOverviewPage = new DepotOverviewPage(this, this.identity.createDepotkonto(createDepotPage.id));
                this.jr.saveKunde(this.identity);
                // if data entered is not float
            } catch (NumberFormatException nfe) {
                createDepotPage.referenceIDField.setText("");
                createDepotPage.idWarningLabel.setVisible(true);
            }catch (IllegalClassException ex) {
                System.out.println("ID is not Girokonto");
            } catch (IOException | URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        } else if (depotOverviewPage != null && e.getSource() == depotOverviewPage.functionsButton) {
            depotOverviewPage.frame.dispose();
            this.welcomePage = new WelcomePage(this, depotOverviewPage.username);
        } else if (overviewPage != null && e.getSource() == overviewPage.functionsButton) {
            System.out.println("functions clicked");
            overviewPage.frame.dispose();
            //leads back to welcome page
            this.welcomePage = new WelcomePage(this, this.identity.getPersonaldaten().get("username"));
        }

    }

    @Override
    public void update() {

    }
}
