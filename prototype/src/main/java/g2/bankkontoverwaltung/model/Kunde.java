package g2.bankkontoverwaltung.model;

import java.util.HashMap;
import java.util.Vector;

public class Kunde {
    private String name;
    private String adresse;
    private String telefonnummer;
//    personalausweis HashMap Beispiel:
//    key = "Passport", value="C123145"
//    key = "Aufenthaltstitel", value="DE12345"
    private HashMap<String, String> personalausweis;
    private Vector<Konto> konten;

    public Kunde(String name, String adresse, String telefonnummer) {
        this.name = name;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.personalausweis = new HashMap<>();
        this.konten = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void addPersonalausweis(String ausweis, String ausweisnummer) {
        this.personalausweis.put(ausweis, ausweisnummer);
    }

    public void addKonto(Konto konto) {
        this.konten.add(konto);
    }
}
