package edu.mu.model;

public class Bid {
	private int id;
	private User bidder;
	private float amountBidded;
	private Listing listItem;
	
	public Bid(User bidder, float amountBidded, Listing listItem ) {
		this.bidder = bidder;
		this.amountBidded = amountBidded;
		this.listItem = listItem;
	}

	public Bid(int id,User bidder, float amountBidded, Listing listItem) {
		this.id = id;
		this.bidder = bidder;
		this.amountBidded = amountBidded;
		this.listItem = listItem;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
