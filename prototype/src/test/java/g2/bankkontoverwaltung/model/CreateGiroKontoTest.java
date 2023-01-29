package g2.bankkontoverwaltung.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class CreateGiroKontoTest {
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
    public void testCreateGirokonto() throws IOException {

        Girokonto testKonto = example.createGirokonto(100);
        assert example.getKonto(0).equals(testKonto);
    }
    @Test
    public void testCreateDepotkonto() throws IOException {
        Depotkonto testKonto = example.createDepotkonto(100);
        assert example.getKonto(0).equals(testKonto);
    }
}