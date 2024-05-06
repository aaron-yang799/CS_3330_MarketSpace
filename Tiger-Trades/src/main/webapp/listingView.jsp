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
		    min-height: 100vh;
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
		
		.input-group {
            display: flex;
        }
        .input-group input {
            flex-grow: 1;
            margin-right: 5px;
        }
        
        
    </style>
    <script>
	    document.addEventListener('DOMContentLoaded', function() {
	        const inputField = document.getElementById('autoDecimal');
	
	        inputField.addEventListener('input', function(e) {
	            let input = e.target.value.replace(/[^0-9]/g, ''); // Strip out non-numeric characters
	            if (input.length === 0) {
	                e.target.value = ''; // If no digits, leave empty
	            } else if (input.length === 1) {
	                e.target.value = '0.0' + input; // For single digit, prefix with 0.0
	            } else if (input.length === 2) {
	                e.target.value = '0.' + input; // For two digits, prefix with 0.
	            } else {
	                let integerPart = input.slice(0, -2);  // Extract all digits except the last two
	                let decimalPart = input.slice(-2); // Last two digits
	                e.target.value = parseInt(integerPart) + '.' + decimalPart; // Combine with a decimal point, removing any leading zeros
	            }
	        });
	    }); 
	</script>
</head>
<body>
    <div class="background-image">
        <%@ include file="header.jsp" %>
        <div class='d-flex justify-content-center align-items-center'>
            <div class='container-details'>
            	<div>
            	    <a id="close" class="btn rounded-pill btn-danger d-inline float-right" href="index.jsp">Close</a>
            		<h2>${sessionScope.listing.title}</h2>
            	</div>
			    <div class="row">
			        <div class="col">
			            <p><strong>Description:</strong> ${sessionScope.listing.description}</p>
			            <p><strong>Posted:</strong> <fmt:formatDate value="${sessionScope.listing.timePosted}" pattern="MMMM-dd-yyyy"/></p>
			            <p><strong>Ends:</strong> <fmt:formatDate value="${sessionScope.listing.timeEnd}" pattern="MMMM-dd-yyyy"/></p>
			            <p><strong>Minimum Bid:</strong> $<fmt:formatNumber value="${sessionScope.listing.minimumBid}"/></p>
			            <p><strong>Highest Bid:</strong> $<span id="highestBid"></span></p>
			        </div>
			        <div class="col">
			            <label for="userBid"><strong>Submit a Bid (USD)</strong></label>
			            <form action="CreateBidServlet" method="post">
				            <input type="hidden" name="listingId" value="${sessionScope.listing.listing_id}"/>
				            <input type="hidden" name="minimumBid" value="${sessionScope.listing.minimumBid}"/>
				            <input type="hidden" name="highestBid" value="${sessionScope.listing.highestBid}"/>
				            <input type="hidden" name="listingTitle" value="${sessionScope.listing.title}"/>
				            <div class="input-group">
									<input id="autoDecimal" name="userBid" maxlength="20" class="form-control" max="9999999999999" placeholder="Bid amount">
									<button type="submit" class = 'btn btn-success'>Submit</button>
							</div>
						</form>
				        <c:if test="${not empty underAllError}">
		            		<p style="color: red; margin-bottom: 0px;"><c:out value="${underAllError}"/></p>
	    				</c:if>
	    				<c:if test="${not empty underHighBidError}">
		            		<p style="color: red; margin-bottom: 0px;"><c:out value="${underHighBidError}"/></p>
	    				</c:if>
	    				<c:if test="${not empty underMinBidError}">
		            		<p style="color: red; margin-bottom: 0px;"><c:out value="${underMinBidError}"/></p>
	    				</c:if>
	    				<label for="userBid"><strong>or</strong></label>
	    				<button type='submit' class='btn btn-success w-100'><strong>Buy now for $${sessionScope.listing.buyOutPrice}</strong></button>
			        </div>
			    </div>
			</div>
        </div>
        <%@ include file="createListingButton.jsp" %>
    </div>
</body>
<script>
    var highestBid = ${sessionScope.listing.highestBid};
    var formattedBid = highestBid.toFixed(2);
    document.getElementById("highestBid").textContent = formattedBid;
</script>
</html>