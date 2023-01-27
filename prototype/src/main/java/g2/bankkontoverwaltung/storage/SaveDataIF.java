package g2.bankkontoverwaltung.storage;

import g2.bankkontoverwaltung.model.Kunde;

import java.io.IOException;

public interface SaveDataIF {
    Kunde getKunde(String benutzername) throws IOException;
    void saveKunde(Kunde kunde) throws IOException;
}
