package g2.bankkontoverwaltung.storage;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import g2.bankkontoverwaltung.model.Kunde;

public class StorageTest {
	private static JsonReader testObject;
	private static Kunde example;
	@Before
	public void setUpBefore() throws Exception {
		testObject = new JsonReader();
		
		HashMap<String, String> personaldaten = new HashMap<>();
		personaldaten.put("benutzername", "example1");
		personaldaten.put("name", "Max Mustermann");
		personaldaten.put("adresse", "Leibnizstraße 20");
		personaldaten.put("telefonnummer", "+49111222333");
		example = new Kunde(personaldaten);
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
		
		assert loaded.getPersonalData("name") == example.getPersonalData("name");
	}
}
