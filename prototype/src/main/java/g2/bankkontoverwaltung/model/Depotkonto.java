package g2.bankkontoverwaltung.model;

import java.io.IOException;
import java.util.Vector;

import g2.bankkontoverwaltung.storage.JsonReader;
import org.apache.commons.lang.IllegalClassException;

public class Depotkonto extends Konto{
    private Vector<Integer> referenzkonten;
    private Vector<Aktie> aktien;
    
    public Depotkonto() {
    	super();
    }
    
    public Depotkonto(Kunde kontoinhaber) {
        super(kontoinhaber, 0);

        this.referenzkonten = new Vector<>();
        this.aktien = new Vector<>();
    }

    public Vector<Integer> getReferenzkonten() {
        return this.referenzkonten;
    }

    public void addReferenzkonto(int referenzkontoId) throws IllegalClassException, ArrayIndexOutOfBoundsException, IOException {
        JsonReader jr = new JsonReader();
        Konto referenzkonto = jr.getKunde(this.getBenutzername()).getKonto(referenzkontoId);
        if (referenzkonto instanceof Girokonto) {
            this.referenzkonten.add(Integer.valueOf(referenzkontoId));
        } else {
            throw new IllegalClassException(Girokonto.class, referenzkonto);
        }
    }

    public void setReferenzkonten(Vector<Integer> referenzkonten) {
        this.referenzkonten = referenzkonten;
    }

    public void setAktien(Vector<Aktie> aktien) {
        this.aktien = aktien;
    }

    public Vector<Aktie> getAktien() {
        return this.aktien;
    }
}
