package g2.bankkontoverwaltung.model;

public class Girokonto extends Konto {
    private String iban;
    private static int ibanCounter = 0;
    public Girokonto() {
    	super();
    }
    
    public Girokonto(Kunde kontoinhaber, double anfangssaldo) {
        super(kontoinhaber, 0);
        this.iban = "DE9901234567" + String.format("%010d", ibanCounter);
        ibanCounter++;
        this.setSaldo(anfangssaldo);
    }

    public String getIban() {
        return this.iban;
    }

}
