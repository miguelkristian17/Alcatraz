<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script id="twitter-wjs" src="https://platform.twitter.com/widgets.js"></script><script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript">
    var host = "startbootstrap.com";
    if ((host == window.location.host) && (window.location.protocol != "https:"))
      window.location.protocol = "https";
  </script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Start Bootstrap">
<meta name="google-site-verification" content="37Tru9bxB3NrqXCt6JT5Vx8wz2AJQ0G4TkC-j8WL3kw">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/about_style.css">

<title>
    One Page Wonder - Theme Preview - Start Bootstrap
  </title>

<meta name="description" content="">

<link rel="canonical" href="https://startbootstrap.com/previews/one-page-wonder/">

<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-6jHF7Z3XI3fF4XZixAuSu0gGKrXwoX/w3uFPxC56OtjChio7wtTGJWRW53Nhx6Ev" crossorigin="anonymous">

<link rel="stylesheet" href="/assets/style-theme.css">

<link type="application/atom+xml" rel="alternate" href="https://startbootstrap.com/feed.xml" title="startbootstrap">

<meta name="ir-site-verification-token" value="-28223945">

<meta property="og:title" content="One Page Wonder - Theme Preview">
<meta property="og:site_name" content="Start Bootstrap">
<meta property="og:type" content="website">
<meta property="og:description" content="">
<meta property="og:image" content="https://startbootstrap.com/assets/img/branding/og-start-bootstrap.png">
<meta property="og:url" content="https://startbootstrap.com/previews/one-page-wonder/">
<meta property="og:image:alt" content="One Page Wonder - Theme Preview">

<meta name="twitter:card" content="summary">
<meta name="twitter:image" content="https://startbootstrap.com/assets/img/branding/start-bootstrap-logo-500x500.png">
<meta name="twitter:site" content="@SBootstrap">

<link rel="apple-touch-icon" sizes="180x180" href="/assets/img/icons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="/assets/img/icons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/assets/img/icons/favicon-16x16.png">
<link rel="manifest" href="/assets/img/icons/site.webmanifest">
<link rel="mask-icon" href="/assets/img/icons/safari-pinned-tab.svg" color="#dd3d31">
<meta name="msapplication-TileColor" content="#dd3d31">
<meta name="theme-color" content="#ffffff">
<script type="text/javascript" src="//m.servedby-buysellads.com/monetization.js"></script>
</head>

<body>
<div id="bgc">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light static-top shadow" id="top">
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
          				<a class="nav-link" href="/docs">Documentation</a>
        			</li>
        			
        			<li class="nav-item">
          				<a class="nav-link" href="/home">Logout</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>

  <header class="masthead text-center text-#1d3917">
    <div class="masthead-content">
      <div class="container">
        <h1 class="masthead-heading mb-0" style="color:lightgrey;">-Alcatraz-</h1>
        <h4>"Efficiency,Security,Integrity"</h4>
      </div>
    </div>
    <div class="bg-circle-1 bg-circle"></div>
    <div class="bg-circle-2 bg-circle"></div>
    <div class="bg-circle-3 bg-circle"></div>
    <div class="bg-circle-4 bg-circle"></div>
  </header>

  <section>
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6 order-lg-2">
          <div class="p-5">
            <img class="img-fluid rounded-circle" src="img/sanfran.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-6 order-lg-1">
          <div class="p-4">
            <h2 class="display-4">Welcome To The Rock!</h2>
            <p>Alcatraz is a service designed to provide web developers secure authentication and user management for their web apps. 
            It was our goal to  implement a service that clones some of the key features of the popular AWS Cognito, but do so in a manner that is more user friendly and time 
            efficient for small or independent development companies. Alcatraz oversees user management features such as sign-up, sign-in, and access control, so that developers
             can focus on other key components and features of the web and mobile applications they are tasked to design.
            <br>
            <br>
            "Alcatraz... efficiency, security, integrity"
              .</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section>
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6">
          <div class="p-5">
            <img class="img-fluid rounded-circle" src="img/jailcell.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-6">
          <div class="p-5">
            <h2 class="display-5">How It Works</h2>
            <p>After creating a developer account, you will receive a unique Developer ID. Once you have your Developer ID, you will have the option to create a new project as well as
             implement user-pools into this project with custom preferences. Once you have successfully created your custom project and the prerequisites for your user-pool, we will then
              generate unique ID's for both the user-pool and project. Once all ID's have been generated, your work is done, you simply paste the unique URL into your route.
               For example: "login/yourProjectID/yourDeveloperID/yourUserPoolID". 
               <br>
				This route will travel to the Alcatraz server. We will authenticate the information in our database as well as create or update the information. If the information is 
				processed without any errors, we will return a secure JSON token back to you. This token will act as the user in sessions "Hall-Pass,” separating Administrators actions
				 and functionality they are allowed on your site from regular users, as well as Logging Users in and out and otherwise keeping track of the users and their information. 
 			</p>
          </div>
        </div> 
      </div>
    </div>
  </section>

  <section>
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6 order-lg-2">
          <div class="p-5">
            <img class="img-fluid rounded-circle" src="img/computer.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-6 order-lg-1">
          <div class="p-5">
            <h2 class="display-4">Designed with Dev's In Mind </h2>
            <p>Our goal is to be a resource for self employed or small business developers, who develop multiple applications throughout the year. Clientele growth directly correlates 
            with your responsibility to manage their ever changing user pools. We are here to alleviate some of that stress so you can focus on growing your company and doing what you love.  </p>
          </div>
        </div>
      </div>
    </div>
  </section>
  </div>

  <!-- Footer -->
  <footer class="py-5 bg-black">
    <div class="container">
      <p class="m-0 text-center text-white small">Copyright © Alcatraz 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>




</body>

  	
</html>