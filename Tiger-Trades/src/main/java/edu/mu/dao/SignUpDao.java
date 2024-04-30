package edu.mu.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class SignUpDao {
	private String name;
	private String email;
	private String password;
	
	public SignUpDao(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void SignUp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://auctiondb.cnge86iqy455.us-east-2.rds.amazonaws.com:3306/Auction_DB", "admin", "auctionDB");

			PreparedStatement ps = con.prepareStatement("INSERT INTO Auction_User (Username, HashedPass, Email, Wallet) VALUES (?, ?, ?, ?)");
			ps.setString(1, this.name);
			ps.setString(2, BCrypt.hashpw(this.password, BCrypt.gensalt(12)));
			ps.setString(3, this.email);
			ps.setFloat(4, (float) 0.00);
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			
			ps.close();
			con.close();
			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
