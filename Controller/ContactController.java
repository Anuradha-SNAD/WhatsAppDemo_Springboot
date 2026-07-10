package com.WhatApp.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.WhatApp.DTO.CreateContactRequest;
import com.WhatApp.Service.ContactService;
import com.WhatApp.entity.Contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@Tag(name = "Contact Management APIs", description = "Operations related to contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    @Operation(summary = "Add Contact")
    public ResponseEntity<Contact> addContact(@Valid @RequestBody CreateContactRequest request) {
    	return ResponseEntity.ok(service.addContact(request));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get Contacts By User Id")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable Long userId) {
    	return ResponseEntity.ok(service.getContacts(userId));
    }

    @DeleteMapping("/{contactId}")
    @Operation(summary = "Delete Contact")
    public ResponseEntity<String> deleteContact(@PathVariable Long contactId) {
    	service.deleteContact(contactId);
    	return ResponseEntity.ok("Contact Deleted Successfully");
    }
}

