package edu.mu.servlet;

import java.io.IOException;

import edu.mu.dao.SignUpDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name").trim(); 
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String address = request.getParameter("address").trim();

        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            // Set an attribute indicating error
            request.setAttribute("error", "All fields must be filled out.");

            // Redirect back to the sign-up page with an error message
            RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
            rd.forward(request, response);
            return;
        }
		
		SignUpDao SignUp = new SignUpDao(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"), request.getParameter("address"));
		SignUp.SignUp();
		RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
		rd.forward(request, response);
	}

}
