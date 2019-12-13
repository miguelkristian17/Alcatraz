<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/home_style.css">
</head>
<body id="page-top">
  	<!-- Header -->
  	<header class="masthead">
    	<div class="container d-flex h-100 align-items-center">
      		<div class="mx-auto text-center">
        		<h1 class="mx-auto my-0 text-uppercase">Alcatraz</h1>
        		<h2 class="text-white-50 mx-auto mt-2 mb-5">Maximum security login/registration management system built by RAM Incorporated.</h2>
        		<a href="/index" class="btn btn-primary js-scroll-trigger">Get Started</a>
      		</div>
    	</div>
  	</header>

  	<!-- About Section -->
  	<section id="about" class="about-section text-center">
    	<div class="container">
      		<div class="row">
        		<div class="col-lg-8 mx-auto">
          			<h2 class="text-white mb-2">A RAM Inc Design</h2>
          			<p class="text-white-50">        		
          		</div>
      		</div>
    	</div>
  	</section> 
  	
  	
 <!-- About Section -->
  <section id="projects" class="projects-section bg-dark">
    <div class="container">

      <!-- About Row One -->
      <div class="row align-items-center no-gutters mb-4 mb-lg-5">
        <div class="col-xl-8 col-lg-7">
          <img id="cyberpic" class="img-fluid mb-3 mb-lg-0" src="/img/cyber.jpg" alt="">
        </div>
        <div class="col-xl-4 col-lg-5">
           <div class="featured-text text-center text-lg-left">
            <p class="text-white-50 mb-0">Alcatraz grants developers the ability to effectively and efficiently add user-management features such as,
              sign-up, sign-in and access control to their web and mobile apps. Utilizing Alcatraz you can rest assured that all your user-management/authentication
               needs are taken care of in an organized and secure manner.</p>
          </div>         
        </div>
        </div>
      </div>


 
  </section>
  	
  	

  	<!-- Footer -->
  	<footer class="bg-black small text-center text-white-50">
    	<div class="container">
      		Copyright &copy; Alcatraz 2019
    	</div>
  	</footer>
  	
  	<!-- Bootstrap core JavaScript -->
  	<script src="vendor/jquery/jquery.min.js"></script>
  	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  	<!-- Plugin JavaScript -->
  	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

 	<!-- Custom scripts for this template -->
  	<script src="js/grayscale.min.js"></script>
</body>
</html>