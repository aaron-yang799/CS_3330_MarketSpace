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
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
	body {
		overscroll-behavior: none;		
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
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
		display: flex;
		align-items: center;
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
</head>
<body>
	<%@ include file="listingCreated.jsp" %>
	<div class="background-image">
		<%@ include file="header.jsp" %>
	    <div id=listing-container>
	    	<div id="center-div">
	    	<br>
	        	<c:if test="${not empty sessionScope.otherListingsPrev}">
		        	<c:forEach var="listing" items="${sessionScope.otherListingsPrev}">
		            	<form action="ViewListingServlet" method="post">
		            		<input type="hidden" name="listingId" value="${listing.listing_id}"/>
		            		<input type="hidden" name="listingTime" value="${listing.timeUntilEnd}"/>
		                	<button type="submit" class="listing-button p-3 my-2 rounded-pill text-decoration-none vh-150 w-100">
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
    <script>
    $(document).ready(function() {
        <c:if test="${not empty listingCreated}">
            $("#myModal").modal('show');
        </c:if>
    });
	</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>