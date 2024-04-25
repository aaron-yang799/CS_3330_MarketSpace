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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Listing> getListingList() {
		return ListingList;
	}

	public void setListingList(ArrayList<Listing> listingList) {
		ListingList = listingList;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public ArrayList<String> getAddressList() {
		return AddressList;
	}

	public void setAddressList(ArrayList<String> addressList) {
		AddressList = addressList;
	}

	public ArrayList<Bid> getBidList() {
		return BidList;
	}

	public void setBidList(ArrayList<Bid> bidList) {
		BidList = bidList;
	}

	public ArrayList<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		OrderList = orderList;
	}

	public ArrayList<Listing> getWatchList() {
		return WatchList;
	}

	public void setWatchList(ArrayList<Listing> watchList) {
		WatchList = watchList;
	}
	
	
	
}
