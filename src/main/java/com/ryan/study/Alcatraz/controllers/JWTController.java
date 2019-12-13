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
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
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
	
//  Registration
	@RequestMapping(value = "register/{projID}/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public HashMap<String, String> createUserToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projID") Long projID,
 			@RequestParam("name") String name,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password,
 			@RequestParam("passwordConfirmation") String passwordConfirmation
 			) {
		HashMap<String, String> hash = new HashMap<>();
	    hash.put("error", null);
	    Developer developerCheck = developerService.findDeveloperByDevID(devID);
	    UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
	    Project project = projectService.findProjectByProjID(projID);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user != null) {
	        	hash.replace("error", "Email already Exists!");
	            return hash;
	        }
	        if(password.equals(passwordConfirmation)){
	        	String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
	        	User newUser = new User(email, name, hashed);

	        	try {
	        			String code = devID.toString();
	        			String uPool = userPool.getName();
	        			String userID = newUser.getUserID().toString();
	        			Algorithm algorithm = Algorithm.HMAC256(code);
	        		    String token = JWT.create()
	        		    		.withClaim("User ID", userID)
	        		    		.withClaim("User Pool", uPool)
	        		            .withIssuer("Alcatraz")
	        		            .sign(algorithm);
	        		    newUser.setUserpools(userPool);
	        		    this.userService.createUser(newUser);
	        		    hash.remove("error");
	        		    hash.put("token", token);
	        		    return hash;
	        		    } catch (JWTCreationException exception){
	        		    	hash.replace("error", "Incorrect Credentials!");
	        			    return hash;
	        			    }	            	
	        		}
	        hash.replace("error", "Passwords did not match!");
	        return hash; 
	        }
		hash.replace("error",  "Incorrect Credentials!");
		return hash;
		}
//  Login
	@RequestMapping(value = "login/{projID}/{devID}/{userPoolID}", method = RequestMethod.POST)
 	public HashMap<String, String> createLoginToken(
 			@PathVariable("devID") Long devID,
 			@PathVariable("userPoolID") long userPoolID,
 			@PathVariable("projID") long projID,
 			@RequestParam("email") String email,
 			@RequestParam("password") String password
 			) {
		HashMap<String, String> hash = new HashMap<>();
		Developer developerCheck = developerService.findDeveloperByDevID(devID);
		UserPool userPool = this.userpoolService.findUserPoolById(userPoolID);
		Project project = projectService.findProjectByProjID(projID);
	    hash.put("error", null);
		if(userPool.getProject() == project && developerCheck != null) {
			User user = this.userService.findUserByEmail(email);
	        if(user == null) {
	        	hash.replace("error", "Email does not exist!");
	        	return hash;
	        } else {
	        	if(BCrypt.checkpw(password, user.getPassword())) {
	        		try {
	        			String code = devID.toString();
	        			String uPool = userPool.getName();
	        			String userID = String.valueOf(user.getUserID());
	        			Algorithm algorithm = Algorithm.HMAC256(code);
	        		    String token = JWT.create()
	        		    		.withClaim("userID", userID)
	        		    		.withClaim("User Pool", uPool)
	        		            .withIssuer("Alcatraz")
	        		            .sign(algorithm);
	        		    hash.remove("error");
	        		    hash.put("Token", token);
	        		    try {
	        		    	  java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();
	        		            String[] parts = token.split("\\.");
	        		            String payloadJson = new String(decoder.decode(parts[1]));
	        		            System.out.print(payloadJson);
	        		    	return hash;
	        		    } catch (JWTDecodeException exception){
	        		    }
	        		} catch (JWTCreationException exception){
	        			hash.replace("error", "JWTCreationException Error");
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
}