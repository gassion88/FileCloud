package com.gassion.filecloudbackend.security.mapper;

import com.gassion.filecloudbackend.common.mapper.Mapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {

}
