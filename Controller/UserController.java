package com.WhatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.WhatApp.DTO.CreateUserRequest;
import com.WhatApp.DTO.UpdateUserRequest;
import com.WhatApp.Service.UserService;
import com.WhatApp.entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management APIs", description = "Operations related to users")
public class UserController {

    @Autowired
    private UserService service;
    

    @PostMapping
    @Operation(summary = "Register User")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get User By Id")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
    	return ResponseEntity.ok(service.getUserById(userId));
    }

    @GetMapping("/mobile/{mobileNumber}")
    @Operation(summary = "Get User By Mobile Number")
    public ResponseEntity<User> getUserByMobileNumber(@PathVariable String mobileNumber) {
    	return ResponseEntity.ok(service.getUserByMobileNumber(mobileNumber));
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update User")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@Valid @RequestBody UpdateUserRequest request) {
    	return ResponseEntity.ok(service.updateUser(userId, request));
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete User")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    	service.deleteUser(userId);
    	return ResponseEntity.ok("User Deleted Successfully");
    }

    

}
