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
        .background-image {
		    background-image: url('images/011922JesseHall1.png');
		    background-size: cover;
		    background-position: center center;
		    min-height: 100vh; /* Ensure it covers at least the full height but can extend with content */
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    flex-direction: column;
		}

		.container-details {
		    background-color: #fff;
		    padding: 20px;
		    border-radius: 8px;
		    width: 600px;
		}
        
        .container-details h2 {
    		padding-bottom: 10px;
		}
        
        #listing-container {
		    width: 700px;[]
		    background-color: #fff;
		    padding: 20px;
		    border-radius: 8px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		}
		
		
    </style>
</head>
<body>
    <div class="background-image">
        <%@ include file="header.jsp" %>
        <div class='d-flex justify-content-center align-items-center'>
            <div class='container-details'>
			    <h2>${sessionScope.listing.title}</h2>
			    <div class="row">
			        <div class="col">
			            <!-- Left column content -->
			            <p><strong>Description:</strong> ${sessionScope.listing.description}</p>
			            <p><strong>Posted:</strong> <fmt:formatDate value="${sessionScope.listing.timePosted}" pattern="MMMM-dd-yyyy"/></p>
			            <p><strong>Ends:</strong> <fmt:formatDate value="${sessionScope.listing.timeEnd}" pattern="MMMM-dd-yyyy"/></p>
			            <p><strong>Minimum Bid:</strong> $<fmt:formatNumber value="${sessionScope.listing.minimumBid}"/></p>
			            <p><strong>Buyout Price:</strong> $<fmt:formatNumber value="${sessionScope.listing.buyOutPrice}"/></p>
			        </div>
			        <div class="col">
			            <!-- Right column content -->
			            
			        </div>
			    </div>
			</div>
        </div>
        <%@ include file="createListingButton.jsp" %>
    </div>
</body>

</html>