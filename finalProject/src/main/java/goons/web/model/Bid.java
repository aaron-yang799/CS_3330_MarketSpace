package goons.web.model;

public class Bid {
	private User bidder;
	private float amountBidded;
	private Listing item;
	
	public Bid(User bidder, float amountBidded, Listing item) {
		this.bidder = bidder;
		this.amountBidded = amountBidded;
		this.item = item;
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

	public Listing getItem() {
		return item;
	}

	public void setItem(Listing item) {
		this.item = item;
	}
	
	
}
