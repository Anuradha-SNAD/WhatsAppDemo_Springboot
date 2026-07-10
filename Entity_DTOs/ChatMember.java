package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "chatmember")
public class ChatMember {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatmemberid")
    private Long chatMemberId;

    @Column(name = "chatid")
    private Long chatId;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "isadmin")
    private Boolean isAdmin;

    @Column(name = "joineddate")
    private LocalDateTime joinedDate;


}
