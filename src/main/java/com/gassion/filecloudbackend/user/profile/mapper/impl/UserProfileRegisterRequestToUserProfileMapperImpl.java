package com.gassion.filecloudbackend.user.profile.mapper.impl;

import com.gassion.filecloudbackend.security.api.model.CurrentUserApiModel;
import com.gassion.filecloudbackend.security.api.service.IdentityApiService;
import com.gassion.filecloudbackend.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.gassion.filecloudbackend.user.profile.model.UserProfile;
import com.gassion.filecloudbackend.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl implements UserProfileRegisterRequestToUserProfileMapper {

    private final IdentityApiService identityApiService;

    public UserProfileRegisterRequestToUserProfileMapperImpl(IdentityApiService identityApiService) {
        this.identityApiService = identityApiService;
    }

    @Override
    public UserProfile map(UserProfileRegisterRequest source) {
        CurrentUserApiModel currentUserApiModel = this.identityApiService
                .getCurrentUserAccount()
                .orElseThrow(() -> new RuntimeException("Для создания профиля пользователь должен быть авторизован"));

        UserProfile userProfile = new UserProfile();
        userProfile.setNickname(source.nickname());
        userProfile.setImageLink(source.imageLink());
        userProfile.setId(currentUserApiModel.currentUserAccountId());

        return userProfile;
    }

}
