package g2.bankkontoverwaltung.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class CreateKontoTest {
    private static Kunde example;
    HashMap<String, String> personaldaten;

    @Before
    public void beforeSetUp() {
        personaldaten = new HashMap<>();
        personaldaten.put("benutzername", "example1");
        personaldaten.put("name", "Max Mustermann");
        personaldaten.put("aufenthaltstitel", "DE12345");
        personaldaten.put("adresse", "Leibnizstraße 20");
        personaldaten.put("telefonnummer", "+49111222333");
        example = new Kunde(personaldaten);
    }

    @Test
    public void testCreateKonto() throws IOException {

        Girokonto testGiroKonto = example.createGirokonto(100);
        assert example.getKonto(0).equals(testGiroKonto);
        System.out.println(example.getKonten().toString());

        Depotkonto testDepotKonto = example.createDepotkonto(0);
        assert example.getKonto(1).equals(testDepotKonto);
    }
}