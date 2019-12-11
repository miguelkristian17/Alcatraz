package com.ryan.study.Alcatraz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.models.Project;
import com.ryan.study.Alcatraz.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	//Get all instances of projects
	public List<Project> getAllProjects(){
		return this.projectRepository.findAll();
	}
	
	public List<Project> getAllProjectsByDeveloper(Developer dev){
		return this.projectRepository.findAllByDeveloper(dev);
	}
	
	// Creates an instance of a project
	public Project createProject(Project project){
		return this.projectRepository.save(project);
	}
		
	//Get an instance of a project by Id
    public Project findProjectById(Long id) {
        Optional<Project> optionalProject = this.projectRepository.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
	//Get an instance of a project by project name
    public Project findProjectByName(String projectName) {
        Optional<Project> optionalProject = this.projectRepository.findProjectByProjectName(projectName);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    // Updates an instance of a project
    public Project updateProject(Long id, String projectName, String description) {
    	Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()) {
        	Project project = optionalProject.get();
        	project.setProjectName(projectName);
        	project.setDescription(description);
        	return projectRepository.save(project);
        } else {
        	  return null;
        }    
    }
    // Finds a project by long projID 
    public Project findProjectByProjID(Long projID) {
        Optional<Project> optionalProject = this.projectRepository.findProjectByProjID(projID);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    //Deletes an instance of a project
	public void  deleteProjectById(Long id){
		this.projectRepository.deleteById(id);
	}

}
