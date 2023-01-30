package g2.bankkontoverwaltung.model;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class KundeTest {
	private static Kunde testObject;

	@Before
	public void setUpBefore() throws Exception {
	}
	
	@Test
	public void testPersonaldaten() {
		HashMap<String, String> personaldaten = new HashMap<>();
		personaldaten.put("username", "example1");
		personaldaten.put("name", "Max Mustermann");
		personaldaten.put("address", "Leibnizstraße 20");
		personaldaten.put("phone", "+49111222333");
		testObject = new Kunde(personaldaten);
		
		assert testObject.getPersonaldaten().get("username") == "example1";
	}
	
	@Test
	public void testKonten() throws IOException {
		testObject.createGirokonto(100);
		
		assert testObject.getKonto(0) instanceof Girokonto;
		assert testObject.getKonto(0).getSaldo() == 100;
		
		assert testObject.getKonto(0).getBenutzername() == testObject.getPersonaldaten().get("username");
		
		testObject.createDepotkonto(0);

		assert testObject.getKonto(1) instanceof Depotkonto;
	}
}
