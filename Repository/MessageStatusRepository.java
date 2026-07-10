package com.WhatApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhatApp.entity.MessageStatus;
@Repository
public interface MessageStatusRepository extends JpaRepository<MessageStatus, Long> {
	Optional<MessageStatus> findByMessageId(Long messageId);
}
