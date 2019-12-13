package com.ryan.study.Alcatraz.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.models.Project;
import com.ryan.study.Alcatraz.models.User;
import com.ryan.study.Alcatraz.models.UserPool;
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
	public String dashboard(HttpSession session, Model model, @ModelAttribute("project") Project project, @ModelAttribute("userpools") UserPool userpool) {
		Long developerId = (Long) session.getAttribute("developerId");
		Developer d = developerService.findDeveloperById(developerId);
		model.addAttribute("developer", d);
		List<Project> projects = projectService.getAllProjectsByDeveloper(d);
		model.addAttribute("projects", projects);
		return "dashboard.jsp";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about.jsp";
	}
	
	@GetMapping("/docs")
	public String docsPage() {
		return "docs.jsp";
	}
	@GetMapping("/newproj")
	public String newProject(@ModelAttribute("projects") Project project) {
		return "new_project.jsp";
	}
	
	@PostMapping("/projects")
	public String createProject(HttpSession session, @Valid @ModelAttribute("projects") Project project, BindingResult results) {
		if(results.hasErrors()) {
			return "redirect:/newproj";
		}
		else {
			Long developerId = (Long) session.getAttribute("developerId");
			Developer d = developerService.findDeveloperById(developerId);
			project.setDeveloper(d);
			project = this.projectService.createProject(project);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/newup")
	public String newUP(Model model, @ModelAttribute("userpools") UserPool userpool) {
		List<Project> projects = this.projectService.getAllProjects();
		model.addAttribute("allProjects", projects);
		return "new_user_pool.jsp";
	}
	
	@PostMapping("/userpools")
	public String createUserPool(@Valid @ModelAttribute("userpools") UserPool userpool, BindingResult results) {
		if(results.hasErrors()) {
			return "redirect:/newup";
		}
		else {
			userpool = this.userpoolService.createUserPool(userpool);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/up/{id}")
	public String userpoolDetails(@PathVariable("id") Long id, Model model) {
		UserPool userpool = userpoolService.findUserPoolById(id);
		model.addAttribute("userpool", userpool);
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "userpool_details.jsp";
	}
}
