package com.gassion.filecloudbackend.user.profile.usecase;

import com.gassion.filecloudbackend.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {

    void registerUserProfile(UserProfileRegisterRequest userProfileRegisterRequest);

}
