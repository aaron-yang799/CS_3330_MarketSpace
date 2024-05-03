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
import edu.mu.model.ListingPreview;
import edu.mu.model.User;

/**
 * Servlet implementation class sellerDashBoardServlet
 */
public class sellerDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(null == session.getAttribute("userListing")) {
	        Object userObj = session.getAttribute("user");
	        User user = (User)userObj;
	        
	        ArrayList<ListingPreview> userListing = ListingsDao.getUserListings(user);
	        session.setAttribute("userListing", userListing);
		}
		request.getRequestDispatcher("sellerDashboard.jsp").forward(request, response);	
	}
}