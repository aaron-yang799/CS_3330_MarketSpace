package edu.mu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import edu.mu.dao.ListingsDao;
import edu.mu.model.ListingPreview;
import edu.mu.model.User;

/**
 * Servlet implementation class CreateBidServlet
 */
public class CreateBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String listingTitle = request.getParameter("listingTitle");
		int listingID = Integer.parseInt(request.getParameter("listingId"));
		float minimumBid = Float.parseFloat(request.getParameter("minimumBid"));
		float highestBid = Float.parseFloat(request.getParameter("highestBid"));
		float UserBid = Float.parseFloat(request.getParameter("userBid"));

		
		if (UserBid > minimumBid && UserBid > highestBid){
			ListingsDao.createBid(listingID, UserBid);
			request.setAttribute("listingTitle", listingTitle);
			request.setAttribute("BidCreated", "Created!");
			
			HttpSession session = request.getSession();
			Object placeholder = session.getAttribute("otherListingsPrev");
			ArrayList<ListingPreview> ListObj = (ArrayList<ListingPreview>) placeholder;
			
			for(ListingPreview listing: ListObj) {
				if (listing.getListing_id() == listingID) {
					listing.setHighest_bid(UserBid);
				}
			}
			
			
			
//			Object userObj = session.getAttribute("user");
//			User user = (User) userObj;
//	        ArrayList<ListingPreview> list = ListingsDao.getOtherListingsPrev(user);
//	        for(ListingPreview name: list) {
//	        	System.out.println(name.getTitle());
//	        }
//	        session.setAttribute("otherListingsPrev", list);
			
		    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		else if(UserBid < minimumBid && UserBid < highestBid) {
			String underAllError = "Your bid must be higher than the minimum bid and current highest bid.";
			request.setAttribute("underAllError", underAllError);
			request.getRequestDispatcher("listingView.jsp").forward(request, response);
		}
		
		else if(UserBid < highestBid && UserBid > minimumBid) {
			String underHighBidError = "Your bid must be higher than the current highest bid.";
			request.setAttribute("underHighBidError", underHighBidError);
			request.getRequestDispatcher("listingView.jsp").forward(request, response);
		}
		
		else if(UserBid < minimumBid) {
			String underMinBidError = "Your bid must be higher than the minimum bid.";
			request.setAttribute("underMinBidError", underMinBidError);
			request.getRequestDispatcher("listingView.jsp").forward(request, response);
		}
	}
}
