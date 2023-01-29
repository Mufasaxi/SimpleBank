package g2.bankkontoverwaltung.view;

import java.util.HashMap;

public class LoginData {
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	//contains all username and passwords
	LoginData(){
		loginInfo.put("user1", "pass1");
		loginInfo.put("user2", "pass2");
		loginInfo.put("user3", "pass3");
	}
	
	HashMap getLoginInfo(){
		return loginInfo;
	}
	
}
