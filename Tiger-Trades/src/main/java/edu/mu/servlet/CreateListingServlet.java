package edu.mu.servlet;

import edu.mu.dao.CreateListingDao;
import edu.mu.dao.ListingsDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
		    String timeEndString = request.getParameter("timeEnd").replace("/", "-");
		    		
		    DateTimeFormatter format0 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		    LocalDate tempDate = LocalDate.parse(timeEndString, format0);
	        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = tempDate.format(format1);


		    // Date parsing to process date into database
	        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate =  LocalDate.parse(formattedDate, format2);
	        java.sql.Date timeEnd = java.sql.Date.valueOf(localDate);
		    
            
		    System.out.println(timeEnd);

		    
		    if (title.isEmpty() || description.isEmpty() || buyOutString.isEmpty() || timeEndString.isEmpty()) {
	            request.setAttribute("error", "All fields must be filled out.");
	            // Redirect back to the sign-up page with an error message
	            RequestDispatcher rd = request.getRequestDispatcher("newListing.jsp");
	            rd.forward(request, response);
	            return;
	        }
		    
		    ListingsDao.CreateListing(title, description, buyOut, timeEnd);
		    
		    // TODO CREATE A LISTING CREATED POPUP
		    RequestDispatcher rd = request.getRequestDispatcher("listingCreated.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
		    // Handle the case where float parsing fails
		    e.printStackTrace();
		}        		
	}

}
