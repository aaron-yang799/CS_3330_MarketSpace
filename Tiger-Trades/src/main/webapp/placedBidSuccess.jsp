<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="modal" tabindex="-1" role="dialog" id="myModal">
  		<div class="modal-dialog modal-dialog-centered  align-items-center d-flex" role="document">
    		<div class="modal-content ">
      			<div class="modal-header">
        			<h5 class="modal-title">You have successfully placed a bid!</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
        			<p>You have successfully placed a bid on ${listingTitle}!</p>
      			</div>
				<div class="modal-footer">
    				<a href="bids.jsp" class="btn btn-success">View current bids</a>
        			<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
   				</div>
			</div>
  		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>