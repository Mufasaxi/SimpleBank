package g2.bankkontoverwaltung.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Girokonto.class, name = "Girokonto"),

    @JsonSubTypes.Type(value = Depotkonto.class, name = "Depotkonto") }
)
public abstract class Konto {
    private String benutzername;
    private double saldo;
    private int id;
    
    public Konto() {
    	super();
    }
    
    public Konto(Kunde kontoinhaber, double saldo) {
        this.benutzername = kontoinhaber.getPersonaldaten().get("benutzername");
        this.saldo = saldo;
        this.id = kontoinhaber.getKonto().size();
    }

    public String getKontoinhaber() {
        return benutzername;
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
