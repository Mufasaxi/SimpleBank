package g2.bankkontoverwaltung.controller;

import g2.bankkontoverwaltung.ObserverIF;
import g2.bankkontoverwaltung.model.Kunde;
import g2.bankkontoverwaltung.storage.JsonReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class User implements ActionListener, ObserverIF {
    private Kunde identity;
//    private JFrame frame;    // panel aus view
    private JsonReader jr = new JsonReader();

    public void login(String benutzername, String password) throws Exception {
        if (jr.login(benutzername, password)) {     // login erfolgreich
            this.identity = jr.getKunde(benutzername);
        } else {
            throw new Exception("Wrong Password");
        }
    }

    public void registerNewUser(String name, String adresse, String telefonnummer) throws IllegalAccessException {
        if (this.identity != null) {
            throw new IllegalAccessException("Already logged in");
        }

        HashMap<String, String> personaldaten = new HashMap<>();
        personaldaten.put("name", name);
        personaldaten.put("adresse", adresse);
        personaldaten.put("telefonnummer", telefonnummer);
        this.identity = new Kunde(personaldaten);
    }

    public void createDepotkonto(int referenzkontoId) throws IllegalAccessException {
        if (this.identity == null) {
            throw new IllegalAccessException("Not logged in");
        }

        this.identity.createDepotkonto(referenzkontoId);
    }

    public void createGirokonto(double anfangssaldo) throws IllegalAccessException {
        if (this.identity == null) {
            throw new IllegalAccessException("Not logged in");
        }

        this.identity.createGirokonto(anfangssaldo);
    }

    public void removeKonto(int kontoId) throws IllegalAccessException {
        if (this.identity == null) {
            throw new IllegalAccessException("Not logged in");
        }

        this.identity.removeKonto(kontoId);
    }

    public String getPersonalData(String key) {
        return this.identity.getPersonaldaten().get(key);
    }

    public void setPersonalData(String key, String value) {
        this.identity.setPersonalData(key, value);
    }

    public void removePersonalData(String key) {
        this.identity.removePersonalData(key);
    }


    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void update() {
    	
    }
}
