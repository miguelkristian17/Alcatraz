package com.ryan.study.Alcatraz.services;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

}
