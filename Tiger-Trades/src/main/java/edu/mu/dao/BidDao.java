package edu.mu.dao;

import edu.mu.model.Bid;
import edu.mu.model.User;
import edu.mu.model.Listing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BidDao {

    public void createBid(Bid bid, int listingId) {
        try {
            Connection connection = DatabaseConnectionDao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Bid (Listing_ID, Bidder_ID, Amount_Bid,) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, listingId);
            ps.setInt(2, bid.getBidder().getUserid());
            ps.setFloat(3, bid.getAmountBidded());
            
            int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Created a new Bid!");
			}
    
            
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bid> getUserBids(User user) {
        ArrayList<Bid> bids = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionDao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Bid WHERE Bidder_ID = ?");
            ps.setInt(1, user.getUserid());
            ResultSet set = ps.executeQuery();

            while (set.next()) {
                int bid_ID = set.getInt("Bid_ID");
                float amountBidded = set.getFloat("Amount_Bid");
                Listing listItem = new ListingsDao().getListingByID(set.getInt("Listing_ID"));
                Bid bid = new Bid(bid_ID, user, amountBidded, listItem);
                bids.add(bid);
            }
            set.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bids;
    }

    public Bid getBidByID(int ID, User user) {
        Bid bid = null;
        try {
            Connection connection = DatabaseConnectionDao.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Bid WHERE Bid_ID = ? AND Bidder_ID = ?");
            ps.setInt(1, ID);
            ps.setInt(2, user.getUserid());
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                float amountBidded = rs.getFloat("Amount_Bid");
                Listing listItem = new ListingsDao().getListingByID(rs.getInt("Listing_ID"));
                bid = new Bid(ID, user, amountBidded, listItem);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }
}