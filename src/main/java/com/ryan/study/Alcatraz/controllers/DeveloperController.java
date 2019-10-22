package com.ryan.study.Alcatraz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.study.Alcatraz.services.DeveloperService;
import com.ryan.study.Alcatraz.validator.DeveloperValidator;

@Controller
public class DeveloperController {
		private final DeveloperService developerService;
		
		private final DeveloperValidator developerValidator;
		
		public DeveloperController(DeveloperService developerService,DeveloperValidator developerValidator) {
			this.developerService = developerService;
			this.developerValidator = developerValidator;
		}
		
		@RequestMapping("/home")
		public String home() {
			return "home.jsp";
		}

}
