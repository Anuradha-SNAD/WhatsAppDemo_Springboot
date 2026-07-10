package com.WhatApp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SendMessageRequest {

    @NotNull(message = "Chat Id is required")
    private Long chatId;

    @NotNull(message = "Sender Id is required")
    private Long senderId;

    @NotBlank(message = "Message Type is required")
    private String messageType;

    @NotBlank(message = "Message Content is required")
    private String messageContent;


}
