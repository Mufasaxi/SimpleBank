package g2.bankkontoverwaltung.storage;

import java.io.IOException;

import g2.bankkontoverwaltung.model.Kunde;

public interface SaveDataIF {
    Kunde getKunde(String benutzername) throws IOException;
    void saveKunde(Kunde kunde) throws IOException;
}
