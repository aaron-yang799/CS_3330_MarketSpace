package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.mu.dao.ListingsDao;
import edu.mu.model.User;

/**
 * Servlet implementation class ViewBidServlet
 */
public class ViewBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Object temp = session.getAttribute("user");
        User user = (User) temp;
        
        session.setAttribute("BidList", ListingsDao.getUserBids(user));

        request.getRequestDispatcher("bids.jsp").forward(request, response);	}

}
