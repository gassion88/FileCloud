package com.gassion.filecloudbackend.security.usecase.impl;

import com.gassion.filecloudbackend.security.mapper.RegisterRequestToUserAccountMapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import com.gassion.filecloudbackend.security.usecase.RegisterUserAccountUseCase;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;
import com.gassion.filecloudbackend.storage.service.FolderService;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseImpl implements RegisterUserAccountUseCase {

    private final UserAccountService userAccountService;

    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;

    private final FolderService folderService;

    public RegisterUserAccountUseCaseImpl(UserAccountService userAccountService, RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper, FolderService folderService) {
        this.userAccountService = userAccountService;
        this.registerRequestToUserAccountMapper = registerRequestToUserAccountMapper;
        this.folderService = folderService;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
        folderService.createUserBucket(String.valueOf(userAccount.getId()));
    }

}
