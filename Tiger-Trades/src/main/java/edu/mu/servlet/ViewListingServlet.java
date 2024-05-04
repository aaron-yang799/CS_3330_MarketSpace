package edu.mu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.mu.dao.ListingsDao;
import edu.mu.model.Listing;
import edu.mu.model.User;

/**
 * Servlet implementation class ViewListingServlet
 */
public class ViewListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int listing_id = Integer.parseInt(request.getParameter("listingId"));
			Listing listing = ListingsDao.getListingByID(listing_id);
			
			if(Integer.parseInt(request.getParameter("listingTime")) <= 0) {
				ListingsDao.listingToOrder(listing);
				HttpSession session = request.getSession();
				session.setAttribute("listing", listing);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("auctionEnded.jsp");
				dispatcher.forward(request, response);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("listing", listing);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listingView.jsp");
			dispatcher.forward(request, response);
		    
		} catch (NumberFormatException e) {
		    // Handle the case where float parsing fails
		    e.printStackTrace();
		}        		
	}


}
