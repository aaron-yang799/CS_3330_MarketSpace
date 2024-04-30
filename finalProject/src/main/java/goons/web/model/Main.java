package goons.web.model;

import org.mindrot.jbcrypt.BCrypt;

import dao.exampleDao;

public class Main {
	public static void main(String[] args) {
		exampleDao test = new exampleDao();
		String password = "monkeies!";
//		String HashedPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
//		test.insertData("Aaron Yang", HashedPass, "aaronyang@test.com");
		String HashedPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
		test.insertData("Zach Snyder", HashedPass, "Zachsnyder@test.com");
//        String gottenName = test.getWallet(password, "Aaron Yang");
//        System.out.println(gottenName);
        
	}

}
