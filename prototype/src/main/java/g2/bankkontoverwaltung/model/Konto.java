package g2.bankkontoverwaltung.model;

import g2.bankkontoverwaltung.ObserverIF;

import java.util.Vector;

public abstract class Konto implements ObservableIF{
    private Kunde kontoinhaber;
    private double saldo;
    private int id;
    private Vector<ObserverIF> observers;

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

    @Override
    public void addObserver(ObserverIF observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverIF observer) {
        this.observers.remove(observer);
    }
}
