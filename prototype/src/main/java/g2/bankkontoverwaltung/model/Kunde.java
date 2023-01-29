package g2.bankkontoverwaltung.model;

import g2.bankkontoverwaltung.ObserverIF;
import org.apache.commons.lang.IllegalClassException;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Vector;

public class Kunde implements KundeIF, ObservableIF {
//    personalausweis HashMap Beispiel:
//    key = "Name", value="Daryl"
//    key = "Aufenthaltstitel", value="DE12345"
    private HashMap<String, String> personaldaten;
    private Vector<Konto> konten;
    private Vector<ObserverIF> observers;

    public Kunde() {
    	super();
    }
    
    public Kunde(HashMap<String, String> personaldaten) {
        this.personaldaten = personaldaten;
        this.konten = new Vector<>();
        this.observers = new Vector<>();
    }

	@Override
    public HashMap<String, String> getPersonaldaten() {
        return this.personaldaten;
    }

    @Override
    public void setPersonalData(String key, String value) {
        this.personaldaten.put(key, value);
    }

    @Override
    public void removePersonalData(String key) {
        this.personaldaten.remove(key);
    }

    @Override
    public void createGirokonto(double anfangssaldo) {
        Girokonto newKonto = new Girokonto(this, anfangssaldo);
        this.konten.add(newKonto);
    }

    @Override
    public void createDepotkonto(int referenzkontoId) throws IllegalClassException, ArrayIndexOutOfBoundsException {
        Depotkonto newKonto = new Depotkonto(this);
        newKonto.addReferenzkonto(referenzkontoId);
    }

    @Override
    public Vector<Konto> getKonto() {
        return this.konten;
    }

    @Override
    public Konto getKonto(int id) throws ArrayIndexOutOfBoundsException {
        return this.konten.get(id);
    }

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
