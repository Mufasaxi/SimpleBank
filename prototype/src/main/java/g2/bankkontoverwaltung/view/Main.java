package g2.bankkontoverwaltung.view;


public class Main {

	public static void main(String[] args) {
		LoginData loginData = new LoginData();
		
		LoginPage loginPage = new LoginPage(loginData.getLoginInfo());
	}

}
