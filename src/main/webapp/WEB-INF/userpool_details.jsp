<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Pool Details</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/userpool_details_style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light static-top mb-5 shadow" id="top">
  		<div class="container">
    		<a class="navbar-brand" href="/dashboard">Alcatraz</a>
    		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          		<span class="navbar-toggler-icon"></span>
        	</button>
    		<div class="collapse navbar-collapse" id="navbarResponsive">
      			<ul class="navbar-nav ml-auto">
        			<li class="nav-item active">
          				<a class="nav-link" href="/dashboard">Home</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/about">About</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/newproj">New Project</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/newup">New User Pool</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/home">Logout</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
  		<div class="card border-0 shadow my-5" id="overlay">
    		<div class="card-body p-5">
      			<h1 class="display-4">User Pool: <c:out value="${userpool.name}"/></h1>
      			<h2 class="display-6">User Pool ID: <c:out value="${userpool.id}"/></h2>
      			<div class="row">
					<div class="col-sm-9">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">User Name</th>
									<th scope="col">User Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userpool.users}" var="user">
									<tr>
										<td><c:out value="${user.name}"/></td>
										<td><c:out value="${user.email}"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
      		<div style="height: auto;"></div>
    	</div>
  		</div>
	</div>
</body>
</html>