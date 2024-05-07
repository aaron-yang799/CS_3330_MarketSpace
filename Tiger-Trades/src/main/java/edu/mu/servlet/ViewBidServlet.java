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
import edu.mu.model.User;
import edu.mu.model.Bid;

/**
 * Servlet implementation class ViewBidServlet
 */
public class ViewBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
                Object temp = session.getAttribute("user");
                User user = (User) temp;
                System.out.println("TESTTTTT");
//                if(session.getAttribute("BidList") != null)
//                {
//                	System.out.println("TESTTTTT");
//                	ArrayList<Bid> bidy = (ArrayList<Bid>) session.getAttribute("BidList");
//                	bidy.clear();
//                	
//                }
                session.setAttribute("BidList", ListingsDao.getUserBids(user));
                //System.out.println("Printing Bid List" + session.getAttribute("BidList"));
                request.getRequestDispatcher("bids.jsp").forward(request, response);	}

}
