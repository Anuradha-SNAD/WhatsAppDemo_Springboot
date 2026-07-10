package com.WhatApp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WhatApp.DTO.CreateContactRequest;
import com.WhatApp.Exceptions.ConflictException;
import com.WhatApp.Exceptions.NotFoundException;
import com.WhatApp.Repository.ContactRepository;
import com.WhatApp.Repository.UserRepository;
import com.WhatApp.entity.Contact;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repository;
	@Autowired
    private UserRepository userRepository;

	public Contact addContact(CreateContactRequest request) {
	userRepository.findById(request.getUserId()).orElseThrow(()-> new NotFoundException("User Not Found"));
	userRepository.findById(request.getContactUserId()).orElseThrow(()->new NotFoundException("Contact User Not Found"));
	if (repository.findByUserIdAndContactUserId( request.getUserId(),request.getContactUserId()).isPresent()) {
		throw new ConflictException("Contact Already Exists");
    }
		Contact contact = new Contact();

        contact.setUserId(request.getUserId());
        contact.setContactUserId(request.getContactUserId());
        contact.setNickName(request.getNickName());
        contact.setCreatedDate(LocalDateTime.now());

        return repository.save(contact);
    }
	
	public List<Contact> getContacts(Long userId){
		userRepository.findById(userId).orElseThrow(()->new NotFoundException("User Not Found"));

        List<Contact> contacts =repository.findByUserId(userId);

        if (contacts.isEmpty()) {
            throw new NotFoundException("No Contacts Found");
        }
        return contacts;
	}
	
	public void deleteContact(Long contactId) {
		Contact c = repository.findById(contactId).orElseThrow(()-> new NotFoundException(" Contacts Not Found"));
		repository.delete(c);
	}


}
