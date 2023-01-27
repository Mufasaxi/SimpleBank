package g2.bankkontoverwaltung.model;

public class Aktie {
    private double tageskurs;
    private int kennnummer;

    public Aktie(int kennnummer, double tageskurs) {
        this.kennnummer = kennnummer;
        this.tageskurs = tageskurs;
    }

    public double getTageskurs() {
        return tageskurs;
    }

    public void setTageskurs(double tageskurs) {
        this.tageskurs = tageskurs;
    }

    public int getKennnummer() {
        return kennnummer;
    }

    public void setKennnummer(int kennnummer) {
        this.kennnummer = kennnummer;
    }
}
