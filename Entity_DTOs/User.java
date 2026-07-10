package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long userId;
	
	@Column(name = "mobilenumber")
	private String mobileNumber;
	
	@Column(name = "username")
	private String userName; 
	
	@Column(name = "about")
	private String about;
	
	@Column(name = "profilephoto")
	private String profilePhoto;
	
	@Column(name = "lastseen")
	private LocalDateTime lastSeen;
	
	@Column(name = "isonline")
	private Boolean isOnline;
	
	@Column(name = "createddate")
	private LocalDateTime createdDate;

}
