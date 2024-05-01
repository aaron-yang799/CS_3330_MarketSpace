package edu.mu.servlet;

import edu.mu.dao.CreateListingDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class CreateListingServlet
 */
public class CreateListingServlet extends HttpServlet {
	private static final long serialVersionUID = -164543475414125794L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    String title = request.getParameter("title");
		    String description = request.getParameter("description");
		    float buyOut = Float.parseFloat(request.getParameter("buyOut"));
		    
		    // String request to test for empty
		    String buyOutString = request.getParameter("buyOut");
		    String timeEndString = request.getParameter("timeEnd");
		    
		    // Date parsing to process date into database
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust date format as needed
		    java.util.Date parsedDate = dateFormat.parse(request.getParameter("timeEnd"));
		    java.sql.Date timeEnd = new java.sql.Date(parsedDate.getTime());
		    
		    if (title.isEmpty() || description.isEmpty() || buyOutString.isEmpty() || timeEndString.isEmpty()) {
	            request.setAttribute("error", "All fields must be filled out.");
	            // Redirect back to the sign-up page with an error message
	            RequestDispatcher rd = request.getRequestDispatcher("newListing.jsp");
	            rd.forward(request, response);
	            return;
	        }
		    
		    CreateListingDao createListing = new CreateListingDao(title, description, buyOut, timeEnd);
		    createListing.CreateListing();
		    
		    // TODO CREATE A LISTING CREATED POPUP
		    RequestDispatcher rd = request.getRequestDispatcher("listingCreated.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
		    // Handle the case where float parsing fails
		    e.printStackTrace();
		} catch (ParseException e) {
		    // Handle the case where date parsing fails
		    e.printStackTrace();
		}        		
	}
}
