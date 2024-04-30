package edu.mu.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Listing {
	private String title;
	private LocalDate timePosted;
	private LocalDate timeEnd;
	private ArrayList<String> description;
	private float minimumBid;
	private float buyOutPrice;
	private ArrayList<Bid> bidList;
	private ArrayList<User> watchList;
	
	public Listing(String title, LocalDate timePosted, LocalDate timeEnd, float minimumBid, float buyOutPrice) {
		this.title = title;
		this.timePosted = timePosted;
		this.timeEnd = timeEnd;
		this.description = new ArrayList<String>();
		this.minimumBid = minimumBid;
		this.buyOutPrice = buyOutPrice;
		this.bidList = new ArrayList<Bid>();
		this.watchList = new ArrayList<User>();
	}
	
	public Listing(Listing listing) {
		this.title = listing.title;
		this.timePosted = listing.timePosted;
		this.timeEnd = listing.timeEnd;
		this.description = listing.description;
		this.minimumBid = listing.minimumBid;
		this.buyOutPrice = listing.buyOutPrice;
		this.bidList = listing.bidList;
		this.watchList = listing.watchList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(LocalDate timePosted) {
		this.timePosted = timePosted;
	}

	public LocalDate getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDate timeEnd) {
		this.timeEnd = timeEnd;
	}

	public ArrayList<String> getDescription() {
		return description;
	}

	public void setDescription(ArrayList<String> description) {
		this.description = description;
	}

	public float getMinimumBid() {
		return minimumBid;
	}

	public void setMinimumBid(float minimumBid) {
		this.minimumBid = minimumBid;
	}

	public float getBuyOutPrice() {
		return buyOutPrice;
	}

	public void setBuyOutPrice(float buyOutPrice) {
		this.buyOutPrice = buyOutPrice;
	}

	public ArrayList<Bid> getBidList() {
		return bidList;
	}

	public void setBidList(ArrayList<Bid> bidList) {
		this.bidList = bidList;
	}

	public ArrayList<User> getWatchList() {
		return watchList;
	}

	public void setWatchList(ArrayList<User> watchList) {
		this.watchList = watchList;
	}
	
	public float getHighestBid() {
		float highestBid = (float) 0.00;
		
		for(Bid bid : this.bidList) {
			if(bid.getAmountBidded() > highestBid) {
				highestBid = bid.getAmountBidded();
			}
		}
		return highestBid;
	}
	
	
}
