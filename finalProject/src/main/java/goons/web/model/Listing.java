package goons.web.model;
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
	
	public Listing(String title, LocalDate timePosted, LocalDate timeEnd, ArrayList<String> description,
			float minimumBid, float buyOutPrice, ArrayList<Bid> bidList, ArrayList<User> watchList) {
		super();
		this.title = title;
		this.timePosted = timePosted;
		this.timeEnd = timeEnd;
		this.description = new ArrayList<String>();
		this.minimumBid = minimumBid;
		this.buyOutPrice = buyOutPrice;
		this.bidList = new ArrayList<Bid>();
		this.watchList = new ArrayList<User>();
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
	
	
	
	
}
