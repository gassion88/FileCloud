package com.gassion.filecloudbackend.security.service;

import com.gassion.filecloudbackend.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
