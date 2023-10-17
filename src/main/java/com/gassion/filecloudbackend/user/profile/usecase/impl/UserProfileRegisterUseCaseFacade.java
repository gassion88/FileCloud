package com.gassion.filecloudbackend.user.profile.usecase.impl;

import com.gassion.filecloudbackend.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.gassion.filecloudbackend.user.profile.model.UserProfile;
import com.gassion.filecloudbackend.user.profile.service.UserProfileService;
import com.gassion.filecloudbackend.user.profile.usecase.UserProfileRegisterUseCase;
import com.gassion.filecloudbackend.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;

    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService, UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest userProfileRegisterRequest) {
        UserProfile userProfile = mapper.map(userProfileRegisterRequest);
        this.userProfileService.createUserProfile(userProfile);
    }

}
