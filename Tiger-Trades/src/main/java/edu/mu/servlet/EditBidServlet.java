package edu.mu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

import edu.mu.dao.BidDao;
import edu.mu.dao.ListingsDao;
import edu.mu.model.Bid;
import edu.mu.model.User;
import edu.mu.model.Listing;

//@WebServlet("/EditBidServlet")
public class EditBidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String bidIdStr = request.getParameter("bidId");
		int bidId = bidIdStr != null ? Integer.parseInt(bidIdStr) : 0;
        String newBidAmountStr = request.getParameter("newBidAmount");
		float newBidAmount = newBidAmountStr != null ? Float.parseFloat(newBidAmountStr) : 0.0f;
        int listingId = Integer.parseInt(request.getParameter("listingId"));

        BidDao bidDao = new BidDao();
        Bid bid = bidDao.getBidByID(bidId, user);

        if (bid != null && user != null) {
            bid.setAmountBidded(newBidAmount);
           // bidDao.updateBid(bid);
        } else {
            // Handle the case where the bid or user is null
            
            ListingsDao listingsDao = new ListingsDao();
            Listing listing = listingsDao.getListingByID(listingId);
            bid = new Bid(user, newBidAmount, listing);
             bidDao.createBid(bid, listingId);
            
        }
		    System.out.println("Created bid with ID: " + bid.getId() + " for listing ID: " + listingId);

        response.sendRedirect("bids.jsp");
    }
}