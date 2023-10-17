package com.gassion.filecloudbackend.security.service.impl;

import com.gassion.filecloudbackend.security.mapper.UserAccountToUserMapper;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    private final UserAccountToUserMapper userAccountToUserMapper;

    public UserDetailsServiceImpl(UserAccountService userAccountService, UserAccountToUserMapper userAccountToUserMapper) {
        this.userAccountService = userAccountService;
        this.userAccountToUserMapper = userAccountToUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService
                .findUserByUsername(username)
                .map(userAccountToUserMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));
    }

}
