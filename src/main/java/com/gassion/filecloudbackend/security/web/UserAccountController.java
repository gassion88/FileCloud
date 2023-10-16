package com.gassion.filecloudbackend.security.web;

import com.gassion.filecloudbackend.security.mapper.RegisterRequestToUserAccountMapper;
import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;

    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;


    public UserAccountController(UserAccountService userAccountService, RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper) {
        this.userAccountService = userAccountService;
        this.registerRequestToUserAccountMapper = registerRequestToUserAccountMapper;
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
