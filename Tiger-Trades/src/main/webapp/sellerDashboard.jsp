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
	.dopeassbg {
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
        background-size: cover;
        background-position: center center;
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
        display: block;
     }
        
</style>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<body>
	<%@ include file="header.jsp" %>
	<div class='d-flex justify-content-center vh-100 dopeassbg'>
		<div id=listing-container>
	    	<div id="center-div">
				<c:forEach var="listing" items="${sessionScope.userListing}">
					<form action="ViewListingServlet" method="post">
				    	<input type="hidden" name="listingId" value="${listing.listing_id}" />
				        <button type="submit" class="listing-button d-block bg-white text-dark p-3 my-2 rounded-pill text-decoration-none vh-150 w-100">
						    <div class="information-container">
							 	<div class="listing-title">
							    	<span class="h5">${listing.title}</span>
							     </div>
							     <div class="time-container">
							     	<div class="time-container">
                                     	<span class="days-left">${listing.timeUntilEnd} Days Remaining</span>
                                     </div>           	
							     </div>
							     <div class="listing-bid">
							     	<fmt:formatNumber value="${listing.highest_bid}" type="currency" />
							     </div>
							</div>
						</button>
					</form>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>