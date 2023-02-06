package g2.bankkontoverwaltung.model;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class KundeIFTest {
    private static Kunde example;
    HashMap<String, String> personaldaten;

    @Rule
    public ExpectedException exceptionRule= ExpectedException.none();

    @Before
    public void beforeSetUp() {
        personaldaten = new HashMap<>();
        personaldaten.put("username", "example1");
        personaldaten.put("name", "Max Mustermann");
        personaldaten.put("aufenthaltstitel", "DE12345");
        personaldaten.put("address", "Leibnizstraße 20");
        personaldaten.put("phone", "+49111222333");
        try {
            example = new Kunde(personaldaten);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetPersonaldaten() {
        HashMap<String, String> exampleDaten = example.getPersonaldaten();

        assert exampleDaten.get("username") == personaldaten.get("username");
        assert exampleDaten.get("reisepass") == null;
    }

    @Test
    public void testGirokonto() throws IOException, URISyntaxException {
        // Test creation of Girokonto
        Girokonto testGiroKonto = example.createGirokonto(100);
        assert example.getKonto(0).equals(testGiroKonto);

        // Test to get non-existent Konto ID
        exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
        example.getKonto(1);

        // Test remove konto
        exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
        example.removeKonto(0);
        example.getKonto(0);

        example.removeKonto(0);
    }

    @Test
    public void testDepotkonto() throws IOException, URISyntaxException {
        // Test creation of Depotkonto
        example.createGirokonto(100);
        Depotkonto testDepotKonto = example.createDepotkonto(0);
        assert example.getKonto(1).equals(testDepotKonto);

        // Test invalid Anfangssaldo
        exceptionRule.expect(IllegalArgumentException.class);
        example.createGirokonto(-100);

        // Test invalid id
        exceptionRule.expect(IllegalArgumentException.class);
        example.createDepotkonto(-1);
    }

    @After
    public void cleanUp() {
        File[] allContents = new File("./data").listFiles();
        for (File file : allContents) {
            file.delete();
        }
    }
}