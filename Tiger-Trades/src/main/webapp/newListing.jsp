<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<style>

	body {
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
		background-size: cover;
		background-position: center center;
		background-attachment: fixed;
		width: 100%;
		height: 100vh; /* Set the height to cover the entire viewport */
	}
	
	html{
		overflow: hidden;
	}
	
	.popup {
		width: 40%;		
		border-radius: 15px;
	}

</style>
</head>
<body>
	<div>
		<%@ include file="header.jsp" %>
	    <div class="d-flex justify-content-center align-items-center vh-100 dopeassbg">
			<div class='bg-white p-3 popup'>
            	<div>
            	    <a id="cancel" class="btn rounded-pill btn-danger d-inline float-right" href="index.jsp">Cancel</a>
            		<h2>New Listing</h2>
            	</div>	
			    <form action="CreateListingServlet" method="post">
	                <div class='mb-3'>
	                    <label for="title"><strong>Title</strong></label>
	                    <input type="text" placeholder='Enter Title' name='email' class='form-control rounded-0'>
	                </div>
	                <div class='mb-3'>
    					<textarea name="description" style="resize: none;" maxlength="500" rows="8" class="form-control rounded"  placeholder="Enter Description Here..."></textarea>
	                </div>
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
	                <div class='mb-3'>
						<label for="buyOut"><strong>Buyout Price (USD)</strong></label>
	                	<input type="text" id="autoDecimal" name="buyOut" maxlength="10" class="form-control" placeholder="Enter Buyout Price">
	                </div>
	                <div class='mb-3'>
						<label for="dateEnd"><strong>Listing End Date</strong></label>
	                	<input type="text" id="datepicker" name="timeEnd" class="form-control" placeholder="Click to Enter Date">
	                </div>
	                <button type='submit' class='btn btn-success w-100'><strong>Create Listing!</strong></button>
			   	</form>
       		</div>
	    </div>
	</div>
	<script>
	    $(function() {
	        $("#datepicker").datepicker();
	    });
	</script>
</body>
</html>