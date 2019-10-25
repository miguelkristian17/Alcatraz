<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/dashboard_style.css">
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
      			<h1 class="display-4">Welcome, <c:out value="${developer.name}"/>!</h1>
      			<h2 class="display-6">ID Number: <c:out value="${developer.devID}"/></h2>
      			<div class="project">
      				<c:forEach items="${projects}" var="project">
      				<h1 class="font-weight-light"><c:out value="${project.projectName}"/></h1>
	      			<div class="card" style="width: 18rem;">
	  					<div class="card-body">
	    					<h5 class="card-title">This projects user pools: </h5>
	  						<c:forEach items="${project.userpools}" var="pu">
	    					<p class="card-text"><a href="/up/${pu.id}"><c:out value="${pu.name}"/></a></p>
		  					</c:forEach>
	  					</div>
					</div>
					<br>
   					<a href="/newup" class="btn" role="button">Add User Pool</a>
   					</c:forEach>
      			</div>
      		</div>
    	</div>
	</div>
</body>
</html>