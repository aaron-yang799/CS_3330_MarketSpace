<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.mu.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    .custom-header {
        background-color: #000;
        color: #FFD700; /* Mustard yellow */
        padding: 10px;
        position: fixed;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 1000;
    }
    .title-container {
        display: flex;
        align-items: center;
    }
    .title {
        font-size: 24px; /* Medium size */
        margin: 0;
        font-family: 'Graphik';
        color: #FFD700;
        background-color: Black;
    }
    .link-container {
        display: flex; 
    }
    .link-container a {
        color: #FFD700; /* Mustard yellow */
        text-decoration: none; /* Remove default underline */
        margin-left: 0px; /* Add some spacing between links */
    }
    .header-row {
        background-color: black;
    }
    /* Dropdown CSS */
    .dropdown {
        position: relative;
        display: inline-block;
        margin-right: 15px;
    }
    .dropdown-content-item {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        font-size: 13px;
        min-width: 130px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 10;
        text-align: left; /* Aligns text to the left */
    	white-space: nowrap;
    	
    	
    }
    .dropdown-content-item a {
        color: black;
        padding: 10px 13px;
        text-decoration: none;
        display: block;
    }
    button {
    	color: #FFD700;
    	background-color: black;
    	padding: 0;
    	border: none;
    }
	
	.indexLink {
		color: #FFD700;
	}
	
	.indexLink:hover {
		  filter: brightness(75%);
		  color: #FFD700;
		  text-decoration: none; 
		
	}
	
	.loginLink, .signUpLink:hover {
		text-decoration: none;
	}
	
    .dropdown-content-item a:hover {background-color: #f1f1f1}
    .dropdown:hover .dropdown-content-item {display: block;}
    .dropbtn:hover {background-color: #3e8e41;}
</style>
</head>
<body>
<div class="container-fluid header-shell">
    <div class="row header-row">
        <div class="col">
            <div class="custom-header">
                <div class="row w-100">
                	<%
                    	String pathInfo = request.getServletPath(); 
                		String thisPage;
                		switch(pathInfo){
                			case "/index.jsp":
                				thisPage = "Listings";
                				break;
                			case "/newListing.jsp":
                				thisPage = "New Listing";
                				break;
                			case "/sellerDashboard.jsp":
                				thisPage = "Your Listings";
                				break;
                			case "wallet.jsp":
                				thisPage = "Your Wallet";
                			default:
                				thisPage = null;
                				break;	
                		}
					%>
                    <div class="col-4 title-container">
                        <div class="title">
                            <a href="index.jsp" id="TigerTradesIcon" class="indexLink">TigerTrades&nbsp;</a>
                            <a href="https://github.com/aaron-yang799/CS_3330_MarketSpace"><img src="images/github-white.png" alt="github" height="32px" width="32px" class="mb-1"></a>
                        </div>
                    </div>
                    <div class="col-4 d-flex justify-content-center align-items-center h5" style="font-family: 'Graphik';">
                    	<p class = "mb-0"><%= thisPage != null ? thisPage : "" %></p>
                    </div>
                    <div class="col-4 link-container justify-content-end">
                        <% 
                            Object userObj = session.getAttribute("user");
                            User user = (User) userObj; // Cast it to the User class
                            if (user != null && user.getUsername() != null) {
                        %>
                            <div class="dropdown float-right">
                                <button class="mt-2"> Hey, <%= user.getUsername() %>!</button>
                                <div class="dropdown-content-item">
                                	<a href="wallet.jsp">My Wallet</a>
                                    <a href="ViewBidServlet">Bids</a>
                                    <a href="sellerDashBoardServlet">Seller Dashboard</a>
                                    <a href="LogOutServlet">Logout</a>
                                </div>
                            </div>
                        <% } else { %>
                            <a href="signIn.jsp">Login</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="signUp.jsp">Register</a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
