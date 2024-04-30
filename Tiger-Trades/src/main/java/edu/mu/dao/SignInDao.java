package edu.mu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class SignInDao {
	private String email;
	private String password;
	
	public SignInDao(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public boolean Authenticate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://auctiondb.cnge86iqy455.us-east-2.rds.amazonaws.com:3306/Auction_DB?useSSL=false");
			PreparedStatement ps = con.prepareStatement("SELECT FROM HashedPass FROM Auction_DB WHERE Email = ?");
			ps.setString(1, this.email);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				String HashedPass = rs.getString("HashedPass");
				if(BCrypt.checkpw(this.password, HashedPass)) {
					return true;
				}
			}else {
				return false;
			}
			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
