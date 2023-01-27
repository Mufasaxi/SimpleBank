package g2.bankkontoverwaltung.model;

import java.util.Vector;

public class Depotkonto extends Konto implements DepotkontoIF{
    private Girokonto referenzkonto;
    // wie werden wir die ids erstellen?
    private int id;
    private Vector<Aktie> aktien;

    public Depotkonto(Kunde kontoinhaber, Girokonto referenzkonto) {
        super(kontoinhaber, 0);

        this.referenzkonto = referenzkonto;
    }

    @Override
    public Girokonto getReferenzkonto() {
        return this.referenzkonto;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Vector<Aktie> getAktien() {
        return this.aktien;
    }
}
