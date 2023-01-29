/**
 * 
 */
package g2.bankkontoverwaltung;

import java.io.Console;
import java.io.IOException;

import g2.bankkontoverwaltung.controller.User;
import g2.bankkontoverwaltung.controller.UserConsole;

/**
 * @author daryl
 *
 */
public class BankkontoverwaltungConsole {

	/**
	 * Main-Methode für Terminal-Programm
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Bankkontoverwaltung App");
		
		UserConsole user = new UserConsole();
		
		user.start();
	}

}
