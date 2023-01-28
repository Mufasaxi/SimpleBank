package g2.bankkontoverwaltung.model;

public abstract class Konto {
    private Kunde kontoinhaber;
    private double saldo;
    private int id;

    public Konto(Kunde kontoinhaber, double saldo) {
        this.kontoinhaber = kontoinhaber;
        this.saldo = saldo;
        this.id = this.kontoinhaber.getKonto().size();
    }

    public Kunde getKontoinhaber() {
        return kontoinhaber;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
