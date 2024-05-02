package edu.mu.model;

public class Bid {
	private User bidder;
	private float amountBidded;
	private Listing listItem;
	
	public Bid(User bidder, float amountBidded) {
		this.bidder = bidder;
		this.amountBidded = amountBidded;
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
