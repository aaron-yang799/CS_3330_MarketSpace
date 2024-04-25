package goons.web.model;

public class Review {
	private int rating;
	private String description;

	
	
	public Review(int rating, String description) {
		this.rating = rating;
		this.description = description;
	}
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
