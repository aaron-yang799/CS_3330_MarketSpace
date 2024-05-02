package edu.mu.model;

public class ListingPreview {
	
	
	int listing_id;
	String title;
	long timeUntilEnd;
	float highest_bid;
	
	
	
	public ListingPreview(int listing_id, String title, long timeEnd, float highest_bid) {
		this.listing_id = listing_id;
		this.title = title;
		this.timeUntilEnd = timeEnd;
		this.highest_bid = highest_bid;
	}
	public int getListing_id() {
		return listing_id;
	}
	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getTimeEnd() {
		return timeUntilEnd;
	}
	public void setTimeEnd(long timeEnd) {
		this.timeUntilEnd = timeEnd;
	}
	public float getHighest_bid() {
		return highest_bid;
	}
	public void setHighest_bid(float highest_bid) {
		this.highest_bid = highest_bid;
	}
	
}
