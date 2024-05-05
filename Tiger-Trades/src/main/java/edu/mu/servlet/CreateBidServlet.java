package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import edu.mu.dao.ListingsDao;
import edu.mu.model.Bid;
import edu.mu.model.Listing;
import edu.mu.model.User;

/**
 * Servlet implementation class CreateBidServlet
 */
public class CreateBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getBidList() == null) {
			user.setBidList(new ArrayList<Bid>());
		}

		String listingTitle = request.getParameter("listingTitle");
		int listingID = Integer.parseInt(request.getParameter("listingId"));
		float minimumBid = Float.parseFloat(request.getParameter("minimumBid"));
		float highestBid = Float.parseFloat(request.getParameter("highestBid"));
		float UserBid = Float.parseFloat(request.getParameter("userBid"));

		Listing listing = ListingsDao.getListingByID(listingID);

		if (UserBid > minimumBid && UserBid > highestBid){
			Bid bid = new Bid(user, UserBid, listing);
			user.getBidList().add(bid);
			request.setAttribute("listingTitle", listingTitle);
			request.getRequestDispatcher("placedBidSuccess.jsp").forward(request, response);
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
