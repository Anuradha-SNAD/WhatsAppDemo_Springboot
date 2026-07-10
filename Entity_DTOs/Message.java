package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid")
    private Long messageId;

    @Column(name = "chatid")
    private Long chatId;

    @Column(name = "senderid")
    private Long senderId;

    @Column(name = "messagetype")
    private String messageType;

    @Column(name = "messagecontent")
    private String messageContent;

    @Column(name = "sentdate")
    private LocalDateTime sentDate;


}
