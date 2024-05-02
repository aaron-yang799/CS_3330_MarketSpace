


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="edu.mu.model.Bid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bids</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container">
        <h1>Bids</h1>
        	<c:choose>
        		<c:when  test="${not empty sessionScope.user.getBidList()}">
        			<c:forEach  var="bid" items="${sessionScope.user.BidListsgetBidList()}">
	        			<div class="card mb-3">
	                        <div class="card-body">
	                            <h5 class="card-title">${bid.listing.title}</h5>
	                            <p class="card-text">Bid Amount: ${bid.amountBidded}</p>
	                        </div>
	                    </div>
        			</c:forEach>
        		</c:when>
        		<c:otherwise>
        			<p>No bids to display.</p>
        		</c:otherwise>
        	</c:choose>
    </div>
</body>
</html>