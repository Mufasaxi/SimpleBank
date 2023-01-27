package g2.bankkontoverwaltung.model;

public class Girokonto extends Konto implements GirokontoIF{
    // wie erstellt man iban? Random generieren? oder so wie ein Counter benutzen?
    private String iban;

    public Girokonto(Kunde kontoinhaber) {
        super(kontoinhaber, 0);

    }

    @Override
    public String getIban() {
        return this.iban;
    }
}
