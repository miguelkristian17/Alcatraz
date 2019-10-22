package com.ryan.study.Alcatraz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ryan.study.Alcatraz.models.Developer;

public interface DeveloperRepository extends CrudRepository<Developer,Long> {

}
