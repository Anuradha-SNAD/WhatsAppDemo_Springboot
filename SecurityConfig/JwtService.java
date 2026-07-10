package com.WhatApp.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY ="ThisIsMySecretKeyForJwtTokenGeneration123456";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    
    public String generateToken(String mobileNumber) {
        return Jwts.builder().subject(mobileNumber).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+ 86400000)).signWith(key).compact();
    }
    
	public Claims extractClaims(String token) {
	    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
	}
	
	public boolean validateToken(String token) {
	    try {
	        extractClaims(token);
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

 
}

