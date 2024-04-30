<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
	.dopeassbg {
		background-image: url('images/011922JesseHall1.png'); /* Path to your background image */
        background-size: cover;
        background-position: center center;
	}
</style>
</head>
<body>
	<div class='d-flex justify-content-center align-items-center vh-100 dopeassbg'>
        <div class='bg-white p-3 rounded w-25'>
            <h2>Log-In</h2>
            <form action="">
                <div class='mb-3'>
                    <label for="email"><strong>Email</strong></label>
                    <input type="email" placeholder='Enter Email' name='email' class='form-control rounded-0'>
                </div>
                <div class='mb-3'>
                    <label for="password"><strong>Password</strong></label>
                    <input type="password" placeholder='Enter Password' name='password' class='form-control rounded-0'/>
                </div>
                <button type='submit' class='btn btn-success w-100'><strong>Log In</strong></button>
                <p class='mb-1 mt-1'>You are agreeing to our terms and policies.</p>
                <a href='signUp.jsp'>Create Account</a>
            </form>
        </div>
    </div>
</body>
</html>