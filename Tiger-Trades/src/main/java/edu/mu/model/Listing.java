package edu.mu.model;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Listing {
	private int listing_id;
	private String title;
	private Date timePosted;
	private Date timeEnd;
	private String description;
	private float minimumBid;
	private float buyOutPrice;
	private ArrayList<Bid> bidList;
	private ArrayList<User> watchList;
	
	public Listing(String title, Date timePosted, Date timeEnd, String description, float minimumBid, float buyOutPrice) {
		this.title = title;
		this.timePosted = timePosted;
		this.timeEnd = timeEnd;
		this.description = description;
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

	public Date getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
	
	public int getListing_id() {
		return listing_id;
	}

	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}
	
}
