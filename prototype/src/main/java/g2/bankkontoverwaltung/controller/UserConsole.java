package g2.bankkontoverwaltung.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import g2.bankkontoverwaltung.ObserverIF;
import g2.bankkontoverwaltung.model.Girokonto;
import g2.bankkontoverwaltung.model.Kunde;
import g2.bankkontoverwaltung.storage.JsonReader;

public class UserConsole implements ActionListener, ObserverIF {
	private Kunde identity;
	private JsonReader jr;;
	private BufferedReader br;
	
	public UserConsole() {
		this.jr = new JsonReader();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void start() throws IOException {
		while(true) {
			while(this.identity == null) {
				String input = readLine("Sind Sie eine neue Kunde? [ja/nein] ");
				switch (input) {
				case "J", "j", "Ja", "ja":
					registerNewUser();
					break;
				case "N", "n", "Nein", "nein":
					login();
					break;
				default:
					break;
				}
			
				while (this.identity != null) {
					System.out.println("(1) Girokonto erstellen");
					System.out.println("(2) Depotkonto erstellen");
					System.out.println("(3) Konten anzeigen");
					System.out.println("(4) Ausloggen");
					input = readLine("Was möchten Sie machen? [1-3]");
					switch (Integer.parseInt(input)) {
					case 1:
						try {
							createGirokonto();
						} catch (IllegalAccessException e) {
							System.out.println("Sie haben kein Zugriff!");
						}
						break;
					case 4:
						this.identity = null;
					default:
						break;
					}
				}
			}
			
		}
	}
	
	public boolean login() throws IOException {
		System.out.println("[Einloggen]");
		String benutzername = readLine("Benutzername: ");
		String password = readLine("Password: ");
		try {
			if (jr.login(benutzername, password.toString())) {
				this.identity = jr.getKunde(benutzername);
				System.out.println("Login erfolgreich...\n");
				
				System.out.println("Hallo " + benutzername + "!");
				return true;
			} else {
				System.out.println("Sie haben ein falsches ");
			}
		} catch (IOException e) {
			System.out.println("Benutzername/Password war falsch!");
			System.out.println("Bitte noch mal versuchen oder registrieren Sie sich!");
//			e.printStackTrace();
		}
		
		System.out.println("Login nicht erfolgreich...\n");
		return false;
	}

	public boolean registerNewUser() throws IOException {
		if (this.identity != null) {
			return false;
		}
		
		System.out.println("[Neues Konto erstellen]");
		String benutzername, name, adresse, telefonnummer, ausweisnummer, password;


		name = readLine("Name: ");
		adresse = readLine("Adresse: ");
		telefonnummer = readLine("Telefonnummer: ");
		ausweisnummer = readLine("Personalausweisnummer: ");
		
		HashMap<String, String> personaldaten = new HashMap<>();
		personaldaten.put("name", name);
		personaldaten.put("adresse", adresse);
		personaldaten.put("telefonnummer", telefonnummer);
		personaldaten.put("personalausweisnummer", ausweisnummer);
		this.identity = new Kunde(personaldaten);
		
		benutzername = readLine("Benutzername: ");
		this.identity.setPersonalData("username", benutzername);
		while (true) {
			password = readLine("Password: ");
		    Pattern passwordRegex = Pattern.compile("^\\w{9,}$");
		    Matcher matcher = passwordRegex.matcher(password);
		    
		    if (!matcher.find()) {
		    	System.out.println("Mind. 9 Zeichen aus Alphabet und Nummern!");
		    } else {
		    	break;
		    }
		}
	    
		jr.saveLogin(benutzername, password);
		jr.saveKunde(this.identity);

		System.out.println("Sie haben sich erfolgreich als Kunde registriert!");
		System.out.println("Willkommen " + benutzername);
		return true;
	}

	public void createDepotkonto(int referenzkontoId) throws IllegalAccessException {
		if (this.identity == null) {
			throw new IllegalAccessException("Not logged in");
		}

		this.identity.createDepotkonto(referenzkontoId);
	}

	public void createGirokonto() throws IllegalAccessException, IOException {
		if (this.identity == null) {
			throw new IllegalAccessException("Not logged in");
		}
		System.out.println("[Girokonto erstellen]");
		double anfangssaldo = Double.parseDouble(readLine("Anfangssaldo: "));
		Girokonto newKonto = this.identity.createGirokonto(anfangssaldo);
		
		System.out.println("Konto erstellt!");
		System.out.println("Id: " + newKonto.getId());
		System.out.println("IBAN: " + newKonto.getIban());
		System.out.println("Saldo: " + newKonto.getSaldo());
	}

	public void removeKonto(int kontoId) throws IllegalAccessException {
		if (this.identity == null) {
			throw new IllegalAccessException("Not logged in");
		}

		this.identity.removeKonto(kontoId);
	}

	public String getPersonalData(String key) {
		return this.identity.getPersonaldaten().get(key);
	}

	public void setPersonalData(String key, String value) {
		this.identity.setPersonalData(key, value);
	}

	public void removePersonalData(String key) {
		this.identity.removePersonalData(key);
	}

	private String readLine(String prompt) throws IOException {
		System.out.print(prompt);
		return br.readLine();
	}

	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void update() {

	}
}
