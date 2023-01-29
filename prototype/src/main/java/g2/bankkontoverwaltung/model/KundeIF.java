package g2.bankkontoverwaltung.model;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Vector;

public interface KundeIF {
	HashMap<String, String> getPersonaldaten();
    void setPersonalData(String key, String value);
    void removePersonalData(String key);
    void createGirokonto(double anfangssaldo);
    void createDepotkonto(int referenzkontoId) throws NoSuchObjectException;
    Vector<Konto> getKonto();
    Konto getKonto(int id) throws NoSuchObjectException;
    void removeKonto(int id);
}
