package com.WhatApp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateContactRequest {

    @NotNull(message = "User Id is required")
    private Long userId;

    @NotNull(message = "Contact User Id is required")
    private Long contactUserId;

    @NotBlank(message = "Nick Name is required")
    private String nickName;


}
