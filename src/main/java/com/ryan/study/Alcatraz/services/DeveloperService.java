package com.ryan.study.Alcatraz.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ryan.study.Alcatraz.models.Developer;
import com.ryan.study.Alcatraz.repositories.DeveloperRepository;

@Service
public class DeveloperService {
	private final DeveloperRepository developerRepository;
	
	public DeveloperService(DeveloperRepository developerRepository) {
		this.developerRepository = developerRepository;
	}
	
	 // register developer and hash their password
    public Developer registerDeveloper(Developer developer) {
        String hashed = BCrypt.hashpw(developer.getPassword(), BCrypt.gensalt());
        developer.setPassword(hashed);
        return developerRepository.save(developer);
    }
    
    // find developer by email
    public Developer findByEmail(String email) {
        return developerRepository.findByEmail(email);
    }
    
    // find developer by id
    public Developer findDeveloperById(Long id) {
    	Optional<Developer> d = developerRepository.findById(id);
    	
    	if(d.isPresent()) {
            return d.get();
    	} else {
    	    return null;
    	}
    }
    
    // find developer by devID
    public Developer findDeveloperByDevID(Long id) {
    	Optional<Developer> developer = developerRepository.findByDevID(id);
    	if(developer.isPresent()) {
            return developer.get();
    	} else {
    	    return null;
    	}
    }
    
    
    // authenticate developer
    public boolean authenticateDeveloper(String email, String password) {
        // first find the developer by email
    	Developer developer = developerRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(developer == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, developer.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
