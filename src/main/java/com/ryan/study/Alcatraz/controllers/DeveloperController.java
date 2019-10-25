package com.ryan.study.Alcatraz.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.services.DeveloperService;
import com.ryan.study.Alcatraz.validator.DeveloperValidator;

@Controller
public class DeveloperController {
	private final DeveloperService developerService;
	private final DeveloperValidator developerValidator;
	
	public DeveloperController(DeveloperService developerService, DeveloperValidator developerValidator) {
		this.developerService = developerService;
		this.developerValidator = developerValidator;
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home.jsp";
	}
	
	@GetMapping("/index")
	public String login_regPage(@ModelAttribute("developer") Developer developer) {
		return "login_registration.jsp";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("developer") Developer developer, BindingResult result, HttpSession session) {
		// if result has errors, return the index page
		developerValidator.validate(developer, result);
		if(result.hasErrors()) {
			return "login_registration.jsp";
		}
		// else, save the developer in the database, save the developer id in session, and redirect them to the /home route
		Developer d = developerService.registerDeveloper(developer);
		session.setAttribute("developerId", d.getId());
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("developer") Developer developer, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = developerService.authenticateDeveloper(email, password);
		// if the developer is authenticated, save their developer id in session
		if(isAuthenticated) {
			Developer d = developerService.findByEmail(email);
			session.setAttribute("developerId", d.getId());
			return "redirect:/dashboard";
		}
		// else, add error messages and return the login page
		else {
			model.addAttribute("error", "Invalid Credentials. Please try again!");
			return "login_registration.jsp";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//invalidate session
		session.invalidate();
		//redirect to login page
		return "redirect:/index";
	}
}
