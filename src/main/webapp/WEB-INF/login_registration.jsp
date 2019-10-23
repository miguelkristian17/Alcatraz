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
	<div id="wrapper" class="container">
		<div id="registration">
			<h1 class="display-4">Register</h1>
			<p><form:errors path="user.*"/></p>
			<div class="row">
				<div class="col-sm-9">
					<form:form action="/registration" method="post" modelAttribute="developer">
						<div class="form-group">
							 <form:label path="name">Name:</form:label>
	           				 <form:input path="name" class="form-control"/>
						</div>
						<div class="form-group">
							 <form:label path="email">Email:</form:label>
	           				 <form:input type="email" path="email" class="form-control"/>
						</div>
						<div class="form-group">
							<form:label path="password">Password:</form:label>
            				<form:password path="password" class="form-control"/>
						</div>
						<div class="form-group">
							<form:label path="passwordConfirmation">Password Confirmation:</form:label>
            				<form:password path="passwordConfirmation" class="form-control"/>
						</div>
						<input type="submit" value="Register!" class="btn btn-md btn-success"/>
					</form:form>
				</div>
			</div>
		</div>
		<div id="login">
			<h1 class="display-4">Login</h1>
			<p><c:out value="${error}"/></p>
			<div class="row">
				<div class="col-sm-9">
					<form action="/login" method="post">
						<div class="form-group">
							<label for="email">Email: </label>
            				<input type="text" id="email" name="email" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="password">Password: </label>
            				<input type="password" id="password" name="password" class="form-control"/>
						</div>
						<input type="submit" value="Login!" class="btn btn-md btn-danger"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>