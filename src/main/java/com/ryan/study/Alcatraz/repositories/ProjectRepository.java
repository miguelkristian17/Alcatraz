package com.ryan.study.Alcatraz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.study.Alcatraz.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
