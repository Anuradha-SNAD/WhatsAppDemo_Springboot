package com.WhatApp.Controller;
import com.WhatApp.DTO.*;
import com.WhatApp.entity.Chat;
import com.WhatApp.entity.ChatMember;
import com.WhatApp.entity.Message;
import com.WhatApp.Service.ChatService;
import com.WhatApp.Service.MessageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@Tag(name = "Chat Management APIs", description = "Operations related to chat groups")
public class ChatController {

    @Autowired
    private ChatService service;

	@Autowired
	private MessageService messageService;


    @PostMapping
    @Operation(summary = "Create Group")
    public ResponseEntity<Chat> createGroup(@Valid @RequestBody CreateChatRequest request) {
    	return ResponseEntity.ok(service.createGroup(request));
    }

    @PostMapping("/{chatId}/members")
    @Operation(summary = "Add Member To Group")
    public ResponseEntity<ChatMember> addMember(@PathVariable Long chatId, @Valid @RequestBody AddMemberRequest request) {
    	return ResponseEntity.ok(service.addMember(chatId, request));
    }

    @GetMapping("/{chatId}/members")
    @Operation(summary = "Get Group Members")
    public ResponseEntity<List<ChatMember>> getMembers(@PathVariable Long chatId) {
    	return ResponseEntity.ok(service.getMembers(chatId));
    }

    @DeleteMapping("/{chatId}/members/{userId}")
    @Operation(summary = "Remove Member From Group")
    public ResponseEntity<String> removeMember(@PathVariable Long chatId, @PathVariable Long userId) {
        service.removeMember(chatId, userId);
        return ResponseEntity.ok("Member Removed Successfully");
    }

    @DeleteMapping("/{chatId}")
    @Operation(summary = "Delete Group")
    public ResponseEntity<String> deleteGroup(@PathVariable Long chatId) {
        service.deleteGroup(chatId);
        return ResponseEntity.ok("Group Deleted Successfully");
    }
    

	@GetMapping("/{chatId}/messages")
	@Operation(summary = "Get Chat Messages")
	public ResponseEntity<List<Message>> getMessages(@PathVariable Long chatId) {
	    return ResponseEntity.ok(messageService.getMessages(chatId));
	}

}

