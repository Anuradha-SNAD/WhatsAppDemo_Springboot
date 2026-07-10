package com.WhatApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhatApp.entity.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByChatId(Long chatId);
}
