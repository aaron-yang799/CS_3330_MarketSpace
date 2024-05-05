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
</head>
<body>
    <%@ include file="header.jsp" %>
    <div id="listing-container">
        <div id="center-div">
            <br>
            <c:if  test="${not empty sessionScope.user.getBidList()}">
                <c:forEach  var="bid" items="${sessionScope.user.getBidList()}">
                    <form action="EditBidServlet" method="post">
                        <input type="hidden" name="bidId" value="${bid.id}" />
                        <button type="submit" class="listing-button p-3 my-2 rounded-pill vh-150 w-100">
                            <div class="information-container">
                                <div class="listing-title">
                                    <span class="h5">${bid.listing.title}</span>
                                </div>
                                <div>
                                    <div class="listing-bid">
                                        <span>Bid Amount: <fmt:formatNumber value="${bid.amountBidded}" type="currency" /></span>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>