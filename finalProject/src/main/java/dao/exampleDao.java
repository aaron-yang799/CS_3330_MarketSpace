package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import goons.web.model.DatabaseConnection;

public class exampleDao {
	
	 public void insertData(String Username, String HashedPass, String Email, float Wallet) {
	        String sql = "INSERT INTO Auction_User (Username, HashedPass, Email, Wallet) VALUES (?, ?, ?, ?)";

	        try (Connection conn = DatabaseConnection.getConnection();
	               PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                
	               pstmt.setString(1, Username);
	               pstmt.setString(2, HashedPass);
	               pstmt.setString(3, Email);
	               pstmt.setFloat(4, Wallet);
	               
	               int affectedRows = pstmt.executeUpdate(); // Execute the insertion
	               
	               if (affectedRows > 0) {
	            	   System.out.println("A new row was inserted successfully!");
	               }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public String getWallet(String Password, String Username) {
	        String Wallet = null;
	        String HashedPass = null;
	        String sql = "SELECT Wallet, HashedPass FROM Auction_User WHERE Username = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	               PreparedStatement pstmt = conn.prepareStatement(sql)) {
	               pstmt.setString(1, Username);  // Set the id for the WHERE clause
	               try (ResultSet rs = pstmt.executeQuery()) {
	                   if (rs.next()) {
	                	   HashedPass = rs.getString("HashedPass");
	                	   if(BCrypt.checkpw(Password, HashedPass)) {
	                		   Wallet = rs.getString("Wallet");
	                	   }else {
	                		   Wallet = null;
	                	   }
	                   }
	               }
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	        return Wallet;
	    }
	
}
