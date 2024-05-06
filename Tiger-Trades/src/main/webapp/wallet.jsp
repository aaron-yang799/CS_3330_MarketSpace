<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<title>Insert title here</title>
<style>
	body {
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
		background-size: cover;
		background-position: center center;
		background-attachment: fixed;
		width: 100%;
		height: 75%; /* Set the height to cover the entire viewport */
		overscroll-behavior: none;		
	}
	
	.popup {
		width: 40%;		
		border-radius: 15px;
	}
	
	.header-title {
        border-bottom: 1px solid black; /* Adjust color and thickness as needed */
    }
	
	.form-group {
    	display: grid; /* Establishes a grid container */
    	grid-template-columns: auto 1fr auto; /* Defines two columns: one for the label and one for the input */
    	align-items: center; /* Centers items vertically */
    	gap: 5px; /* Optional: sets the gap between label and input */
	}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="d-flex justify-content-center align-items-center vh-100 dopeassbg">
		<div class="bg-white popup">
			<div class="header-title mb-1">
				<h2 class="pt-3 pl-3 pr-3">My Wallet</h2>
			</div>
			<div class="row">
				<div class="col">
					<div class="mb-3 pt-3 pl-3 pr-3 pb-1">
						<h5><strong>Amount</strong></h5>
						<p>&nbsp;&nbsp;💲${sessionScope.user.getWallet()}</p>
					</div>
				</div>
				<div class="col	mr-3 pt-3 pl-3 pr-3pb-1">
					<form action="AddToWalletServlet" method="post">
						<input type="hidden" name="userID" value="${sessionScope.user.getUserid()}"/>
						<h5><strong>Add TigerTokens to Wallet</strong></h5>
						<div class="form-group">
							<label for="addAmount">💲</label>
							<input type="text" class="form-control"  name="addAmount" id="autoDecimal" placeholder="Enter Amount">
							<button type="submit" class="btn btn-success">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
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
</html>