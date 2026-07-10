package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "chats")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatid")
    private Long chatId;

    @Column(name = "isgroup")
    private Boolean isGroup;

    @Column(name = "groupname")
    private String groupName;

    @Column(name = "groupdescription")
    private String groupDescription;

    @Column(name = "createdby")
    private Long createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;
}

