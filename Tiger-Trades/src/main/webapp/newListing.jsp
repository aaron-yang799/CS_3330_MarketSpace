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
	                <div class='mb-3'>
						<label for="dateEnd"><strong>Listing End Date</strong></label>
	                	<input type="text" id="datepicker" name="dateEnd" class="form-control" placeholder="Click to Enter Date">
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