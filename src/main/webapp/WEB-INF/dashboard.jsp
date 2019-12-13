<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/dashboard_style.css">
<script src="https://kit.fontawesome.com/3a27d2b396.js" crossorigin="anonymous"></script>
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
         			<li class="nav-item disabled">
          				<a class="nav-link" href="/docs">Docs</a>
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
	<div class="card border-0 shadow my-5" id="overlays">
          <div class="row" style = "display:flex; flex-direction:row; justify-content: space-between;">   
            <h1 class="navbar-brand" >Welcome, <c:out value="${developer.name}"/>!</h1>            
            <a href="/newproj" style = "height: 50px;"class="btn btn-lg" id="btn-1"><i class="fas fa-download fa-sm text-white-50"></i> Add project</a> 
          </div>
     <h2 class="display-6">Developer ID: <c:out value="${developer.devID}"/></h2>
     </div>  
     <c:choose>
    <c:when test="${fn:length(projects) gt 0}">
	   <c:forEach items="${projects}" var="project">
	   	<div class="card border-0 shadow my-5" id="overlay">
           <div class="row">          
              <div class="card shadow mb-4" style = "width: 508px; margin-left: 17px;margin-right: 17px;">
                  <div class="card-header py-3">
                      <h3 class="m-1 font-weight-bold" style = "color: green;"><c:out value="${project.projectName}"/></h3>
                  </div>
                  <div class="card-body">
                  <p> <c:out value="${project.description}"/></p>
                  <h2 class="display-6">Project ID: <c:out value="${project.projID}"/></h2>
                  	<button data-toggle="modal" data-target=".bd-example-modal-lg" class="btn" role="button">Add User Pool</button>
                  </div>
              </div>
           </div>
          <div class="row" style = "display:flex; flex-direction:row;">   
          <c:forEach items="${project.userpools}" var="pu">       
            <div class="col-xl-3 col-md-6 mb-4"	>
              <div class="card border-left-primary shadow h-100 py-2" >
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class=" font-weight-bold text-uppercase mb-1" ><a style = "font-size: 20px;"href="/up/${pu.id} "><c:out value="${pu.name}"/></a> </div>
                      <h2 class="display-6">User Pool ID: <c:out value="${pu.id}"/></h2>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Users : ${fn:length(pu.users)} </div>
                    </div>
                    <div class="col-auto">
                    <i class="far fa-address-book fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
             </c:forEach>            
            </div>
            </div>
   			</c:forEach>
    </c:when>
    <c:otherwise>
    	<div class="card border-0 shadow my-5" id="overlay">
               <div class="row">          
              <div class="card shadow mb-4" style = "width: 508px; margin-left: 17px;margin-right: 17px;">
                  <div class="card-header py-3">
                      <h3 class="m-1 font-weight-bold" style = "color: green;">No projects yet!</h3>
                  </div>
                  <div class="card-body">
                  <h2 class="display-6">Add an existing project by clicking the "Add Project" button. </h2>
                  </div>
              </div>
           </div>
           </div>
    </c:otherwise>
</c:choose>
	</div>
</body>
  <footer class="py-5 bg-black">
    <div class="container">
      <p class="m-0 text-center text-white small">Copyright © Alcatraz 2019</p>
    </div>
    <!-- /.container -->
  </footer>
  
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id = "overlay">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    <div style = "padding: 30px; display: flex; justify-content: center; flex-wrap: wrap;" >
    	<h1 class="display-4" style = "color: black;  font-weight: 450;">Create a New Userpool</h1>
      	<h4 style = "color: black;  font-weight: 450; display: flex; flex-direction: row; justify-self: center;"> Create a User Pool by giving it a name and choose the existing project it belongs to!</h4>
    </div>
    <div class="row" style = "display: flex; justify-content: center;">
	<div class="col-sm-9" >
	<form:form action="/userpools" method="post" modelAttribute="userpools">
	<div class="form-group">
		<form:label style = "color: black; font-size: 24px;" path="name">User Pool Name</form:label>
		<form:errors path="name"/>
		<form:input path="name" class="form-control" id="userpool_name" placeholder="User Pool Name"/>
	</div>
	<div class="form-group">
		<form:label style = "color: black; font-size: 24px;" path="project">Project</form:label>
		<form:errors path="project"/>
		<form:select path="project" class="form-control">
		<c:forEach items="${projects}" var="proj">
		<form:option value="${proj.id}"> <c:out value="${proj.projectName}"/> </form:option>							
		</c:forEach>
		</form:select>
    </div>
    <hr class="my-4">
	<input style = "margin-bottom: 30px;" type="submit" value="Create User Pool!" class="btn btn-lg" id="btn-1"/>
	</form:form>
	</div>
	</div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
