package edu.mu.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import edu.mu.model.User;
import edu.mu.model.Listing;
import edu.mu.model.ListingPreview;

public class UserDao {
	
	public static void addToWallet(int userID, int amount) {
		PreparedStatement ps;
		try {
			Connection connection = DatabaseConnectionDao.getInstance().getConnection();
			ps = connection.prepareStatement("SELECT Wallet from Auction_User WHERE User_ID = ?");
			ps.setInt(1, userID);
	        ResultSet rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	PreparedStatement ps2 = connection.prepareStatement("UPDATE Listing SET Wallet = ? WHERE User_ID = ?");
                ps2.setFloat(1, amount + rs.getFloat("Wallet"));
                ps2.setInt(2, userID);
                ps2.executeUpdate();
                ps2.close();
	        }
	        ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
