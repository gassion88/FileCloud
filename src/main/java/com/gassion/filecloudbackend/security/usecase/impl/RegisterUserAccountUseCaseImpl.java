package com.gassion.filecloudbackend.security.usecase.impl;

import com.gassion.filecloudbackend.security.mapper.RegisterRequestToUserAccountMapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import com.gassion.filecloudbackend.security.usecase.RegisterUserAccountUseCase;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseImpl implements RegisterUserAccountUseCase {

    private final UserAccountService userAccountService;

    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;

    public RegisterUserAccountUseCaseImpl(UserAccountService userAccountService, RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper) {
        this.userAccountService = userAccountService;
        this.registerRequestToUserAccountMapper = registerRequestToUserAccountMapper;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }

}
