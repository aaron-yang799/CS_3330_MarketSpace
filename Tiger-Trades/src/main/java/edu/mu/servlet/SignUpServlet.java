package edu.mu.servlet;

import java.io.IOException;
import java.util.ArrayList;

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

        boolean emailChecker = emailCheck(email);
        boolean passChecker = passwordCheck(password);
        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            // Set an attribute indicating error
            request.setAttribute("emptyFieldsError", "All fields must be filled out.");

            // Redirect back to the sign-up page with an error message
            RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
            rd.forward(request, response);
            return;
        }else if (!(emailChecker && passChecker)) {
        	if(!emailChecker) {
        		String emailError = "Email does not match domain requirements.";
        		request.setAttribute("emailError", emailError);
        	}
        	if(!passChecker) {
        		String passwordError = "Password must contain: 8 characters, 1 digit, 1 uppercase letter, 1 lowercase letter, and 1 special character";
        		request.setAttribute("passwordError", passwordError);
        	}
        	request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }
		
		SignUpDao SignUp = new SignUpDao(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"), request.getParameter("address"));
		SignUp.SignUp();
		RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
		rd.forward(request, response);
	}
	
	private boolean emailCheck(String email) {
		String regex = ".+@missouri.edu$";
		String regex2 = ".+@umsystem.edu$";
		return email.matches(regex) || email.matches(regex2);
	}
	
	private boolean passwordCheck(String password) {
		 boolean hasUpperCase = password.matches(".*[A-Z].*");
	     boolean hasLowerCase = password.matches(".*[a-z].*");
	     boolean hasDigit = password.matches(".*[0-9].*");
	     boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");
	     boolean isAtLeast8Chars = password.length() >= 8;
	     return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && isAtLeast8Chars;
	}

}