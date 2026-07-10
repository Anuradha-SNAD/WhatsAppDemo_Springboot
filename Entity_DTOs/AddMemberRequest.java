package com.WhatApp.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddMemberRequest {

    @NotNull(message = "User Id is required")
    private Long userId;

    @NotNull(message = "IsAdmin is required")
    private Boolean isAdmin;


}
