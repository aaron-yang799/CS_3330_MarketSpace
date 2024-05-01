<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.background-image {
		background-image: url('images/columns_background.jpg'); /* Path to your background image */
		background-size: cover;
		background-position: center center;
		height: 100vh; /* Set the height to cover the entire viewport */
	}
</style>
</head>
<body>
	<div class="background-image">
		<%@ include file="header.jsp" %>
	    <div class="container-fluid">
		    <div class="row">
			    <div class="col-lg-6 offset-lg-3 text-center">
				    
			    </div>
		    </div>
	    </div>
	    <%@ include file="createListingButton.jsp" %>
    </div>
</body>
</html>