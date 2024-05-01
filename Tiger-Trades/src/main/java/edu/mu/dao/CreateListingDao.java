package edu.mu.dao;
import java.sql.*;
import java.sql.Date;

public class CreateListingDao {
	private String title;
	private String description;
	private float buyOut;
	private Date timeEnd;
	
	public CreateListingDao(String title, String description, float buyOut, Date timeEnd) {
		this.title = title;
		this.description = description;
		this.buyOut = buyOut;
		this.timeEnd = timeEnd;
	}

	public void CreateListing() {
		try {
			PreparedStatement ps = DatabaseConnectionDao.getInstance().getConnection().prepareStatement("INSERT INTO Listing (Title, TimeEnd, Listing_Description, Buy_Out) VALUES (?, ?, ?, ?)");
			ps.setString(1, this.title);
			ps.setDate(2, this.timeEnd);
			ps.setString(3, this.description);
			ps.setFloat(4, this.buyOut);
			
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
