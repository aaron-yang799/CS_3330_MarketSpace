package goons.web.model;

import org.mindrot.jbcrypt.BCrypt;

import dao.exampleDao;

public class Main {
	public static void main(String[] args) {
		exampleDao test = new exampleDao();
		String password = "aaronyang789";
//		String HashedPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
//      test.insertData("Aaron Yang", HashedPass, "aaronyang@test.com", (float) 523.99);
        String gottenName = test.getWallet(password, "Aaron Yang");
        System.out.println(gottenName);
        
	}	

}
