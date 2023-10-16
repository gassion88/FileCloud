package com.gassion.filecloudbackend.security.web;

import com.gassion.filecloudbackend.security.model.UserAccount;
import com.gassion.filecloudbackend.security.model.UserRole;
import com.gassion.filecloudbackend.security.service.UserAccountService;
import com.gassion.filecloudbackend.security.service.UserRoleService;
import com.gassion.filecloudbackend.security.web.model.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("api/v1/accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;

    private final UserRoleService userRoleService;

    private final PasswordEncoder passwordEncoder;

    public UserAccountController(UserAccountService userAccountService, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody RegisterRequest registerRequest) {
        Assert.hasLength(registerRequest.username(), "Username should not be null or empty");
        Assert.hasLength(registerRequest.password(), "Password should not be null or empty");

        UserRole userRole = this.userRoleService.findUserRole().orElseThrow(() -> new RuntimeException("User role exception"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        this.userAccountService.createUserAccount(userAccount);
    }
}
