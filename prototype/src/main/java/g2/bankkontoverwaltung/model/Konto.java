package g2.bankkontoverwaltung.model;

public abstract class Konto implements KontoIF{
    private Kunde kontoinhaber;
    private double saldo;

    public Konto(Kunde kontoinhaber, double saldo) {
        this.kontoinhaber = kontoinhaber;
        this.saldo = saldo;
    }

    @Override
    public Kunde getKontoinhaber() {
        return kontoinhaber;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}
