package g2.bankkontoverwaltung.model;

import java.util.Vector;

public interface DepotkontoIF extends KontoIF{
    public Girokonto getReferenzkonto();
    public int getId();
    public Vector<Aktie> getAktien();
}
