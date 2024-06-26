package edu.mu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import edu.mu.model.User;
import jakarta.servlet.http.HttpSession;
import edu.mu.model.Bid;
import edu.mu.model.Listing;
import edu.mu.model.ListingPreview;

// TODO clear out-dated listings from the database!


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
			ps.close();

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
			    	int listing_id = set.getInt("Listing_ID");
					String title = set.getString("Title");
					LocalDate timeEnd = set.getDate("TimeEnd").toLocalDate();
					long timeUntilEnd = ChronoUnit.DAYS.between(LocalDate.now(), timeEnd);
					// getting all bids for the current listing in the result set.
					PreparedStatement ps2 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Amount_Bid, Bidder_ID FROM Bid WHERE Listing_ID = ? ORDER BY Amount_Bid DESC LIMIT 1");
					ps2.setInt(1, listing_id);
					ResultSet set2 = ps2.executeQuery();
					if(!set2.next()) {
						System.out.println("ResultSet2 is empty.");
						if( timeUntilEnd <= 0) {
							ListingsDao.deleteListing(listing_id);
							
						}else {
							listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set.getFloat("Minimum_Bid")));
						}
					} else {
						if( timeUntilEnd <= 0) {
							Listing listing = getListingByID(listing_id);
							PreparedStatement ps3 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Wallet FROM Auction_User WHERE User_ID = ?");
							ps3.setInt(1, set2.getInt("Bidder_ID"));
							ResultSet rs3 = ps3.executeQuery();
							if(rs3.next()) {
								PreparedStatement ps4 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("UPDATE Auction_User SET Wallet = ? WHERE User_ID = ?");
								ps4.setInt(2, set2.getInt("Bidder_ID"));
								ps4.setFloat(1, rs3.getFloat("Wallet") - (float) (listing.getHighestBid() * 1.08));
								ps4.executeUpdate();
								ps4.close();
							}
							ps3.close();
							ListingsDao.listingToOrder(listing_id, set2.getInt("Bidder_ID"));
						}else {
							listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set2.getFloat("Amount_Bid")));
						}
					}
			    } while (set.next()); // Move to the next row and check if it exists
			}
			ps.close();
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
			    return null;
			} else {
			    do {
			    	System.out.println(set.getFloat("Minimum_Bid"));
			    	int listing_id = set.getInt("Listing_ID");
					String title = set.getString("Title");
					LocalDate timeEnd = set.getDate("TimeEnd").toLocalDate();
					long timeUntilEnd = ChronoUnit.DAYS.between(LocalDate.now(), timeEnd);
					// getting all bids for the current listing in the result set.
					PreparedStatement ps2 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Amount_Bid, Bidder_ID FROM Bid WHERE Listing_ID = ? ORDER BY Amount_Bid DESC LIMIT 1");
					ps2.setInt(1, listing_id);
					ResultSet set2 = ps2.executeQuery();
					if(!set2.next()) {
						System.out.println("ResultSet2 is empty.");
						if( timeUntilEnd <= 0) {
							ListingsDao.deleteListing(listing_id);
						}else {
							listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set.getFloat("Minimum_Bid")));
						}
					} else {
						if( timeUntilEnd <= 0) {
							Listing listing = getListingByID(listing_id);
							PreparedStatement ps3 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Wallet FROM Auction_User WHERE User_ID = ?");
							ps3.setInt(1, set2.getInt("Bidder_ID"));
							ResultSet rs3 = ps3.executeQuery();
							if(rs3.next()) {
								PreparedStatement ps4 = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("UPDATE Auction_User SET Wallet = ? WHERE User_ID = ?");
								ps4.setInt(2, set2.getInt("Bidder_ID"));
								ps4.setFloat(1, rs3.getFloat("Wallet") - (float) (listing.getHighestBid() * 1.08));
								ps4.executeUpdate();
								ps4.close();
							}
							ps3.close();
							ListingsDao.listingToOrder(listing_id, set2.getInt("Bidder_ID"));
						}else {
							listings.add(new ListingPreview(listing_id, title, timeUntilEnd, set2.getFloat("Amount_Bid")));
						}
					}
			    } while (set.next()); // Move to the next row and check if it exists
			}
			ps.close();
		}catch(SQLException e) {

			e.printStackTrace();
		}
		
		return listings;
	}
	
	
	public static Listing getListingByID(int ID) {
		Listing listing = null;
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT Listing_ID, Title, TimePosted, TimeEnd, Listing_Description, Minimum_Bid, Highest_Bid, Buy_Out FROM Listing WHERE Listing_ID = ?");
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				listing = new Listing(null, null, null, null, 0, 0, 0);
				listing.setListing_id(rs.getInt("Listing_ID"));
				listing.setTitle(rs.getString("title"));
				listing.setTimePosted(rs.getDate("TimePosted"));
				listing.setTimeEnd(rs.getDate("TimeEnd"));
				listing.setDescription(rs.getString("Listing_Description"));
				listing.setMinimumBid(rs.getFloat("Minimum_Bid"));
				listing.setHighestBid(rs.getFloat("Highest_Bid"));
				listing.setBuyOutPrice(rs.getFloat("Buy_Out"));
			}
			ps.close();
		}catch(SQLException e) {

			e.printStackTrace();
		}
		return listing;
	}
	
	public static void createBid(int listingID, float bid, int bidderID) {
		try {
	        Connection connection = DatabaseConnectionDao.getInstance().getConnection();
	        PreparedStatement ps = connection.prepareStatement("SELECT Highest_Bid FROM Listing WHERE Listing_ID = ?");
	        ps.setInt(1, listingID);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
                PreparedStatement ps2 = connection.prepareStatement("UPDATE Listing SET Highest_Bid = ? WHERE Listing_ID = ?");
                ps2.setFloat(1, bid);
                ps2.setInt(2, listingID);
                ps2.executeUpdate();
                ps2.close();
                
    	        try {
    		        PreparedStatement ps3 = connection.prepareStatement("INSERT INTO Bid (Listing_ID, Bidder_ID, Amount_Bid) VALUES (?, ?, ?)");
    		        ps3.setInt(1, listingID);
    		        ps3.setInt(2, bidderID);
    		        ps3.setFloat(3, bid);
    				ps3.executeUpdate();
    				ps3.close();
    			} catch (SQLException e) {
    				// TODO: handle exception
    			}
                
	        }
	        ps.close();
            connection.close();

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listingToOrder(int listing_id, int user_id) {
		Connection connection = DatabaseConnectionDao.getInstance().getConnection();
		try {
			Listing listing = getListingByID(listing_id);
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Purchased_Listing (Item, Total_cost, User_id) VALUES (?, ?, ?)");
			ps.setString(1,listing.getTitle() );
			ps.setFloat(2, (float)(listing.getHighestBid() * 1.08));
			ps.setInt(3, user_id);
			ps.executeUpdate();
			
			ListingsDao.deletebids(listing_id);
			
			ListingsDao.deleteListing(listing_id);
			
			ps.close();
            connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listingToOrderBuyOut(int listing_id, int user_id, float buyOut) {
		Connection connection = DatabaseConnectionDao.getInstance().getConnection();
		try {
			Listing listing = getListingByID(listing_id);
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Purchased_Listing (Item, Total_cost, User_id) VALUES (?, ?, ?)");
			ps.setString(1,listing.getTitle() );
			ps.setFloat(2, (float)(buyOut * 1.08));
			ps.setInt(3, user_id);
			ps.executeUpdate();

			
			PreparedStatement ps2 = connection.prepareStatement("SELECT Wallet FROM Auction_User WHERE User_ID = ?");
			ps2.setInt(1, user_id);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()) {
				PreparedStatement ps3 = connection.prepareStatement("UPDATE Auction_User SET Wallet = ? WHERE User_ID = ?");
				ps3.setInt(2, user_id);
				ps3.setFloat(1, ((float)rs2.getFloat("Wallet") - (float)(buyOut * 1.08)));
				ps3.executeUpdate();
				ps3.close();
			}
			
			ListingsDao.deletebids(listing_id);
			ListingsDao.deleteListing(listing_id);
			ps2.close();
			ps.close();
            connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Bid> getUserBids(User user) {
		
        ArrayList<Bid> bids = new ArrayList<Bid>();
        
       
		
		
		
		
        try {
            PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("SELECT * FROM Bid WHERE Bidder_ID = ?");
            ps.setInt(1, user.getUserid());

            ResultSet set = ps.executeQuery();

            while (set.next()) {
                int bidId = set.getInt("Bid_ID");
                int listingId = set.getInt("Listing_ID");
                Listing listing = ListingsDao.getListingByID(listingId); // Fetch the Listing
                float amountBid = set.getFloat("Amount_Bid");
                bids.add(new Bid(bidId, user, amountBid, listing)); // Pass the User object instead of the id
            }
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return bids;
    }
	
	public static boolean deleteListing(int listing_id) {
		Connection connection = DatabaseConnectionDao.getInstance().getConnection();
		try {
			PreparedStatement ps2 = connection.prepareStatement("DELETE FROM Listing WHERE Listing_ID = ?");
			ps2.setInt(1, listing_id);
			
			int rowsDeleted = ps2.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A listing was deleted!");
            }
            ps2.close();
            return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean deletebids(int listing_id) {
		Connection connection = DatabaseConnectionDao.getInstance().getConnection();
		try {
			PreparedStatement ps2 = connection.prepareStatement("DELETE FROM Bid WHERE Listing_ID = ?");
			ps2.setInt(1, listing_id);
			
			int rowsDeleted = ps2.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Bid was deleted!");
            }
            ps2.close();
            return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}


