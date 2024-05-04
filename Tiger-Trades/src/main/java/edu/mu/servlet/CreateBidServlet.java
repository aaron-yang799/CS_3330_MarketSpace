package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import edu.mu.dao.ListingsDao;

/**
 * Servlet implementation class CreateBidServlet
 */
public class CreateBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listingID = Integer.parseInt(request.getParameter("listingId"));
		float ListingBid = Float.parseFloat(request.getParameter("listingBid"));
		float UserBid = Float.parseFloat(request.getParameter("userBid"));
		
		if (UserBid > ListingBid){
			ListingsDao.createBid(listingID, UserBid);
			//TODO MAKE A BID CREATED POPUP
			request.getRequestDispatcher("listingView.jsp").forward(request, response);
		}
		String lowBidError = "Your bid must be higher than the minimum bid.";
		request.setAttribute("lowBidError", lowBidError);
		request.getRequestDispatcher("listingView.jsp").forward(request, response);

	}
}
