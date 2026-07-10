package com.WhatApp.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateChatRequest {

	@NotNull(message = "IsGroup is required")
    private Boolean isGroup;

    private String groupName;

    private String groupDescription;

    @NotNull(message = "Created By is required")
    private Long createdBy;


}
