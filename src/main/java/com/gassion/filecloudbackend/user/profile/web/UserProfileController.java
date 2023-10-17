package com.gassion.filecloudbackend.user.profile.web;

import com.gassion.filecloudbackend.user.profile.usecase.UserProfileRegisterUseCase;
import com.gassion.filecloudbackend.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileRegisterUseCase userProfileRegisterUseCase;

    public UserProfileController(UserProfileRegisterUseCase userProfileRegisterUseCase) {
        this.userProfileRegisterUseCase = userProfileRegisterUseCase;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest userProfileRegisterRequest) {
        this.userProfileRegisterUseCase.registerUserProfile(userProfileRegisterRequest);
    }

}
