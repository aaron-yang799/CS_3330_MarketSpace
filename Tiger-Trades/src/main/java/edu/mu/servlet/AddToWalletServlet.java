package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import edu.mu.dao.UserDao;

/**
 * Servlet implementation class AddCurrency
 */
public class AddToWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userID"));
		float amount = Float.parseFloat(request.getParameter("addAmount"));
		
		if(amount <= 0) {
			String negativeWalletAddError = "You cannot add a negative amount to your wallet";
			request.setAttribute("negativeWalletAddError", negativeWalletAddError);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		UserDao.addToWallet(userId, amount);
		request.setAttribute("balance", amount);
		request.setAttribute("balanceUpdated", "Updated!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
