package com.ryan.study.Alcatraz.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.models.Project;
import com.ryan.study.Alcatraz.models.User;
import com.ryan.study.Alcatraz.models.UserPool;
import com.ryan.study.Alcatraz.services.DeveloperService;
import com.ryan.study.Alcatraz.services.ProjectService;
import com.ryan.study.Alcatraz.services.UserPoolService;
import com.ryan.study.Alcatraz.services.UserService;
// FOR TESTING MODELS ON POSTMAN
@RestController
public class APIController {
	private final DeveloperService developerService;
	private final ProjectService projectService;
	private final UserService userService;
	private final UserPoolService userpoolService;
	
	public APIController(DeveloperService developerService, ProjectService projectService, UserService userService, UserPoolService userpoolService) {
		this.developerService = developerService;
		this.projectService = projectService;
		this.userService = userService;
		this.userpoolService = userpoolService;
	}
	// PROJECT  **************************************************************
	
	// Creates a project
	@RequestMapping(value = "/api/{id}/project", method = RequestMethod.POST)
	public Project createProject(@PathVariable("id") Long id, @RequestParam(value = "projectName") String projectName, @RequestParam(value = "description") String description){
		Project project =  new Project(projectName, description);
		Developer developer = this.developerService.findDeveloperById(id);
		project.setDeveloper(developer);
		return this.projectService.createProject(project);	
	}
	
	// Gets all Projects
	@RequestMapping(value = "/api/project")
	public List<Project> allProjects(){
		return this.projectService.getAllProjects();
	}	
	// Get an instance of a project
	@RequestMapping(value = "api/project/{id}", method = RequestMethod.GET)
	public Project showProject(@PathVariable("id") Long id) {
		return this.projectService.findProjectById(id);
		
	}
	// Edits an instance of a project
	@RequestMapping(value = "api/project/{id}", method = RequestMethod.PUT)
	public Project updateProject(@PathVariable("id") Long id, @RequestParam(value = "projectName") String projectName, @RequestParam(value = "description") String description) {
		return this.projectService.updateProject(id, projectName, description);
	}
		
	// Delete an instance of a project
	@RequestMapping(value = "api/project/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable("id") Long id) {
		this.projectService.deleteProjectById(id);
	}
	
	// USER POOL  **************************************************************
	
	// Creates a User Pool 
	@RequestMapping(value ="/api/{id}/userPool" , method = RequestMethod.POST)
	public UserPool createUserPool(@PathVariable("id") Long id, @RequestParam("name") String name){
		Project project = this.projectService.findProjectById(id);
		System.out.println(project);
		UserPool userPool =  new UserPool(name);
		userPool.setProject(project);
		userPool = this.userpoolService.createUserPool(userPool);
		return userPool;	
	}
	
	// Gets all user pools
	@RequestMapping(value = "/api/userPool")
	public List<UserPool> allUserPool(){
		return this.userpoolService.getAllUserPool();
	}	
	// Get an instance of a user pool
	@RequestMapping(value = "api/userPool/{id}", method = RequestMethod.GET)
	public UserPool showUserPool(@PathVariable("id") Long id) {
		return this.userpoolService.findUserPoolById(id);
		
	}
	// Edits an instance of a user pool
	@RequestMapping(value = "api/userPool/{id}", method = RequestMethod.PUT)
	public UserPool updateUserPool(@PathVariable("id") Long id, @RequestParam(value="name") String name) {
		return this.updateUserPool(id, name);
	}
		
	// Delete an instance of a user pool
	@RequestMapping(value = "api/userPool/{id}", method = RequestMethod.DELETE)
	public void deleteUserPool(@PathVariable("id") Long id) {
		this.userpoolService.deleteUserPoolById(id);
	}
	
	// USER  **************************************************************
	// GET/ DELETE ONLY
	// Gets all users
	@RequestMapping(value = "/api/user")
	public List<User> allIUser(){
		return this.userService.getAllUsers();
	}	
	// Get an instance of a user pool
	@RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
	public User showUser(@PathVariable("id") Long id) {
		return this.userService.findUserById(id);
		
	}
	// Create a user
	@RequestMapping(value ="/api/{id}/user" , method = RequestMethod.POST)
	public User createUser(@PathVariable("id") Long id, @RequestParam("email") String email,@RequestParam("name") String name,  @RequestParam("password") String password){
		UserPool userPool = this.userpoolService.findUserPoolById(id);
		User user = new User(email, name, password);
		user.setUserpools(userPool);
		user = this.userService.createUser(user);
		return user;	
	}
	// Delete an instance of a user pool
	@RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {
		this.userService.deleteUserById(id);
	}
	
//	@RequestMapping(value = "api/developer/{id}", method = RequestMethod.GET)
//	public Developer showDeveloper(@PathVariable("id") Long id) {
//		return this.developerService.findDeveloperByID(id);
//		
//	}
		
	
}
