package com.WhatApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactid")
    private Long contactId;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "contactuserid")
    private Long contactUserId;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "createddate")
    private LocalDateTime createdDate;
}

