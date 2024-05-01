package edu.mu.dao;

import edu.mu.model.Listing;
import edu.mu.model.User;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

public class SearchListingDao {
	
	public ArrayList<Listing> SearchListing(String query) {
		ArrayList<Listing> Listings = new ArrayList<Listing>();
		
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT * FROM Listing WHERE Title LIKE ?");
			ps.setString(1, "%" + query + "%");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//if listing found do something
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
				
		return Listings;
	}
}
