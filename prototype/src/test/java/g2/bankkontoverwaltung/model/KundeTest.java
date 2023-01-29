package g2.bankkontoverwaltung.model;

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
		personaldaten.put("benutzername", "example1");
		personaldaten.put("name", "Max Mustermann");
		personaldaten.put("adresse", "Leibnizstraße 20");
		personaldaten.put("telefonnummer", "+49111222333");
		testObject = new Kunde(personaldaten);
		
		assert testObject.getPersonaldaten().get("benutzername") == "example1";
	}
	
	@Test
	public void testKonten() {
		testObject.createGirokonto(100);
		
		assert testObject.getKonto(0) instanceof Girokonto;
		assert testObject.getKonto(0).getSaldo() == 100;
		
		assert testObject.getKonto(0).getKontoinhaber() == testObject.getPersonaldaten().get("benutzername");
		
		testObject.createDepotkonto(0);
		
		System.out.println(testObject.getKonto().toString());
		assert testObject.getKonto(1) instanceof Depotkonto;
	}
}
