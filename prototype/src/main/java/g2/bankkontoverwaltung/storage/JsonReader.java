package g2.bankkontoverwaltung.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import g2.bankkontoverwaltung.model.Kunde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class JsonReader implements SaveDataIF, LoginIF{
    ObjectMapper mapper = new ObjectMapper();
    String absPath = new File("").getAbsolutePath();

    @Override
    public Kunde getKunde(String benutzername) throws IOException {
    	Path path = Paths.get("src/main/java/g2/bankkontoverwaltung/storage/data/" + benutzername + ".json");
    	
        Kunde kunde = mapper.readValue(new File(path.toString()), Kunde.class);
        return kunde;
    }

    @Override
    public void saveKunde(Kunde kunde) throws IOException {
    	Path path = Paths.get("src/main/java/g2/bankkontoverwaltung/storage/data/" + kunde.getPersonalData("benutzername") + ".json");
    	Files.deleteIfExists(path);
    	Files.createFile(path);
        mapper.writeValue(new File(path.toString()), kunde);
    }

    @Override
    public boolean login(String benutzername, String password) throws FileNotFoundException {
        String path = "./data/" + benutzername + ".login";
        Scanner reader = new Scanner(new File(path));
        if (password == reader.nextLine()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveLogin(String benutzername, String password) {
        
    }
}
