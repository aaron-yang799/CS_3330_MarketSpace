package edu.mu.servlet;

import java.io.IOException;

import edu.mu.dao.SignInDao;
import edu.mu.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SignInDao Authenticate = new SignInDao(request.getParameter("email"), request.getParameter("password"));
		User user = Authenticate.Authenticate();
	
		if (user != null) {
	        // User is found and password is correct
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);  // Store user object in session
	        
	        //session.setAttribute("userName", user.getUsername()); 

	        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
	    } else {
	        // Authentication failed
	        request.setAttribute("error", "Invalid username or password");
	        request.getRequestDispatcher("signIn.jsp").forward(request, response);
	    }
	}

}
