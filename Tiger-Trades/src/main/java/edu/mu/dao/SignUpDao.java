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
	private String address;
	
	public SignUpDao(String name, String email, String password, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public void SignUp() {
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("INSERT INTO Auction_User (Username, HashedPass, Email, Wallet, Address) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, this.name);
			ps.setString(2, BCrypt.hashpw(this.password, BCrypt.gensalt(12)));
			ps.setString(3, this.email);
			ps.setFloat(4, (float) 0.00);
			ps.setString(5, this.address);
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
