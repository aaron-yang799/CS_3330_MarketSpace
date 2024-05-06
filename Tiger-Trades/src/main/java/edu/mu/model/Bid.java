package edu.mu.model;

public class Bid {
	private int bidID;
	private User bidder;
	private float amountBidded;
	private Listing listItem;
	

	public Bid(int bidID, User bidder, float amountBidded, Listing listItem) {
		this.bidID = bidID;
		this.bidder = bidder;
		this.amountBidded = amountBidded;
		this.listItem = listItem;
	}

	public int getBidID() {
		return bidID;
	}

	public void setBidID(int bidID) {
		this.bidID = bidID;
	}

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User bidder) {
		this.bidder = bidder;
	}

	public float getAmountBidded() {
		return amountBidded;
	}

	public void setAmountBidded(float amountBidded) {
		this.amountBidded = amountBidded;
	}
	
	public void setListing(Listing listItem)
	{
		this.listItem = listItem;
		
	}
	
	public Listing getListing()
	{
		return listItem;
	}
	
	
}