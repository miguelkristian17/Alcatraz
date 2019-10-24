package com.ryan.study.Alcatraz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.models.UserPool;
import com.ryan.study.Alcatraz.repositories.UserPoolRepository;

@Service
public class UserPoolService {
	private final UserPoolRepository userpoolRepository;
	
	public UserPoolService(UserPoolRepository userpoolRepository) {
		this.userpoolRepository = userpoolRepository;
	}
	
	//Get all instances of user pools
	public List<UserPool> getAllUserPool(){
		return this.userpoolRepository.findAll();
	}
	
	// Creates an instance of a user pool
	public UserPool createUserPool(UserPool userPool){
		return this.userpoolRepository.save(userPool);
	}
		
	//Get an instance of a user pool by Id
    public UserPool findUserPoolById(Long id) {
        Optional<UserPool> optionalUserPool= this.userpoolRepository.findById(id);
        if(optionalUserPool.isPresent()) {
            return optionalUserPool.get();
        } else {
            return null;
        }
    }
    //Updates an instance of a user pool
    public UserPool updateUserPool(Long id, String name) {
    	Optional<UserPool> optionalUserPool = userpoolRepository.findById(id);
        if(optionalUserPool.isPresent()) {
        	UserPool userPool = optionalUserPool.get();
        	userPool.setName(name);
        	return userpoolRepository.save(userPool);
        } else {
        	  return null;
        }    
    }

    //Deletes an instance of a user Pool
	public void deleteUserPoolById(Long id){
		this.userpoolRepository.deleteById(id);
	}

}
