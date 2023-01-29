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
        this.benutzername = kontoinhaber.getPersonaldaten().get("username");
        this.saldo = saldo;
        this.id = kontoinhaber.getKonten().size();
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
