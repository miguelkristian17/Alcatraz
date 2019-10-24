package com.ryan.study.Alcatraz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ryan.study.Alcatraz.services.DeveloperService;
import com.ryan.study.Alcatraz.services.ProjectService;
import com.ryan.study.Alcatraz.services.UserPoolService;
import com.ryan.study.Alcatraz.services.UserService;

@Controller
public class AnnaController {
	private final DeveloperService developerService;
	private final ProjectService projectService;
	private final UserService userService;
	private final UserPoolService userpoolService;
	
	public AnnaController(DeveloperService developerService, ProjectService projectService, UserService userService, UserPoolService userpoolService) {
		this.developerService = developerService;
		this.projectService = projectService;
		this.userService = userService;
		this.userpoolService = userpoolService;
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/newproj")
	public String newProject() {
		return "new_project.jsp";
	}
	
	@GetMapping("/newup")
	public String newUP() {
		return "new_user_pool.jsp";
	}
}
