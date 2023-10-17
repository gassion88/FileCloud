package com.gassion.filecloudbackend.security.service;

import com.gassion.filecloudbackend.security.model.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountService {

    void createUserAccount(UserAccount userAccount);

    Optional<UserAccount> findUserByUsername(String username);
}
