package com.ryan.study.Alcatraz.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.models.Project;
import com.ryan.study.Alcatraz.models.User;
import com.ryan.study.Alcatraz.models.UserPool;
import com.ryan.study.Alcatraz.services.DeveloperService;
import com.ryan.study.Alcatraz.services.ProjectService;
import com.ryan.study.Alcatraz.services.UserPoolService;
import com.ryan.study.Alcatraz.services.UserService;

@RestController
public class JWTController {
	private final DeveloperService developerService;
	private final ProjectService projectService;
	private final UserService userService;
	private final UserPoolService userpoolService;
	
	public JWTController(DeveloperService developerService, ProjectService projectService, UserService userService, UserPoolService userpoolService) {
		this.developerService = developerService;
		this.projectService = projectService;
		this.userService = userService;
		this.userpoolService = userpoolService;
		}
	
	@RequestMapping(value = "{projectName}/login/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public String createLoginToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projectName") String projectName,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password
 			) {
		Developer developerCheck = developerService.findDeveloperByDevID(devID);
		UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
		Project project = projectService.findProjectByName(projectName);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user == null) {
	            return "Incorect Email!";
	        } else {
	        	if(password != null) {
	        		try {
	        			String code = devID.toString();
	        			Algorithm algorithm = Algorithm.HMAC256(code);
	        		    String token = JWT.create()
	        		    		.withClaim("email", email)
	        		    		.withClaim("password", password)
	        		            .withIssuer("auth0")
	        		            .sign(algorithm);
	        		    user.setToken(token);
	        		    if(token == user.getToken()) {
	        		    return token;}
	        		} catch (JWTCreationException exception){
	        			return "error";
	        		  }	            	
	        		} else {
	        			return "Incorrect Password!";
	        		  }
	         }
	    }
			return "error";
		}
	@RequestMapping(value = "{projectName}/register/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public String createUserToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projectName") String projectName,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password
 			) {
		Developer developerCheck = developerService.findDeveloperByDevID(devID);
		UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
		Project project = projectService.findProjectByName(projectName);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user == null) {
	            return "Incorect Email!";
	        } else {
	        	if(password != null) {
	        		try {
	        			String code = devID.toString();
	        			Algorithm algorithm = Algorithm.HMAC256(code);
	        		    String token = JWT.create()
	        		    		.withClaim("email", email)
	        		    		.withClaim("password", password)
	        		            .withIssuer("auth0")
	        		            .sign(algorithm);
	        		    user.setToken(token);
	        		    if(token == user.getToken()) {
	        		    return token;}
	        		} catch (JWTCreationException exception){
	        			return "error";
	        		  }	            	
	        		} else {
	        			return "Incorrect Password!";
	        		  }
	         }
	    }
			return "error";
		}
}

