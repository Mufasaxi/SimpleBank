package g2.bankkontoverwaltung.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import g2.bankkontoverwaltung.model.Depotkonto;
import g2.bankkontoverwaltung.model.Girokonto;
import g2.bankkontoverwaltung.model.Kunde;

public class StorageTest {
	private static JsonReader testObject;
	private Kunde example;
	
	@Before
	public void setUpBefore() throws Exception {
		testObject = new JsonReader();
		
		HashMap<String, String> personaldaten = new HashMap<>();
		personaldaten.put("username", "example1");
		personaldaten.put("name", "Max Mustermann");
		personaldaten.put("address", "Leibnizstraße 20");
		personaldaten.put("phone", "+49111222333");
		example = new Kunde(personaldaten);
		
		example.createGirokonto(100);
		example.createDepotkonto(0);
	}

	@Test
	public void testSaveKunde() throws IOException {
		testObject.saveKunde(example);
		Path path = Paths.get("src/main/java/g2/bankkontoverwaltung/storage/data/example1.json");
		File file = new File(path.toString());
		
		assert file.exists() && !file.isDirectory();
	}
	
	@Test
	public void testLoadKunde() throws IOException {
		Kunde loaded = testObject.getKunde("example1");
		
		assert loaded.getPersonaldaten().equals(example.getPersonaldaten());
		assert loaded.getKonto(0) instanceof Girokonto;
		assert loaded.getKonto(1) instanceof Depotkonto;
	}
	
	@Test
	public void testLogin() throws IOException {
		testObject.saveLogin("example1", "exAmple1");
    	Path path = Paths.get("src/main/java/g2/bankkontoverwaltung/storage/data/example1.login");
    	File file = new File(path.toString());
    	
		assert file.exists() && !file.isDirectory();
		
		assert !testObject.login("example1", "password");
		assert testObject.login("example1", "exAmple1");
	}
}
