package com.WhatApp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WhatApp.DTO.SendMessageRequest;
import com.WhatApp.Exceptions.NotFoundException;
import com.WhatApp.Repository.*;
import com.WhatApp.entity.Message;
import com.WhatApp.entity.MessageStatus;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageStatusRepository messageStatusRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(SendMessageRequest request) {
    	chatRepository.findById(request.getChatId()).orElseThrow(() -> new NotFoundException("Chat Not Found"));
    	userRepository.findById(request.getSenderId()).orElseThrow(() ->new NotFoundException("Sender Not Found"));
        Message message = new Message();
        message.setChatId(request.getChatId());
        message.setSenderId(request.getSenderId());
        message.setMessageType(request.getMessageType());
        message.setMessageContent(request.getMessageContent());
        message.setSentDate(LocalDateTime.now());

        return messageRepository.save(message);
    }
    

    public List<Message> getMessages(Long chatId) {
        chatRepository.findById(chatId).orElseThrow(() -> new NotFoundException("Chat Not Found"));
        return messageRepository.findByChatId(chatId);
    }


    public MessageStatus markAsRead(Long messageId) {
    messageRepository.findById(messageId).orElseThrow(() ->new NotFoundException("Message Not Found"));

    MessageStatus status = messageStatusRepository.findByMessageId(messageId).orElse(new MessageStatus());
    status.setMessageId(messageId);
    status.setReadDate(LocalDateTime.now());
    return messageStatusRepository.save(status);
    }

    public void deleteMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).orElseThrow(() ->new NotFoundException("Message Not Found"));
        messageRepository.delete(message);
    }


}
