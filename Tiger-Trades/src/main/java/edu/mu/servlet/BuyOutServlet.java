package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import edu.mu.dao.ListingsDao;
import edu.mu.model.Listing;
import edu.mu.model.ListingPreview;
import edu.mu.model.User;

/**
 * Servlet implementation class BuyOutServlet
 */
public class BuyOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");
        User user = (User) userObj;
        
        int listingID = Integer.parseInt(request.getParameter("ListingID"));
		Listing listing = ListingsDao.getListingByID(listingID);
		if(listing == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		float buyout = listing.getBuyOutPrice();
		
		if (user.getWallet() < buyout) {
			String brokeAhhUserBuyOutError = "You don't have enough money in your wallet to buy this.";
			request.setAttribute("brokeAhhUserBuyOutError", brokeAhhUserBuyOutError);
			request.getRequestDispatcher("listingView.jsp").forward(request, response);
		}
		

		        
        ListingsDao.listingToOrderBuyOut(listingID, user.getUserid(), buyout);
        ArrayList<ListingPreview> ListingPreview = (ArrayList<ListingPreview>) session.getAttribute("otherListingsPrev");

        session.setAttribute("boughtOutItemTitle", listing.getTitle());
        
        Iterator<ListingPreview> iterator = ListingPreview.iterator();
        
        while (iterator.hasNext()) {
            ListingPreview listingPrev = iterator.next();
            if (listingPrev.getListing_id() == listingID) {
                iterator.remove();
            }
        }
		request.setAttribute("boughtOut", "Created!");
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

}
