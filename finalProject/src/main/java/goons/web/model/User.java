package goons.web.model;

import java.util.ArrayList;

public class User {
	private String username;
	private String hashKey;
	private String email;
	private ArrayList<Listing> ListingList;
	private float wallet;
	private ArrayList<String> AddressList;
	private ArrayList<Bid> BidList;
	private ArrayList<Order> OrderList;
	private ArrayList<Listing> WatchList;
	
	public User(String username, String hashKey, String email, ArrayList<Listing> listingList, float wallet,
			ArrayList<String> addressList, ArrayList<Bid> bidList, ArrayList<Order> orderList,
			ArrayList<Listing> watchList) {
		this.username = username;
		this.hashKey = hashKey;
		this.email = email;
		this.ListingList = new ArrayList<Listing>();
		this.wallet = wallet;
		this.AddressList = new ArrayList<String>();
		this.BidList = new ArrayList<Bid>();
		this.OrderList = new ArrayList<Order>();
		this.WatchList = new ArrayList<Listing>();
	}
	
	
}
