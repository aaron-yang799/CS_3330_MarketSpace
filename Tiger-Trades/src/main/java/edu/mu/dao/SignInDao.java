package edu.mu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import edu.mu.model.User;

public class SignInDao {
	private String email;
	private String password;

	
	public SignInDao(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User Authenticate() {
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT HashedPass, User_ID , Username, Wallet, Address FROM Auction_User WHERE Email = ?");
			ps.setString(1, this.email);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				String HashedPass = rs.getString("HashedPass");
				if(BCrypt.checkpw(this.password, HashedPass)) {
					User user = new User(rs.getInt("User_ID"), rs.getString("Username"), this.email, rs.getFloat("Wallet"), rs.getString("address"));
					ps.close();
					return user;
				}
			}else {
				ps.close();
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
