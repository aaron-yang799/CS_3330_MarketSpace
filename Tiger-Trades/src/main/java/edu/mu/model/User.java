package edu.mu.model;

import java.util.ArrayList;

public class User {
	private Integer userid;
	private String username;
	private String email;
	private ArrayList<Listing> ListingList;
	private float wallet;
	private String address;
	private ArrayList<Bid> BidList;
	private ArrayList<Order> OrderList;
	private ArrayList<Listing> WatchList;
	
	public User(Integer userid, String username, String email, float wallet, String address) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.ListingList = new ArrayList<Listing>();
		this.wallet = wallet;
		this.address = address;
		this.BidList = new ArrayList<Bid>();
		this.OrderList = new ArrayList<Order>();
		this.WatchList = new ArrayList<Listing>();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
