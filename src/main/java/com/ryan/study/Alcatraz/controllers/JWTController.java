package com.ryan.study.Alcatraz.controllers;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ryan.study.Alcatraz.validator.UserValidator;

@RestController
public class JWTController {
	private final DeveloperService developerService;
	private final ProjectService projectService;
	private final UserService userService;
	private final UserPoolService userpoolService;
    private final UserValidator userValidator;
	
	public JWTController(DeveloperService developerService, ProjectService projectService, UserService userService, UserPoolService userpoolService, UserValidator userValidator) {
		this.developerService = developerService;
		this.projectService = projectService;
		this.userService = userService;
		this.userpoolService = userpoolService;
		this.userValidator =  userValidator;
	}
	@CrossOrigin
	@RequestMapping(value = "{projectName}/login/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public HashMap<String, String> createLoginToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projectName") String projectName,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password
 			) {
		HashMap<String, String> hash = new HashMap<>();
		Developer developerCheck = developerService.findDeveloperByDevID(devID);
		UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
		Project project = projectService.findProjectByName(projectName);
	    hash.put("error", null);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user == null) {
	        	hash.replace("error", "Email does not exist!");
	        	return hash;
	        } else {
	        	String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
	        	if(hashed == user.getPassword()) {
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
	        		    hash.put("Token", token);
	        		    return hash;
	        		    }
	        		} catch (JWTCreationException exception){
	        			hash.replace("error", "error");
	        			return hash;
	        		  }	            	
	        		} else {
	        			hash.replace("error", "Incorrect Password");
	        			return hash;
	        		  }
	         }
	    }
		hash.replace("error", "Incorrect Credentials!");
			return hash;
		}

	@RequestMapping(value = "{projectName}/register/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public HashMap<String, String> createUserToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projectName") String projectName,
 			@RequestParam("name") String name,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password,
 			@RequestParam("passwordConfirmation") String passwordConfirmation
 			) {
		HashMap<String, String> hash = new HashMap<>();
	    hash.put("error", null);
        System.out.println(password);
        System.out.println(passwordConfirmation);
		Developer developerCheck = developerService.findDeveloperByDevID(devID);
		UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
		Project project = projectService.findProjectByName(projectName);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user != null) {
	        	hash.replace("error", "Email already Exists!");
	            return hash;
	        }
	        if(password != null){
	        	User newUser = new User(email, name, password);
	        		try {
	        			String code = devID.toString();
	        			Algorithm algorithm = Algorithm.HMAC256(code);
	        		    String token = JWT.create()
	        		    		.withClaim("email", email)
	        		    		.withClaim("password", password)
	        		            .withIssuer("auth0")
	        		            .sign(algorithm);
	        		    newUser.setUserpools(userPool);
	        		    newUser.setToken(token);
	        		    this.userService.createUser(newUser);
	        		    hash.put("token", token);
	        		    return hash;
	        		} catch (JWTCreationException exception){
	    	        	hash.replace("error", "Incorrect Credentials!");
	        			return hash;
	        		  }	            	
	         }
			hash.replace("error", "passwords did not match!");
			return hash; 
	    }
		hash.replace("error",  "Incorrect Credentials!");
		return hash;
		}
}