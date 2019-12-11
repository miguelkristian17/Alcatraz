<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login/Registration Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/login_registration_style.css">
</head>
<body>
	<div id="container" class="container">
		<div class="form-container sign-up-container">
			<form:form action="/registration" method="post" modelAttribute="developer">
				<h1>Create Account</h1>
				
         		<form:input path="name" class="form-control" placeholder="Name"/>
			
			
         		<form:input type="email" path="email" class="form-control" placeholder="Email"/>
			
			
       			<form:password path="password" class="form-control" placeholder="Password"/>
			
			
         		<form:password path="passwordConfirmation" class="form-control" placeholder="Confirm Password"/>
				
				<button>Register!</button>
			</form:form>
		</div>
		<div class="form-container sign-in-container">
			<form action="/login" method="post">
				<h1>Sign In</h1>
				<p><c:out value="${error}"/></p>
				
         		<input type="text" id="email" name="email" class="form-control" placeholder="Email"/>
         		
         		<input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
				
				<button>Sign In!</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>Please sign in with your login information.</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello!</h1>
					<p>Enter your details and start your journey with us!</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/login_registration.js"></script>
</body>
</html>