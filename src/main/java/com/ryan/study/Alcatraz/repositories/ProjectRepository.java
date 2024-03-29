package com.ryan.study.Alcatraz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	Optional<Project> findProjectByProjID(Long projID);
	Optional<Project> findProjectByProjectName(String projectName);

	List<Project> findAllByDeveloper(Developer dev);
}
