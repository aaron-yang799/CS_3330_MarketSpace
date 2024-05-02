package edu.mu.dao;
import java.sql.*;

import edu.mu.model.User;
import jakarta.servlet.http.HttpSession;

public class CreateListingDao {
	private String title;
	private String description;
	private float buyOut;
	private Date timeEnd;
	private Integer UserID;
	
	public CreateListingDao(String title, String description, float buyOut, Date timeEnd, Integer UserID) {
		this.title = title;
		this.description = description;
		this.buyOut = buyOut;
		this.timeEnd = timeEnd;
		this.UserID = UserID;
	}

	public void CreateListing() {
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("INSERT INTO Listing (Title, TimeEnd, Listing_Description, Buy_Out, User_ID) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, this.title);
			ps.setDate(2, this.timeEnd);
			ps.setString(3, this.description);
			ps.setFloat(4, this.buyOut);
			ps.setInt(5, this.UserID);
			
					
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
}
