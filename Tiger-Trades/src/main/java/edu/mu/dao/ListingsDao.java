package edu.mu.dao;

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

public class ListingsDao {
	public static void CreateListing(String title, String description, float buyOut, Date timeEnd, int user_id, float minBid) {
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("INSERT INTO Listing (Title, TimeEnd, Listing_Description, Buy_Out, User_ID, Minimum_Bid) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, title);
			ps.setDate(2, timeEnd);
			ps.setString(3, description);
			ps.setFloat(4, buyOut);
			ps.setInt(5, user_id);
			ps.setFloat(6, minBid);
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Created a new Listing!");
			}
			
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Listing> SearchListing(String query) {
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
	
	public static ArrayList<ListingPreview> getOtherListingsPrev(User user) {
		ArrayList<ListingPreview> listings = new ArrayList<ListingPreview>();
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Listing_ID, Title, TimeEnd, Minimum_Bid FROM Listing WHERE User_ID != ?");
			System.out.println(user);
			ps.setInt(1, user.getUserid());
			
			ResultSet set = ps.executeQuery();
			//execute query to get listing preview information for listings that aren't from the current user.
			
			
			System.out.println(set);
			if (!set.next()) {
			    System.out.println("ResultSet is empty.");
			} else {
			    do {
			    	System.out.println(set.getFloat("Minimum_Bid"));
			    	int listing_id = set.getInt("Listing_ID");
					String title = set.getString("Title");
					LocalDate timeEnd = set.getDate("TimeEnd").toLocalDate();
					long timeUntilEnd = ChronoUnit.DAYS.between(LocalDate.now(), timeEnd);
					// getting all bids for the current listing in the result set.
					PreparedStatement ps2 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Amount_Bid FROM Bid WHERE Listing_ID = ? ORDER BY Amount_Bid DESC LIMIT 1");
					ps2.setInt(1, listing_id);
					ResultSet set2 = ps2.executeQuery();
					if(!set2.next()) {
						System.out.println("ResultSet2 is empty.");
						listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set.getFloat("Minimum_Bid")));
					} else {
						float highest = set2.getFloat("Amount_Bid");
						listings.add(new ListingPreview(listing_id, title, timeUntilEnd, highest));
					}
			    } while (set.next()); // Move to the next row and check if it exists
			}
		}catch(SQLException e) {

			e.printStackTrace();
		}
		
		return listings;
	}
	
	public static ArrayList<ListingPreview> getUserListings(User user) {
		ArrayList<ListingPreview> listings = new ArrayList<ListingPreview>();
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Listing_ID, Title, TimeEnd, Minimum_Bid FROM Listing WHERE User_ID = ?");
			System.out.println(user);
			ps.setInt(1, user.getUserid());
			
			ResultSet set = ps.executeQuery();
			//execute query to get listing preview information for listings that aren't from the current user.
			
			
			System.out.println(set);
			if (!set.next()) {
			    System.out.println("ResultSet is empty.");
			} else {
			    do {
			    	System.out.println(set.getFloat("Minimum_Bid"));
			    	int listing_id = set.getInt("Listing_ID");
					String title = set.getString("Title");
					LocalDate timeEnd = set.getDate("TimeEnd").toLocalDate();
					long timeUntilEnd = ChronoUnit.DAYS.between(LocalDate.now(), timeEnd);
					// getting all bids for the current listing in the result set.
					PreparedStatement ps2 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Amount_Bid FROM Bid WHERE Listing_ID = ? ORDER BY Amount_Bid DESC LIMIT 1");
					ps2.setInt(1, listing_id);
					ResultSet set2 = ps2.executeQuery();
					if(!set2.next()) {
						System.out.println("ResultSet2 is empty.");
						listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set.getFloat("Minimum_Bid")));
					} else {
						float highest = set2.getFloat("Amount_Bid");
						listings.add(new ListingPreview(listing_id, title, timeUntilEnd, highest));
					}
			    } while (set.next()); // Move to the next row and check if it exists
			}
		}catch(SQLException e) {

			e.printStackTrace();
		}
		
		return listings;
	}
	
	public static Listing getListingByID(int ID) {
		Listing listing = null;
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Listing_ID, Title, TimePosted, TimeEnd, ListingDescription, Minimum_Bid, Buy_Out FROM Listing WHERE Listing_ID = ?");
			System.out.println(ID);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				listing = new Listing(null, null, null, null, ID, ID);
				listing.setListing_id(ID);
				listing.setTitle(rs.getString("title"));
				listing.setTimePosted(rs.getDate("TimePosted"));
				listing.setTimeEnd(rs.getDate("TimeEnd"));
				listing.setDescription(rs.getString("ListingDescription"));
				listing.setMinimumBid(rs.getFloat("Minimum_Bid"));
				listing.setBuyOutPrice(rs.getFloat("Buy_Out"));
			}
		}catch(SQLException e) {

			e.printStackTrace();
		}
		return listing;
	}
}
