package com.WhatApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WhatApp.DTO.LoginRequest;
import com.WhatApp.Exceptions.NotFoundException;
import com.WhatApp.Repository.UserRepository;
import com.WhatApp.Security.JwtService;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
	@Autowired
	private JwtService jwtService;
	
	public String login(LoginRequest request) {
	    userRepository.findByMobileNumber(request.getMobileNumber()).orElseThrow(() ->new NotFoundException("User Not Found"));

	    return jwtService.generateToken(request.getMobileNumber());
	}

}
