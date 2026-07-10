package com.WhatApp.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WhatApp.DTO.CreateUserRequest;
import com.WhatApp.DTO.UpdateUserRequest;
import com.WhatApp.Exceptions.ConflictException;
import com.WhatApp.Exceptions.NotFoundException;
import com.WhatApp.Repository.UserRepository;
import com.WhatApp.entity.User;

@Service
public class UserService {

	@Autowired
    private UserRepository repository;
	
	public User createUser(CreateUserRequest req) {
		if(repository.existsByMobileNumber(req.getMobileNumber())) {
			throw new ConflictException("Mobile Number Already Exists");
		}
		User user = new User();
		user.setMobileNumber(req.getMobileNumber());
		user.setUserName(req.getUserName());
		user.setAbout(req.getAbout());
	    user.setProfilePhoto(req.getProfilePhoto());
	    user.setIsOnline(false);
	    user.setCreatedDate(LocalDateTime.now());
	    
	    return repository.save(user);
	}
	
	public User getUserById(Long userId) {
		return repository.findById(userId).orElseThrow(()->new NotFoundException("User Not Found"));
	}
	
	public User getUserByMobileNumber(String mobileNumber) {
		return repository.findByMobileNumber(mobileNumber).orElseThrow(()->new NotFoundException("User Not Found"));
	}
	
	public User updateUser(Long userId,UpdateUserRequest request) {
		User user = repository.findById(userId).orElseThrow(()->new NotFoundException("User Not Found"));

        user.setUserName(request.getUserName());
        user.setAbout(request.getAbout());
        user.setProfilePhoto(request.getProfilePhoto());
        user.setIsOnline(request.getIsOnline());
        return repository.save(user);

	}
	public void deleteUser(Long userId) {
		User user = repository.findById(userId).orElseThrow(()->new NotFoundException("User Not Found"));
		repository.delete(user);

	}
	

}
