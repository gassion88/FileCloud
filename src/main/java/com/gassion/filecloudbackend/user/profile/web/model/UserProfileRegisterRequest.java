package com.gassion.filecloudbackend.user.profile.web.model;

import jakarta.validation.constraints.NotBlank;

public record UserProfileRegisterRequest(

        @NotBlank
        String nickname,

        @NotBlank
        String imageLink) {
}
