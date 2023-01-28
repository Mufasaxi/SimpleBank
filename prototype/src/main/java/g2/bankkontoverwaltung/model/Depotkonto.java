package g2.bankkontoverwaltung.model;

import org.apache.commons.lang.IllegalClassException;

import java.rmi.NoSuchObjectException;
import java.util.Vector;

public class Depotkonto extends Konto{
    private Vector<Konto> referenzkonten;
    private Vector<Aktie> aktien;

    public Depotkonto(Kunde kontoinhaber) {
        super(kontoinhaber, 0);

        this.referenzkonten = new Vector<>();
        this.aktien = new Vector<>();
    }

    public Vector<Konto> getReferenzkonten() {
        return this.referenzkonten;
    }

    public void addReferenzkonto(int id) throws IllegalClassException, ArrayIndexOutOfBoundsException {
        Konto referenzkonto = this.getKontoinhaber().getKonto(id);
        if (referenzkonto instanceof Girokonto) {
            this.referenzkonten.add(referenzkonto);
        } else {
            throw new IllegalClassException(Girokonto.class, referenzkonto);
        }
    }

    public Vector<Aktie> getAktien() {
        return this.aktien;
    }
}
