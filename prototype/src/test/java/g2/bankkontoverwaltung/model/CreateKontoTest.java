package g2.bankkontoverwaltung.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class CreateKontoTest {
    private static Kunde example;
    HashMap<String, String> personaldaten;

    @Before
    public void beforeSetUp() {
        personaldaten = new HashMap<>();
        personaldaten.put("username", "example1");
        personaldaten.put("name", "Max Mustermann");
        personaldaten.put("aufenthaltstitel", "DE12345");
        personaldaten.put("address", "Leibnizstraße 20");
        personaldaten.put("phone", "+49111222333");
        example = new Kunde(personaldaten);
    }

    @Test
    public void testCreateKonto() throws IOException, URISyntaxException {

        Girokonto testGiroKonto = example.createGirokonto(100);
        assert example.getKonto(0).equals(testGiroKonto);
        System.out.println(example.getKonten().toString());

        Depotkonto testDepotKonto = example.createDepotkonto(0);
        assert example.getKonto(1).equals(testDepotKonto);
    }

    @After
    public void cleanUp() {
        File[] allContents = new File("./data").listFiles();
        for (File file : allContents) {
            file.delete();
        }
    }
}