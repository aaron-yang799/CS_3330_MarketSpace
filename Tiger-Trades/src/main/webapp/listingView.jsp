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
		    height: 100vh;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    flex-direction: column;
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
	    	<div id = "listing-container">
	    		
	    	
	    	</div>
	    <%@ include file="createListingButton.jsp" %>
    </div>
</body>
</html>