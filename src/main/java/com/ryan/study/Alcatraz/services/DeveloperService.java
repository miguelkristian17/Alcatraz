package com.ryan.study.Alcatraz.services;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.repositories.DeveloperRepository;

@Service
public class DeveloperService {
	private final DeveloperRepository developerRepository;
	
	public DeveloperService(DeveloperRepository developerRepository) {
		this.developerRepository = developerRepository;
	}
	

}
