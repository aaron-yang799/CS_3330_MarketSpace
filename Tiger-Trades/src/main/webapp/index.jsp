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
    </style>
</head>
<body>
	<div class="background-image">
		<%@ include file="header.jsp" %>
	    <div id=listing-container>
	    	<div id="center-div">
	        	<c:if  test="${not empty sessionScope.otherListingsPrev}">
		        	<c:forEach var="listing" items="${sessionScope.otherListingsPrev}">
		            	<a href="#" class="d-block bg-white text-dark p-3 my-2 rounded-pill text-decoration-none vh-150">
		                	<span class="h5">${listing.title}</span>
		                    <fmt:formatNumber value="${listing.highest_bid}" type="currency" />
		                </a>
		            </c:forEach>
		         </c:if>
			</div>
        </div>
	    <%@ include file="createListingButton.jsp" %>
    </div>
</body>
</html>