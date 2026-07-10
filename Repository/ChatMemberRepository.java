package com.WhatApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhatApp.entity.ChatMember;

@Repository
public interface ChatMemberRepository extends JpaRepository<ChatMember, Long> {
	List<ChatMember> findByChatId(Long chatId);
	Optional<ChatMember> findByChatIdAndUserId(Long chatId,Long userId);
}
