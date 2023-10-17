package com.gassion.filecloudbackend.security.mapper.impl;

import com.gassion.filecloudbackend.security.mapper.UserAccountToUserMapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {

    @Override
    public User map(UserAccount source) {
        return new User(
                source.getUsername(),
                source.getPassword(),
                source.getAuthorities()
        );
    }

}
