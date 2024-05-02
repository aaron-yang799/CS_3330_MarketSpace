<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html public>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html ; charset=UTF-8">
<title>Insert title here</title>
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
        <div class='bg-white pl-3 pr-3 pt-3 pb-0 rounded w-25'>
            <h2>Sign-Up</h2>
            <form action="SignUpServlet" method="post" class="">
                <div class='mb-3'>
                    <label for="name"><strong>Name</strong></label>
                    <input type="text" placeholder='Enter Name' name='name' class='form-control rounded-0'/>
                </div>
                <div class='mb-3'>
                    <label for="email"><strong>Email</strong></label>
                    <input type="email" placeholder='Enter Email' name='email' class='form-control rounded-0'/>
                    <c:if test="${not empty emailError}">
	            		<p style="color: red;">❗ <c:out value="${emailError}"/></p>
    				</c:if>   
                </div>
                <div class='mb-3'>
                    <label for="password"><strong>Password</strong></label>
                    <input type="password" placeholder='Enter Password' name='password' class='form-control rounded-0'/>
                    <c:if test="${not empty passwordError}">
	            		<p style="color: red;">❗ <c:out value="${passwordError}"/></p>
    				</c:if> 
                </div>
                <div class='mb-3'>
                    <label for="address"><strong>Address</strong></label>
                    <input type="text" placeholder='Enter Address' name='address' class='form-control rounded-0'/>
                </div>
                <button type='submit' class='btn btn-success w-100'><strong>Create Account</strong></button>
                <p class='mb-1 mt-1'>You are agreeing to our terms and policies.</p>
                <span class="mt-1">Already a member? <a href='signIn.jsp'>Sign In</a></span>
                <c:if test="${not empty emptyFieldsError}">
	            	<p style="color: red;" class="mb-1">❗ <c:out value="${emptyFieldsError}"/></p>
    			</c:if>          
            </form>
        
    	</div>
    </div>
</body>
</html>