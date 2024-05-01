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
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT HashedPass FROM Auction_User WHERE Email = ?");
			ps.setString(1, this.email);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				String HashedPass = rs.getString("HashedPass");
				if(BCrypt.checkpw(this.password, HashedPass)) {
					ps.close();
					return true;
				}
			}else {
				ps.close();
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
