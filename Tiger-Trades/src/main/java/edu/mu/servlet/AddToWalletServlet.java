package edu.mu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.mu.dao.UserDao;
import edu.mu.model.User;

/**
 * Servlet implementation class AddCurrency
 */
public class AddToWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userID"));
		float amount = Float.parseFloat(request.getParameter("addAmount"));
		float wallet = Float.parseFloat(request.getParameter("wallet"));
		
		if(amount <= 0) {
			String negativeWalletAddError = "You must add at least .01 Tiger Tokens to your account.";
			request.setAttribute("negativeWalletAddError", negativeWalletAddError);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		UserDao.addToWallet(userId, amount);
		HttpSession session = request.getSession();
		Object userObj = session.getAttribute("user");
		User user = (User) userObj;
		user.setWallet(wallet + amount);
		request.setAttribute("balance", user.getWallet());
		request.setAttribute("balanceUpdated", "Updated!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
