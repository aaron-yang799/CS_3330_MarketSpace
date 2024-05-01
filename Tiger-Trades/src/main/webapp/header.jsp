<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
 <style>
 	.custom-header {
    	background-color: #000;
       	color: #FFD700; /* Mustard yellow */
       padding: 10px;
       position: fixed;
       width: 100%;
       top: 0;
       left: 0;
	}
	.title-container, .link-container {
		display: flex;
		align-items: center;
	}
	.title {
		font-size: 24px; /* Medium size */
		margin: 0;
	}
	.title {
		color: #FFD700;
	}
	.link-container {
		display: flex;
		justify-content: space-evenly;        	
	}
	.link-container a {
		color: #FFD700; /* Mustard yellow */
		text-decoration: none; /* Remove default underline */
		margin-left: 20px; /* Add some spacing between links */
	}
	
	.header-row {
		background-color: black;
		
	}
	 
 </style>
</head>
<body>
<div class="container-fluid header-shell">
    <div class="row header-row">
        <div class="col">
            <div class="custom-header">
                <div class="row w-100">
                    <div class="col-6 title-container">
                        <div class="title">
                            TigerTrades
                        </div>
                    </div>
                    <div class="col-6 link-container text-right">
                        <a href="#">Listings</a>
                        <a href="#">User</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>