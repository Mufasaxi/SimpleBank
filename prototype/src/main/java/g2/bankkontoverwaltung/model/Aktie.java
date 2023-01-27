package g2.bankkontoverwaltung.model;

public class Aktie {
    private double tageskurs;
    private int kennnummer;

    public Aktie(int kennnummer, double tageskurs) {
        this.kennnummer = kennnummer;
        this.tageskurs = tageskurs;
    }
}
