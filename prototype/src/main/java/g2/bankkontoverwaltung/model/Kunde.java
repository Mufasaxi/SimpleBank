package g2.bankkontoverwaltung.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;
import g2.bankkontoverwaltung.storage.JsonReader;
import org.apache.commons.lang.IllegalClassException;

import g2.bankkontoverwaltung.ObserverIF;

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
    @JsonIgnore
    public void setPersonalData(String key, String value) {
        this.personaldaten.put(key, value);
    }

    @Override
    public void removePersonalData(String key) {
        this.personaldaten.remove(key);
    }

    @Override
    public Girokonto createGirokonto(double anfangssaldo) throws IOException {
        Girokonto newKonto = new Girokonto(this, anfangssaldo);
        this.konten.add(newKonto);
        (new JsonReader()).saveKunde(this);
        return newKonto;
    }

    @Override
    public Depotkonto createDepotkonto(int referenzkontoId) throws IllegalClassException, ArrayIndexOutOfBoundsException, IOException {
        Depotkonto newKonto = new Depotkonto(this);
        newKonto.addReferenzkonto(referenzkontoId);
        this.konten.add(newKonto);
        (new JsonReader()).saveKunde(this);
        return newKonto;
    }

    @Override
    public Vector<Konto> getKonten() {
        return this.konten;
    }

    @Override
    @JsonIgnore
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
