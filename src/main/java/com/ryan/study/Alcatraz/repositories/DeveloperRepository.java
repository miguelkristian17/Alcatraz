package com.ryan.study.Alcatraz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.study.Alcatraz.models.Developer;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
	Developer findByEmail(String email);
}
