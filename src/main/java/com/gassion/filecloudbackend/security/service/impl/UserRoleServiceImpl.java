package com.gassion.filecloudbackend.security.service.impl;

import com.gassion.filecloudbackend.security.model.UserRole;
import com.gassion.filecloudbackend.security.repository.UserRoleRepository;
import com.gassion.filecloudbackend.security.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }

}
