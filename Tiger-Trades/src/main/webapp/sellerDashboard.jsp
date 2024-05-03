<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body {
		overscroll-behavior: none;
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        background-attachment: fixed;
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
     
     .listing-title {
     	align-items: center;
        display: flex;
     }
     
     .days-left {
       	color: red;
     }
     
     .listing-button {
     	background-color: white;
     	display: block;
     	color: black;
     }
     
     .listing-button:hover {
     	background-color: #D3D3D3;
     }
        
</style>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<body>
	<div class="dopeassbg">
		<%@ include file="header.jsp" %>
	    <div id=listing-container>
	    	<div id="center-div">
	        	<c:if  test="${not empty sessionScope.userListing}">
		        	<c:forEach var="listing" items="${sessionScope.userListing}">
		            	<form action="EditListingServlet" method="post">
		            		<input type="hidden" name="listingId" value="${listing.listing_id}" />
		                	<button type="submit" class="listing-button p-3 my-2 rounded-pill vh-150 w-100">
			                	<div class="information-container">
				                	<div class="listing-title">
				                		<span class="h5">${listing.title}</span>
				                	</div>
				                	<div>
					                    <div class="listing-bid">
					                    	<span>Highest Bid: <fmt:formatNumber value="${listing.highest_bid}" type="currency" /></span>
					                    </div>
					                    <div class="time-container">
					                		<span class="days-left">${listing.timeUntilEnd} Days Remaining</span>
					                	</div>
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