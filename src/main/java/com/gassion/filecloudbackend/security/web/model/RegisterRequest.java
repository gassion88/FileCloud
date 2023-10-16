package com.gassion.filecloudbackend.security.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

        @Email(message = "Not valid format email")
        @NotBlank(message = "Username should not be null or empty")
        String username,

        @NotBlank(message = "Password should not be null or empty")
        String password) {

}
