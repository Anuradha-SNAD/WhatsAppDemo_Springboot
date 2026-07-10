package com.WhatApp.Controller;

import com.WhatApp.DTO.LoginRequest;
import com.WhatApp.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication APIs")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}


