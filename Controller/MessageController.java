
package com.WhatApp.Controller;

import com.WhatApp.DTO.SendMessageRequest;
import com.WhatApp.entity.Message;
import com.WhatApp.entity.MessageStatus;
import com.WhatApp.Service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@Tag(name = "Message Management APIs", description = "Operations related to messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    @Operation(summary = "Send Message")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody SendMessageRequest request) {
        return ResponseEntity.ok(service.sendMessage(request));
    }

    @PatchMapping("/{messageId}/read")
    @Operation(summary = "Mark Message As Read")
    public ResponseEntity<MessageStatus> markAsRead(@PathVariable Long messageId) {
        return ResponseEntity.ok(service.markAsRead(messageId));
    }

    @DeleteMapping("/{messageId}")
    @Operation(summary = "Delete Message")
    public ResponseEntity<String> deleteMessage(@PathVariable Long messageId) {
        service.deleteMessage(messageId);
        return ResponseEntity.ok("Message Deleted Successfully");
    }
}

