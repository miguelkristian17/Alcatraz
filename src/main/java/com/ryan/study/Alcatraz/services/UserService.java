package com.ryan.study.Alcatraz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.models.User;
import com.ryan.study.Alcatraz.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//Get all instances of users
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	// Creates an instance of a user
	public User createUser(User user){
		return this.userRepository.save(user);
	}
		
	//Get an instance of a user by Id
    public User findUserById(Long id) {
        Optional<User> optionalUser= this.userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

	//Get an instance of a user by Email
    public User findUserByEmail(String email) {
        Optional<User> optionalUser= this.userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    //Deletes an instance of a user
	public void  deleteUserById(Long id){
		this.userRepository.deleteById(id);
	}

}
