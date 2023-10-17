package com.gassion.filecloudbackend.security.service.impl;

import com.gassion.filecloudbackend.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    public UserDetailsServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService
                .findUserByUsername(username)
                .map(userAccount -> new User(
                        userAccount.getUsername(),
                        userAccount.getPassword(),
                        userAccount.getAuthorities()
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));
    }

}
