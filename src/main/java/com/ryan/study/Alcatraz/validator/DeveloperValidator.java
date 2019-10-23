package com.ryan.study.Alcatraz.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ryan.study.Alcatraz.models.Developer;

@Component
public class DeveloperValidator implements Validator{
	//1
	@Override
	public boolean supports(Class<?> clazz) {
		return Developer.class.equals(clazz);
	}
	
	//2
	@Override
	public void validate(Object target, Errors errors) {
		Developer developer = (Developer) target;
		
		if(!developer.getPasswordConfirmation().equals(developer.getPassword())) {
			//3
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}
