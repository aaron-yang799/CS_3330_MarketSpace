package edu.mu.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order extends Listing{
	private Status status;
	private LocalDate arrivalDate;
	private float totalCost;
	
	public Order(Listing listing) {
		super(listing);
		this.arrivalDate = LocalDate.now().plusDays(5);
		this.totalCost = (float) ((listing.getHighestBid() + 5.00) * 1.10);
		this.status = Status.PACKAGING;
	}

	public Status getStatus() {
		if(LocalDate.now().isEqual(arrivalDate) || LocalDate.now().isAfter(arrivalDate)) {
			this.status = Status.DELIVERED;
		}else if(LocalDate.now().isBefore(arrivalDate)) {
			this.status = Status.SHIPPED;
		}
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	

}
