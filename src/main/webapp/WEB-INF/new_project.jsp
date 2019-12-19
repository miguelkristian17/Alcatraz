<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Project Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/new_project_style.css">
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
        			<li class="nav-item ">
          				<a class="nav-link" href="/dashboard">Home</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/about">About</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link disabled" href="/docs">Docs</a>
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
    		    <div style = "display: flex; justify-content: center; flex-wrap: wrap;">
      			<h1 class="display-4" style = "color: #D1D1D1; font-weight: 400;">Create a New Project</h1> <br>
      			<h4 style = "color: #D1D1D1;  font-weight: 450; display: flex; flex-direction: row; justify-self: center;'"> Add your existing project/website to your profile to keep track of its user pools!</h4>
      			</div>      			
      			  <hr class="my-4">
      			<div class="row" style = "display: flex; justify-content: center;">
					<div class="col-sm-9">
						<form:form action="/projects" method="post" modelAttribute="projects">
							<div class="form-group">
								<form:label style = "color: #D1D1D1; font-size: 24px;"  path="projectName">Project Name</form:label>
						        <form:errors path="projectName"/>
						        <form:input path="projectName" class="form-control" id="project_name" placeholder="Project Name"/>
							</div>
							<div class="form-group">
								<form:label style = "color: #D1D1D1; font-size: 24px;"  path="description">Project Description</form:label>
						        <form:errors path="description"/>
						        <form:input path="description" class="form-control" id="project_description" placeholder="Project Description"/>
    						</div>
    						<hr class="my-4">
							<input style = "margin-top: 30px;" type="submit" value="Create Project!" class="btn btn-lg" id="btn-1"/>
						</form:form>
						<br>
					</div>
				</div>
      		<div style="height: auto;"></div>
    	</div>
  		</div>
	</div>
</body>
</html>