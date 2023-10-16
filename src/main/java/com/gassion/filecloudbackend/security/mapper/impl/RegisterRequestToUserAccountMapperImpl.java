package com.gassion.filecloudbackend.security.mapper.impl;

import com.gassion.filecloudbackend.security.mapper.RegisterRequestToUserAccountMapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.model.UserRole;
import com.gassion.filecloudbackend.security.service.UserRoleService;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Set;

@Component
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {

    private final UserRoleService userRoleService;

    private final PasswordEncoder passwordEncoder;

    public RegisterRequestToUserAccountMapperImpl(UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount map(RegisterRequest source) {
        UserRole userRole = this.userRoleService.findUserRole().orElseThrow(() -> new RuntimeException("User role exception"));
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(source.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(this.passwordEncoder.encode(source.password()));
        userAccount.setAuthorities(Set.of(userRole));

        return userAccount;
    }

}
