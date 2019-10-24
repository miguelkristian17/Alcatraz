package com.ryan.study.Alcatraz.services;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.repositories.UserPoolRepository;

@Service
public class UserPoolService {
	private final UserPoolRepository userpoolRepository;
	
	public UserPoolService(UserPoolRepository userpoolRepository) {
		this.userpoolRepository = userpoolRepository;
	}
}
