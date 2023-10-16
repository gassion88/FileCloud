package com.gassion.filecloudbackend.security.mapper;

import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest>{
}
