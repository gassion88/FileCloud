package com.gassion.filecloudbackend.user.profile.service.impl;

import com.gassion.filecloudbackend.user.profile.model.UserProfile;
import com.gassion.filecloudbackend.user.profile.repository.UserProfileRepository;
import com.gassion.filecloudbackend.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if (this.userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String.format("User ID = %d already exist", userProfile.getId());
            throw new RuntimeException(errorMessage);
        }

        if (this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
            String errorMessage = String.format("User Nickname = %s already exist", userProfile.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.userProfileRepository.save(userProfile);
    }

}
