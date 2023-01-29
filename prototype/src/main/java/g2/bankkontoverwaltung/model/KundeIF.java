package g2.bankkontoverwaltung.model;

import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Vector;

public interface KundeIF {
	HashMap<String, String> getPersonaldaten();
    void setPersonalData(String key, String value);
    void removePersonalData(String key);
    Girokonto createGirokonto(double anfangssaldo) throws IOException;
    Depotkonto createDepotkonto(int referenzkontoId) throws IOException;
    Vector<Konto> getKonten();
    Konto getKonto(int id) throws NoSuchObjectException;
    void removeKonto(int id);
}
