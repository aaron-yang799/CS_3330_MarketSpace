<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TigerTrades</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<style>
        /* Custom CSS for background image */
        .background-image {
            background-image: url('images/columns_background.jpg'); /* Path to your background image */
            background-size: cover;
            background-position: center center;
            height: 100vh; /* Set the height to cover the entire viewport */
        }
        
        #listing-container{
        	display: flex;
        	margin-top: 60px;
        	justify-content: center; 
        }
        
        #center-div{
        	width: 700px;
        }
        
        .information-container{
        	display: flex;
        	justify-content: space-between;
        }
        
        .listing-button:hover{
        	background-color: grey;
        }
        
        .listing-title {
        	display: block;
        }
        
        
        
        
    </style>
</head>
<body>
	<div class="background-image">
		<%@ include file="header.jsp" %>
	    <div id=listing-container>
	    	<div id="center-div">
	        	<c:if  test="${not empty sessionScope.otherListingsPrev}">
		        	<c:forEach var="listing" items="${sessionScope.otherListingsPrev}">
		            	<form action="ToListingServlet" method="post">
		            		<input type="hidden" name="listingId" value="${listing.listing_id}" />
		                	<button type="submit" class="listing-button d-block bg-white text-dark p-3 my-2 rounded-pill text-decoration-none vh-150 w-100">
			                	<div class="information-container">
				                	<div class="listing-title">
				                		<span class="h5">${listing.title}</span>
				                	</div>
				                	<div class="time-container">
				                	
				                	</div>
				                    <div class="listing-bid">
				                    	<fmt:formatNumber value="${listing.highest_bid}" type="currency" />
				                    </div>
				                </div>
			                </button>
		                </form>
		            </c:forEach>
		         </c:if>
			</div>
        </div>
	    <%@ include file="createListingButton.jsp" %>
    </div>
</body>
</html>