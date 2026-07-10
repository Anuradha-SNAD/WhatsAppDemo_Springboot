package com.WhatApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhatApp.entity.Chat;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
