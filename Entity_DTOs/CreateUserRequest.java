package com.WhatApp.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequest {

@NotBlank(message = "Mobile Number is required")
    private String mobileNumber;

    @NotBlank(message = "User Name is required")
    private String userName;

    @NotBlank(message = "About is required")
    private String about;

    private String profilePhoto;


}
