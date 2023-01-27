package g2.bankkontoverwaltung.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import g2.bankkontoverwaltung.model.Kunde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileReader implements SaveDataIF, LoginIF{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Kunde getKunde(String benutzername) throws IOException {
        String path = "data/" + benutzername + ".json";
        Kunde kunde = mapper.readValue(new File(path), Kunde.class);
        return kunde;
    }

    @Override
    public void saveKunde(Kunde kunde) throws IOException {
        String path = "data/" + kunde.getPersonalData("benutzername") + ".json";
        mapper.writeValue(new File(path), kunde);
    }

    @Override
    public boolean login(String benutzername, String password) throws FileNotFoundException {
        String path = "data/" + benutzername + ".login";
        Scanner reader = new Scanner(new File(path));
        if (password == reader.nextLine()) {
            return true;
        } else {
            return false;
        }
    }
}
