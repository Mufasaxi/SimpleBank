package g2.bankkontoverwaltung.storage;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LoginIF {
    boolean login(String benutzername, String password) throws FileNotFoundException;
    void saveLogin(String benutzername, String password) throws IOException;
}
