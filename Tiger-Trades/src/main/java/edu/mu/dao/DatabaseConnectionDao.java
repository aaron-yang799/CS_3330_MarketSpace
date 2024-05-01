package edu.mu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionDao {
	
	private static DatabaseConnectionDao instance = null;
	
	private DatabaseConnectionDao() {
	}
	
	public static DatabaseConnectionDao getInstance() {
		if(instance == null) {
			instance = new DatabaseConnectionDao();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://auctiondb.cnge86iqy455.us-east-2.rds.amazonaws.com:3306/Auction_DB", "admin", "auctionDB");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
