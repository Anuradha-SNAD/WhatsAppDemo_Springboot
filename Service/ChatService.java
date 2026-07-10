package com.WhatApp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WhatApp.DTO.AddMemberRequest;
import com.WhatApp.DTO.CreateChatRequest;
import com.WhatApp.Exceptions.ConflictException;
import com.WhatApp.Exceptions.NotFoundException;
import com.WhatApp.Repository.ChatMemberRepository;
import com.WhatApp.Repository.ChatRepository;
import com.WhatApp.Repository.UserRepository;
import com.WhatApp.entity.Chat;
import com.WhatApp.entity.ChatMember;

@Service
public class ChatService {

    @Autowired
    private ChatRepository repository;
    @Autowired
    private ChatMemberRepository chatMemberRepository;
    @Autowired
    private UserRepository userRepository;
    

    public Chat createGroup(CreateChatRequest request) {
	userRepository.findById(request.getCreatedBy()).orElseThrow(() ->new NotFoundException("User Not Found"));
        Chat chat = new Chat();
        chat.setIsGroup(true);
        chat.setGroupName(request.getGroupName());
        chat.setGroupDescription(request.getGroupDescription());
        chat.setCreatedBy(request.getCreatedBy());
        chat.setCreatedDate(LocalDateTime.now());

        Chat savedChat = repository.save(chat);
        ChatMember member = new ChatMember();
        member.setChatId(savedChat.getChatId());
        member.setUserId(request.getCreatedBy());
        member.setIsAdmin(true);
        member.setJoinedDate(LocalDateTime.now());

        chatMemberRepository.save(member);
        return savedChat;
    }

    public ChatMember addMember(Long chatId, AddMemberRequest request) {
    	repository.findById(chatId).orElseThrow(() ->new NotFoundException("Chat Not Found"));

        userRepository.findById(request.getUserId()).orElseThrow(() -> new NotFoundException("User Not Found"));

        if (chatMemberRepository.findByChatIdAndUserId(chatId,request.getUserId()).isPresent()) {
        	throw new ConflictException("Member Already Exists");
        }
        ChatMember member = new ChatMember();
        member.setChatId(chatId);
        member.setUserId(request.getUserId());
        member.setIsAdmin(request.getIsAdmin());
        member.setJoinedDate(LocalDateTime.now());

        return chatMemberRepository.save(member);
    }
	

	public List<ChatMember> getMembers(Long chatId) {
		repository.findById(chatId).orElseThrow(() ->new NotFoundException("Chat Not Found"));
		return chatMemberRepository.findByChatId(chatId);
	}
	
	public void removeMember(Long chatId, Long userId) {
		ChatMember member = chatMemberRepository.findByChatIdAndUserId(chatId, userId).orElseThrow(()->new NotFoundException("Member Not Found"));
		chatMemberRepository.delete(member);
	}

    public void deleteGroup(Long chatId) {
    	Chat chat = repository.findById(chatId).orElseThrow(() -> new NotFoundException("Chat Not Found"));
        repository.delete(chat);
    }

}
