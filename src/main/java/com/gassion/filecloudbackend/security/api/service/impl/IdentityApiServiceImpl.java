package com.gassion.filecloudbackend.security.api.service.impl;

import com.gassion.filecloudbackend.security.api.model.CurrentUserApiModel;
import com.gassion.filecloudbackend.security.api.service.IdentityApiService;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityApiServiceImpl implements IdentityApiService {

    private final UserAccountService userAccountService;

    public IdentityApiServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public Optional<CurrentUserApiModel> getCurrentUserAccount() {
        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        Authentication authentication = securityContextHolder.getAuthentication();

        if (authentication == null) {
            return Optional.empty();
        }

        String username = authentication.getName();

        return this.userAccountService.findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }

}
