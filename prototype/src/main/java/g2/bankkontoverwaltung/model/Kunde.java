package g2.bankkontoverwaltung.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;
import g2.bankkontoverwaltung.storage.JsonReader;
import org.apache.commons.lang.IllegalClassException;

import g2.bankkontoverwaltung.ObserverIF;

/**
 * Represents a Bank Customer
 * @author Muhammad Daryl Rashad
 */
public class Kunde implements KundeIF, ObservableIF {
//    personalausweis HashMap Beispiel:
//    key = "Name", value="Daryl"
//    key = "Aufenthaltstitel", value="DE12345"
    private HashMap<String, String> personaldaten;
    private Vector<Konto> konten;
    private Vector<ObserverIF> observers;
    private JsonReader jr;

    public Kunde() {
    	super();
    }

    /**
     * Basic constructor for a Kunde
     * @param personaldaten HashMap containing customer information
     */
    public Kunde(HashMap<String, String> personaldaten) throws URISyntaxException, IOException {
        this.personaldaten = personaldaten;
        this.konten = new Vector<>();
        this.observers = new Vector<>();

        this.jr = new JsonReader();
        jr.saveKunde(this);
    }

    /**
     * Get all personal data
     * @return HashMap containing personal data
     */
    @Override
    public HashMap<String, String> getPersonaldaten() {
        return this.personaldaten;
    }

    /**
     * Set/add a specific personal data
     * @param key Type of personal data
     * @param value Value of personal data
     */
    @Override
    @JsonIgnore
    public void setPersonalData(String key, String value) {
        this.personaldaten.put(key, value);
    }

    /**
     * Remove a specific personal data
     * @param key Type of personal data to be removed
     */
    @Override
    public void removePersonalData(String key) {
        this.personaldaten.remove(key);
    }

    /**
     * Create a new Girokonto for the user
     * @param anfangssaldo starting saldo
     * @return new Girokonto object
     * @throws IOException
     */
    @Override
    public Girokonto createGirokonto(double anfangssaldo) throws IOException, URISyntaxException {
//        if (anfangssaldo < 0) {
//            throw new IllegalArgumentException();
//        }
        Girokonto newKonto = new Girokonto(this, anfangssaldo);
        this.konten.add(newKonto);
        this.jr.saveKunde(this);
        return newKonto;
    }

    /**
     * Create a new Depotkonto for the user
     * @param referenzkontoId Id of the Referenzkonto
     * @return new Depotkonto object
     * @throws IllegalClassException when referenzkontoId belongs to Konto that is not a Girokonto
     * @throws ArrayIndexOutOfBoundsException when referenzkontoId does not exist
     * @throws IOException when error with reading data
     */
    @Override
    public Depotkonto createDepotkonto(int referenzkontoId) throws IllegalClassException, ArrayIndexOutOfBoundsException, IOException, URISyntaxException {
        if (referenzkontoId < 0) {
            throw new IllegalArgumentException();
        }
        Depotkonto newKonto = new Depotkonto(this);
        newKonto.addReferenzkonto(referenzkontoId);
        this.konten.add(newKonto);
        this.jr.saveKunde(this);
        return newKonto;
    }

    /**
     * Get all Konto belonging to user
     * @return Vector containing all Konto belonging to user
     */
    @Override
    public Vector<Konto> getKonten() {
        return this.konten;
    }

    /**
     * Get a specific Konto belonging to the user
     * @param id id of requested Konto
     * @return the requested Konto
     * @throws ArrayIndexOutOfBoundsException when the requested Konto is not found
     */
    @Override
    @JsonIgnore
    public Konto getKonto(int id) throws ArrayIndexOutOfBoundsException {
        return this.konten.get(id);
    }

    /**
     * Remove a Konto
     * @param id id of Konto to be removed
     */
    @Override
    public void removeKonto(int id) {
        this.konten.remove(id);
    }

    @Override
    public void addObserver(ObserverIF observer) {
    	this.observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverIF observer) {
    	this.observers.remove(observer);
    }
    
    private void updateObservers() {
    	this.observers.forEach(observer -> observer.update());
    }
}
