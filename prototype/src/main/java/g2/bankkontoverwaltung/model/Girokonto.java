package g2.bankkontoverwaltung.model;

public class Girokonto extends Konto {
    private String iban;

    public Girokonto(Kunde kontoinhaber, double anfangssaldo) {
        super(kontoinhaber, 0);
        this.iban = "DE9901234567" + String.format("%010d", this.getId());
        this.setSaldo(anfangssaldo);
    }

    public String getIban() {
        return this.iban;
    }

}
