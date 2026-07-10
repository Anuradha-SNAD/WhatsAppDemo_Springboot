package com.WhatApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhatApp.entity.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	List<Contact> findByUserId(Long userId);
	Optional<Contact> findByUserIdAndContactUserId(Long userId,Long contactUserId);

}
