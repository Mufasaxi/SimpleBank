package g2.bankkontoverwaltung.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import g2.bankkontoverwaltung.model.Kunde;


public class JsonReader implements SaveDataIF, LoginIF{
    ObjectMapper mapper;

    public JsonReader() throws URISyntaxException, IOException {
		this.mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.DEFAULT);
        Path pathToData = Path.of("./data/");
        if(!Files.exists(pathToData)) {
            Files.createDirectory(pathToData);
        }
    }

	@Override
    public Kunde getKunde(String benutzername) throws IOException {
    	Path path = Paths.get("./data/" + benutzername + ".json");
    	
        Kunde kunde = mapper.readValue(new File(path.toString()), Kunde.class);
        return kunde;
    }

    @Override
    public void saveKunde(Kunde kunde) throws IOException {
    	Path path = Paths.get("./data/" + kunde.getPersonaldaten().get("username") + ".json");
    	Files.deleteIfExists(path);
    	Files.createFile(path);
        mapper.writeValue(new File(path.toString()), kunde);
    }

    @Override
    public boolean login(String benutzername, String password) throws FileNotFoundException {
    	Path path = Paths.get("./data/" + benutzername + ".login");
        Scanner reader = new Scanner(new File(path.toString()));
        if (password.equals(reader.nextLine())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveLogin(String benutzername, String password) throws IOException {
    	Path path = Paths.get("./data/" + benutzername + ".login");
        File newFile = new File(path.toString());
        if (newFile.exists()) {
            throw new FileAlreadyExistsException(benutzername);
        }
    	FileWriter writer = new FileWriter(newFile);
    	writer.write(password);
    	writer.close();
    }
}
