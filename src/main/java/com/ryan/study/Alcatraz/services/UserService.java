package com.ryan.study.Alcatraz.services;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
