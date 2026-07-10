package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messagestatus")
public class MessageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusid")
    private Long statusId;

    @Column(name = "messageid")
    private Long messageId;

    @Column(name = "recipientid")
    private Long recipientId;

    @Column(name = "delivereddate")
    private LocalDateTime deliveredDate;

    @Column(name = "readdate")
    private LocalDateTime readDate;


}
