package com.ryan.study.Alcatraz.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.study.Alcatraz.models.UserPool;

@Repository
public interface UserPoolRepository extends CrudRepository<UserPool, Long> {
	List<UserPool> findAll();
}
