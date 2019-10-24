package com.ryan.study.Alcatraz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.study.Alcatraz.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
