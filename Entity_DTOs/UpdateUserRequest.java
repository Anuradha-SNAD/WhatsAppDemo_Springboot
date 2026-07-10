package com.WhatApp.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {

	@NotBlank(message = "User Name is required")
    private String userName;

    @NotBlank(message = "About is required")
    private String about;

    private String profilePhoto;

    private Boolean isOnline;


}
